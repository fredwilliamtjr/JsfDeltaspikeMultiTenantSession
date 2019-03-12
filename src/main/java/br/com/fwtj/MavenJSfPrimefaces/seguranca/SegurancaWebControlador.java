package br.com.fwtj.MavenJSfPrimefaces.seguranca;


import br.com.fwtj.MavenJSfPrimefaces.bean.DadosUsuarioLogadoBean;
import br.com.fwtj.MavenJSfPrimefaces.modelo.Pagina;
import org.apache.deltaspike.security.api.authorization.AccessDecisionVoter;
import org.apache.deltaspike.security.api.authorization.AccessDecisionVoterContext;
import org.apache.deltaspike.security.api.authorization.SecurityViolation;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named
@SessionScoped
public class SegurancaWebControlador implements AccessDecisionVoter {

    @Inject
    private DadosUsuarioLogadoBean dadosUsuarioLogadoBean;

    @Override
    public Set<SecurityViolation> checkPermission(AccessDecisionVoterContext accessDecisionVoterContext) {

        String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        String emailUsuario = "Não Logado";
        List<Pagina> paginas = new ArrayList<>();

        if (dadosUsuarioLogadoBean != null && dadosUsuarioLogadoBean.getUsuario() != null && dadosUsuarioLogadoBean.getLogin() != null) {
            emailUsuario = dadosUsuarioLogadoBean.getUsuario().getEmail();
            paginas = dadosUsuarioLogadoBean.getLogin().getPaginas();
        }
        System.out.println("SegurancaWebControlador : " + viewId + ", E-Mail : " + emailUsuario);

        Set<SecurityViolation> violations = new HashSet<>();

        boolean paginaLiberada = isPaginaLiberada(viewId, paginas);

        if (!paginaLiberada) {
            SecurityViolation violation = new SecurityViolation() {
                @Override
                public String getReason() {
                    return "Acesso não permitido!";
                }
            };
            violations.add(violation);
        }

        return violations;
    }

    private boolean isPaginaLiberada(String pagina, List<Pagina> paginas) {

        pagina = pagina.replace("/", "").replaceFirst(".xhtml", "");

        boolean retorno = false;

        if (
                pagina.equalsIgnoreCase("login") ||
                        pagina.equalsIgnoreCase("error") ||
                        pagina.equalsIgnoreCase("error2") ||
                        pagina.equalsIgnoreCase("naologado") ||
                        pagina.equalsIgnoreCase("negado") ||
                        pagina.equalsIgnoreCase("p404")
        ) {
            retorno = true;
        }

        boolean contains = paginas.contains(new Pagina(pagina));
        if (contains) {
            retorno = true;
        }

        return retorno;

    }

}
