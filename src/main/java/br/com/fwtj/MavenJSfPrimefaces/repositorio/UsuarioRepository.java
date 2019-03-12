package br.com.fwtj.MavenJSfPrimefaces.repositorio;

import br.com.fwtj.MavenJSfPrimefaces.modelo.Usuario;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.hibernate.Session;

import javax.inject.Inject;

public abstract class UsuarioRepository extends AbstractEntityRepository<Usuario, Long> {

    @Inject
    private Session session;


}
