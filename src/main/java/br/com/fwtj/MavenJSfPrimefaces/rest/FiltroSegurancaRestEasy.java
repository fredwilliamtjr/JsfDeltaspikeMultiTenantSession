package br.com.fwtj.MavenJSfPrimefaces.rest;


import br.com.fwtj.MavenJSfPrimefaces.bean.DadosUsuarioLogadoBean;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.util.Base64;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Autor: Fred William Torno Junior
 * E-Mail: fredwilliam@gmail.com / fredwilliam@outlook.com
 * Site: www.fwtj.com.br
 * Telefone: (22) 9-8136-5786
 * Data: 18/04/2018
 * Hora: 21:13
 * Copyright©Fwtj Sistemas. Todos os direitos reservados.
 */

@Provider
public class FiltroSegurancaRestEasy implements javax.ws.rs.container.ContainerRequestFilter {
    private static final String AUTHORIZATION_PROPERTY = "Authorization";
    private static final String AUTHENTICATION_SCHEME = "Basic";
    private static final ServerResponse AUTHENTICATION_INVALID = new ServerResponse(new RespostaRest("Autenticação invalida!"), Response.Status.UNAUTHORIZED.getStatusCode(), new Headers<>());
    private static final ServerResponse ACCESS_DENIED = new ServerResponse(new RespostaRest("Necessário autenticação!"), Response.Status.UNAUTHORIZED.getStatusCode(), new Headers<>());
    private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse(new RespostaRest("Bloqueado para todos!"), Response.Status.UNAUTHORIZED.getStatusCode(), new Headers<>());
    private static final ServerResponse SERVER_ERROR = new ServerResponse(new RespostaRest("Erro Interno!"), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), new Headers<>());

    @Override
    public void filter(ContainerRequestContext requestContext) {
        ResourceMethodInvoker methodInvoker = (ResourceMethodInvoker) requestContext.getProperty("org.jboss.resteasy.core.ResourceMethodInvoker");
        Method method = methodInvoker.getMethod();
        //Access allowed for all
        if (!method.isAnnotationPresent(PermitAll.class)) {
            //Access denied for all
            if (method.isAnnotationPresent(DenyAll.class)) {
                requestContext.abortWith(ACCESS_FORBIDDEN);
                return;
            }

            //Get request headers
            final MultivaluedMap<String, String> headers = requestContext.getHeaders();

            //Fetch authorization header
            final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

            //If no authorization information present; block access
            if (authorization == null || authorization.isEmpty()) {
                requestContext.abortWith(ACCESS_DENIED);
                return;
            }

            //Get encoded username and password
            final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");

            //Decode username and password
            String usernameAndPassword = null;
            try {
                usernameAndPassword = new String(Base64.decode(encodedUserPassword));
            } catch (IOException e) {
                requestContext.abortWith(SERVER_ERROR);
                return;
            }

            //Split username and password tokens
            final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
            final String username = tokenizer.nextToken();
            final String password = tokenizer.nextToken();

            //Verifying Username and password
            System.out.println(username);
            System.out.println(password);

            //Verify user access
            if (method.isAnnotationPresent(RolesAllowed.class)) {
                RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

                //Is user valid?
                if (!isUserAllowed(username, password, rolesSet)) {
                    requestContext.abortWith(AUTHENTICATION_INVALID);
                    return;
                }
            } else {
                requestContext.abortWith(SERVER_ERROR);
                return;
            }
        }
    }

    private boolean isUserAllowed(final String username, final String password, final Set<String> rolesSet) {

        DadosUsuarioLogadoBean dadosUsuarioLogadoBean = BeanProvider.getContextualReference(DadosUsuarioLogadoBean.class, false);
        System.out.println(dadosUsuarioLogadoBean);


        System.out.println("Login API : " + username);
        System.out.println("Senha   API : " + password);
        rolesSet.forEach(s -> System.out.println("Role : " + s));

//        BUSCAR USUARIO NO BANCO E VERIFICAR SE PODE ACESSAR API
//        final UsuarioServico usuarioServico = CDIServiceLocator.getBean(UsuarioServico.class);
//        Login usuarioPorEmailPorSenha = usuarioServico.porEmailPorSenhaDescriptografada(username, password);

        return true;
    }

}
