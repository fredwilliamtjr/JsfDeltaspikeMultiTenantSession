package br.com.fwtj.MavenJSfPrimefaces.util.jsf;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;

public class FacesUtil {


    public static boolean isPostback() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public static boolean isNotPostback() {
        return !isPostback();
    }

    public static void addErrorMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
    }

    public static void addInfoMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
    }

    public static void addWarnMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN, message, message));
    }

    public static void addFatalMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL, message, message));
    }

    /** Direciona para outra pagina matendo a url  */
    public static void forward(String uri) {
        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        handler.performNavigation(uri);
    }

    /** Direciona para outra pagina mudando a url  */
    public static void redirect(String uri) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect(uri);
    }

}