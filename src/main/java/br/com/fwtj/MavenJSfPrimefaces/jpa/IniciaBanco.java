package br.com.fwtj.MavenJSfPrimefaces.jpa;

import br.com.fwtj.MavenJSfPrimefaces.aplicativo.QualificadorStartup;
import org.hibernate.SessionFactory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.io.Serializable;


public class IniciaBanco implements Serializable {

    @Inject
    @SessionSistemaInject
    private SessionFactory sessionFactorySistema;

    @QualificadorStartup
    @Produces
    private IniciaBanco iniciaHibernateSessionSistemaProducer() {
        boolean open = sessionFactorySistema.isOpen();
        System.out.println("Iniciado HibernateSessionSistemaProducer : " + open);
        return this;
    }

    @Inject
    private SessionFactory sessionFactoryTenant;

    @QualificadorStartup
    @Produces
    private IniciaBanco iniciaHibernateSessionTenantProducer() {
        boolean open = sessionFactoryTenant.isOpen();
        System.out.println("Iniciado HibernateSessionTenantProducer : " + open);
        return this;
    }

}
