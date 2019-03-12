package br.com.fwtj.MavenJSfPrimefaces.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class HibernateSessionSistemaProducer {

    private SessionFactory sessionFactory;

    public HibernateSessionSistemaProducer() {
        Map<String, String> properties = new HashMap<>();
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5433/sistema?ApplicationName=Sistema");
        properties.put(Environment.C3P0_MIN_SIZE, "1");
        properties.put(Environment.C3P0_MAX_SIZE, "1");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SISTEMA", properties);
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    @Produces
    @SessionSistemaInject
    @ApplicationScoped
    public SessionFactory getSessionFactory() {
        System.out.println("HibernateSessionSistemaProducer.getSessionFactory()");
        return sessionFactory;
    }

    @Produces
    @SessionSistemaInject
    @RequestScoped
    public Session getSession() {
        System.out.println("HibernateSessionSistemaProducer.getSession()");
        Session session = sessionFactory.openSession();
        return session;
    }

    public void closeSession(@Disposes @SessionSistemaInject Session session) {
        System.out.println("HibernateSessionSistemaProducer.closeSession()");
        session.close();
    }


}
