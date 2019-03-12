package br.com.fwtj.MavenJSfPrimefaces.jpa;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class HibernateSessionTenantProducer {

    private SessionFactory sessionFactory;

    public HibernateSessionTenantProducer() {
        Map<String, String> properties = new HashMap<>();
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5433/sistema?ApplicationName=Tenant");
        properties.put(Environment.C3P0_MIN_SIZE, "10");
        properties.put(Environment.C3P0_MAX_SIZE, "100");
        properties.put(Environment.MULTI_TENANT, MultiTenancyStrategy.SCHEMA.name());
        properties.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, "br.com.fwtj.MavenJSfPrimefaces.jpa.MultiTenantProvider");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SISTEMA", properties);
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    @Produces
    @ApplicationScoped
    public SessionFactory getSessionFactory() {
        System.out.println("HibernateSessionTenantProducer.getSessionFactory()");
        return sessionFactory;
    }

    @Inject
    @TenantInject
    private Tenant tenant;

    @Produces
    @RequestScoped
    public Session getSession() {
        System.out.println("HibernateSessionTenantProducer.getSession()");
        String tenantId = tenant.getId();
        Session session = sessionFactory.withOptions().tenantIdentifier(tenantId).openSession();
        return session;
    }

    public void closeSession(@Disposes Session session) {
        System.out.println("HibernateSessionTenantProducer.closeSession()");
        session.close();
    }


}
