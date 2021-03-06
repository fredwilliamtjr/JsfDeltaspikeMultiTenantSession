package br.com.fwtj.MavenJSfPrimefaces.repositorio;

import br.com.fwtj.MavenJSfPrimefaces.jpa.HibernateSessionSistemaResolver;
import br.com.fwtj.MavenJSfPrimefaces.jpa.SessionSistemaInject;
import br.com.fwtj.MavenJSfPrimefaces.modelo.Configuracao;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.jpa.api.entitymanager.EntityManagerConfig;
import org.hibernate.Session;

import javax.inject.Inject;
import javax.persistence.FlushModeType;

@EntityManagerConfig(entityManagerResolver = HibernateSessionSistemaResolver.class, flushMode = FlushModeType.COMMIT)
public abstract class ConfiguracaoRepository extends AbstractEntityRepository<Configuracao, Long> {

    @Inject
    @SessionSistemaInject
    private Session session;


}
