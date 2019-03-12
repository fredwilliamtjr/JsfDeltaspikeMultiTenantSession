package br.com.fwtj.MavenJSfPrimefaces.repositorio;

import br.com.fwtj.MavenJSfPrimefaces.modelo.Produto;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.hibernate.Session;

import javax.inject.Inject;

public abstract class ProdutoRepository extends AbstractEntityRepository<Produto, Long> {

    @Inject
    private Session session;


}
