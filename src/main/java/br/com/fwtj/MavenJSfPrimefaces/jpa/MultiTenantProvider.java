package br.com.fwtj.MavenJSfPrimefaces.jpa;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.c3p0.internal.C3P0ConnectionProvider;
import org.hibernate.cfg.Environment;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.service.spi.Configurable;
import org.hibernate.service.spi.ServiceRegistryAwareService;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.hibernate.service.spi.Stoppable;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiTenantProvider implements MultiTenantConnectionProvider, Stoppable, ServiceRegistryAwareService {

    private static final long serialVersionUID = 1L;

    private ConnectionProvider connectionProvider = null;

    @Override
    public boolean isUnwrappableAs(Class unwrapType) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        return null;
    }

    @Override
    public void injectServices(ServiceRegistryImplementor serviceRegistry) {
        Map lSettings = serviceRegistry.getService(ConfigurationService.class).getSettings();

        connectionProvider = new C3P0ConnectionProvider();
        Class<?> providerClass = connectionProvider.getClass();
        if (!Configurable.class.isAssignableFrom(providerClass) ||
                !Stoppable.class.isAssignableFrom(providerClass) ||
                !ServiceRegistryAwareService.class.isAssignableFrom(providerClass)) {
            throw new RuntimeException("The provider '" + providerClass
                    + "' needs to implment the intrefaces: Configurable, Stoppable, ServiceRegistryAwareService");
        }

        ((ServiceRegistryAwareService) connectionProvider).injectServices(serviceRegistry);
        ((Configurable) connectionProvider).configure(lSettings);
    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        return connectionProvider.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        try {
            connection.createStatement().execute("SET SCHEMA 'public'");
        } catch (Exception e) {
            throw new HibernateException("Could not alter JDBC connection to specified schema [public]", e);
        }
        connectionProvider.closeConnection(connection);

    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        final Connection connection = getAnyConnection();

        List<Tenant> tenantList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select schema_name from information_schema.schemata");
        while (resultSet.next()) {
            String resultSetString = resultSet.getString(1);
            Tenant tenant = new Tenant(resultSetString);
            tenantList.add(tenant);
        }
        statement.close();
        boolean contains = tenantList.contains(new Tenant(tenantIdentifier));
        System.out.println("contains : " + contains);

        if (!contains) {
            criarSchema(tenantIdentifier);
            criarTabelas(tenantIdentifier);
        }

        try {
            boolean execute = connection.createStatement().execute("SET SCHEMA '" + tenantIdentifier + "'");
        } catch (Exception e) {
            throw new HibernateException("Could not alter JDBC connection to specified schema [" + tenantIdentifier + "]", e);
        }

        return connection;
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        releaseAnyConnection(connection);
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public void stop() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> STOP <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        ((Stoppable) connectionProvider).stop();
    }

    private void criarSchema(String schemaName) {
        Connection connection = null;
        Statement statement = null;
        try {
            String IP_BANCO_DADOS = "localhost";
            String PORTA_BANCO_DADOS = "5433";
            String NOME_BANCO_DADOS_CLIENTE = "sistema";
            String USUARIO_SISTEMA_BANCO_DADOS = "user";
            String SENHA_SISTEMA_BANCO_DADOS = "123456";

            connection = DriverManager.getConnection("jdbc:postgresql://" + IP_BANCO_DADOS + ":" + PORTA_BANCO_DADOS + "/" + NOME_BANCO_DADOS_CLIENTE, USUARIO_SISTEMA_BANCO_DADOS, SENHA_SISTEMA_BANCO_DADOS);
            statement = connection.createStatement();
            int executeUpdate0 = statement.executeUpdate("CREATE SCHEMA \"" + schemaName + "\" AUTHORIZATION \"" + USUARIO_SISTEMA_BANCO_DADOS + "\";");
            int executeUpdate1 = statement.executeUpdate("GRANT ALL ON SCHEMA \"" + schemaName + "\" TO \"" + USUARIO_SISTEMA_BANCO_DADOS + "\";");
            statement.close();
            connection.close();
        } catch (Exception e) {
            try {
                statement.close();
                connection.close();
            } catch (Exception ignored) {

            }

        }

    }

    private void criarTabelas(String schemaName) {
        Map<String, String> properties = new HashMap<>();
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5433/sistema?ApplicationName=SistemaCriarTabelas");
        properties.put(Environment.C3P0_MIN_SIZE, "1");
        properties.put(Environment.C3P0_MAX_SIZE, "1");
        properties.put("hibernate.default_schema", schemaName);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SISTEMA", properties);
        SessionFactory sessionFactory = factory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();
        session.close();
        sessionFactory.close();
        factory.close();
        properties = null;
        factory = null;
        sessionFactory = null;
        session = null;
    }


}
