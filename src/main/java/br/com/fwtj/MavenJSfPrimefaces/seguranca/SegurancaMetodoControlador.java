package br.com.fwtj.MavenJSfPrimefaces.seguranca;


import br.com.fwtj.MavenJSfPrimefaces.bean.DadosUsuarioLogadoBean;
import br.com.fwtj.MavenJSfPrimefaces.modelo.Usuario;
import org.apache.deltaspike.security.api.authorization.Secures;

import javax.interceptor.InvocationContext;

public class SegurancaMetodoControlador {

    @Secures
    @QualificadorMetodoProtegido
    public boolean doSecuredCheck(InvocationContext invocationContext, DadosUsuarioLogadoBean dadosUsuarioLogadoBean) {
        String name = invocationContext.getMethod().getName();
        System.out.println(name);
        boolean logado = dadosUsuarioLogadoBean.isLogado();
        Usuario usuario = dadosUsuarioLogadoBean.getUsuario();

        if (logado && usuario != null && usuario.isAdmin()) {
            return true;
        } else {
            return false;
        }

    }

}
