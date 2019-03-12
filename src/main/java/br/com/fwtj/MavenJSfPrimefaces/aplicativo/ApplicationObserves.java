package br.com.fwtj.MavenJSfPrimefaces.aplicativo;

import org.apache.deltaspike.core.api.lifecycle.Destroyed;
import org.apache.deltaspike.core.api.lifecycle.Initialized;
import org.apache.deltaspike.jsf.api.listener.phase.AfterPhase;
import org.apache.deltaspike.jsf.api.listener.phase.BeforePhase;
import org.apache.deltaspike.jsf.api.listener.phase.JsfPhaseId;

import javax.enterprise.event.Observes;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.PreDestroyApplicationEvent;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@Named
@ApplicationScoped
public class ApplicationObserves implements Serializable {

//    public void onCreate(@Observes @Initialized ServletContext context) {
//        System.out.println("Initialized ServletContext: " + context.getServletContextName());
//    }
//
//    public void onDestroy(@Observes @Destroyed ServletContext context) {
//        System.out.println("Destroyed ServletContext: " + context.getServletContextName());
//    }
//
//    public void onCreate(@Observes @Initialized HttpServletRequest request) {
//        System.out.println("Starting to process request for: " + request.getRequestURI());
//    }
//
//    public void onDestroy(@Observes @Destroyed HttpServletRequest request) {
//        System.out.println("Finished processing request for: " + request.getRequestURI());
//    }
//
//    public void onCreate(@Observes @Initialized HttpServletResponse response) {
//        System.out.println("HttpServletResponse created");
//    }
//
//    public void onDestroy(@Observes @Destroyed HttpServletResponse response) {
//        System.out.println("HttpServletResponse destroyed");
//    }
//
//    public void onCreate(@Observes @Initialized HttpSession session) {
//        System.out.println("Session created: " + session.getId());
//    }
//
//    public void onDestroy(@Observes @Destroyed HttpSession session) {
//        System.out.println("Session destroyed: " + session.getId());
//    }
//
//    public void onPostConstructApplicationEvent(@Observes PostConstructApplicationEvent event) {
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> onPostConstructApplicationEvent : " + event.toString());
//    }
//
//    public void onPreDestroyApplicationEvent(@Observes PreDestroyApplicationEvent event) {
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> onPreDestroyApplicationEvent : " + event.toString());
//    }
//
//    public void onExceptionQueuedEvent(@Observes ExceptionQueuedEvent event) {
//         System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> onExceptionQueuedEvent : " + event.toString());
//    }
//
//    public void onInitializedFacesRequest(@Observes @Initialized FacesContext facesContext) {
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> onInitializedFacesRequest");
//    }
//
//    public void onDestroyedFacesRequest(@Observes @Destroyed FacesContext facesContext) {
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> onDestroyedFacesRequest");
//    }
//
//    public void onBeforePhase(@Observes @BeforePhase(JsfPhaseId.ANY_PHASE) PhaseEvent event) {
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> onBeforePhase");
//    }
//
//    public void onAfterPhase(@Observes @AfterPhase(JsfPhaseId.ANY_PHASE) PhaseEvent event) {
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> onAfterPhase");
//    }


}
