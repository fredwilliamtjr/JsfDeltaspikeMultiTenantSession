package br.com.fwtj.MavenJSfPrimefaces.jpa;

import br.com.fwtj.MavenJSfPrimefaces.bean.DadosUsuarioLogadoBean;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@RequestScoped
public class TenantProducer {

    @Inject
    private DadosUsuarioLogadoBean dadosUsuarioLogadoBean;

    @Produces
    @RequestScoped
    @TenantInject
    public Tenant getTenant() {

        Tenant tenant = new Tenant("public");

//        FacesContext currentInstance = FacesContext.getCurrentInstance();
//        if (currentInstance != null) {
//            ExternalContext externalContext = currentInstance.getExternalContext();
//            if (externalContext != null) {
//                HttpSession sessao = (HttpSession) externalContext.getSession(false);
//                if (sessao != null) {
//                    Object attribute = sessao.getAttribute("tenant");
//                    if (attribute != null) {
//                        String tenantString = (String) attribute;
//                        if (!tenantString.isEmpty()) {
//                            tenant = new Tenant(tenantString);
//                        }
//                    }
//                }
//            }
//        }

        if (dadosUsuarioLogadoBean.getLogin() != null) {
            String schemaName = dadosUsuarioLogadoBean.getLogin().getSchemaName();
            tenant = new Tenant(schemaName);
        }

        return tenant;

    }


}
