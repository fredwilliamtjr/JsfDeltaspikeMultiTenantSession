package br.com.fwtj.MavenJSfPrimefaces.jpa;


import org.apache.deltaspike.jpa.api.entitymanager.EntityManagerResolver;
import org.hibernate.Session;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class HibernateSessionSistemaResolver implements EntityManagerResolver {

    @Inject
    @SessionSistemaInject
    private Session session;

    @Override
    public EntityManager resolveEntityManager() {
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        return entityManager;
    }
}
