//package br.com.fwtj.MavenJSfPrimefaces.seguranca.desativado;
//
//import br.com.fwtj.MavenJSfPrimefaces.seguranca.desativado.PaginasEnum;
//import org.apache.deltaspike.data.api.audit.CurrentUser;
//
//import javax.enterprise.context.SessionScoped;
//import javax.enterprise.inject.Produces;
//import javax.inject.Named;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//@Named
//@SessionScoped
//public class UsuarioLogado implements Serializable {
//
//    private boolean logado = false;
//    private boolean api = false;
//    private boolean admin = false;
//    private String username;
//    List<PaginasEnum> paginasEnums = new ArrayList<>();
//
//    public boolean isLogado() {
//        return logado;
//    }
//
//    public void setLogado(boolean logado) {
//        this.logado = logado;
//    }
//
//    public boolean isApi() {
//        return api;
//    }
//
//    public void setApi(boolean api) {
//        this.api = api;
//    }
//
//    public boolean isAdmin() {
//        return admin;
//    }
//
//    public void setAdmin(boolean admin) {
//        this.admin = admin;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public List<PaginasEnum> getPaginasEnums() {
//        return paginasEnums;
//    }
//
//    public void setPaginasEnums(List<PaginasEnum> paginasEnums) {
//        this.paginasEnums = paginasEnums;
//    }
//
//    /** Injeta dados do usuario na auditoria  */
//    @Produces
//    @CurrentUser
//    public String currentUser() {
//        return username;
//    }
//
//    @Override
//    public String toString() {
//        return "UsuarioLogado{" +
//                "logado=" + logado +
//                ", api=" + api +
//                ", paginasEnums=" + paginasEnums +
//                '}';
//    }
//}
