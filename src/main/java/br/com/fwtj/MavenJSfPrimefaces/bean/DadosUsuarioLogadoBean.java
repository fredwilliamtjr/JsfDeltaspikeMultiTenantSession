package br.com.fwtj.MavenJSfPrimefaces.bean;

import br.com.fwtj.MavenJSfPrimefaces.modelo.Usuario;
import br.com.fwtj.MavenJSfPrimefaces.modelo.Login;
import org.apache.deltaspike.data.api.audit.CurrentUser;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class DadosUsuarioLogadoBean implements Serializable {

    private Login login;
    private Usuario usuario;
    private boolean logado = false;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }


    /**
     * Injeta dados do login na auditoria
     */
    @Produces
    @CurrentUser
    public String currentUser() {
        if (usuario != null) {
            return usuario.getEmail();
        } else {
            return "Não Logado";
        }

    }

    @Override
    public String toString() {
        return "DadosUsuarioLogadoBean{" +
                "login=" + login +
                ", usuario=" + usuario +
                ", logado=" + logado +
                '}';
    }
}
