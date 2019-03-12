package br.com.fwtj.MavenJSfPrimefaces.aplicativo;

import br.com.fwtj.MavenJSfPrimefaces.util.jsf.FacesUtil;
import org.apache.deltaspike.core.api.exception.control.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.Handles;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionEvent;
import org.apache.deltaspike.security.api.authorization.AccessDeniedException;
import org.apache.deltaspike.security.api.authorization.ErrorViewAwareAccessDeniedException;

import javax.el.ELException;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@ExceptionHandler
@SessionScoped
@Named
public class ApplicationExceptionHandler implements Serializable {


    public void handleException(@Handles ExceptionEvent<Exception> event) {
        try {
            System.out.println(event.getException().getMessage());
            FacesUtil.addErrorMessage(event.getException().getMessage());
            FacesUtil.redirect("/error");
        } catch (IOException ignored) {
        }
        event.handled();
    }

    public void handleELException(@Handles ExceptionEvent<ELException> event) {
        try {
            FacesUtil.addErrorMessage(event.getException().getMessage());
            FacesUtil.redirect("/error2");
        } catch (IOException ignored) {
        }
        event.handled();
    }

    public void handleAccessDeniedException(@Handles ExceptionEvent<AccessDeniedException> event) {
        if (event.getException().getMessage() != null) {
            FacesUtil.addErrorMessage(event.getException().getMessage());
        }
        event.handled();
    }

    public void handleErrorViewAwareAccessDeniedException(@Handles ExceptionEvent<ErrorViewAwareAccessDeniedException> event) {
        try {
            FacesUtil.addErrorMessage("Acesso não permitido!");
            FacesUtil.redirect("/negado");
            FacesUtil.addErrorMessage("Acesso não permitido!");
        } catch (IOException ignored) {
        }
        event.handled();
    }


}
