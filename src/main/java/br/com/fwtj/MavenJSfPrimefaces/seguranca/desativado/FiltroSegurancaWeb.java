//package br.com.fwtj.MavenJSfPrimefaces.seguranca;
//
//import java.io.IOException;
//
//import javax.faces.application.ResourceHandler;
//import javax.inject.Inject;
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebFilter(filterName = "FiltroSegurancaWeb", urlPatterns = {"*.xhtml"})
//public class FiltroSegurancaWeb implements Filter {
//
//    private String contexoAplicacao = "";
//    private final String paginaLogin = "/login.xhtml";
//    private final String paginaNegado = "/negado.xhtml";
//
//    @Inject
//    private UsuarioLogado usuarioLogado;
//
//    @Override
//    public void init(FilterConfig filterConfig) {
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
//
//        try {
//            HttpServletRequest request = (HttpServletRequest) req;
//            HttpServletResponse response = (HttpServletResponse) res;
//            contexoAplicacao = request.getContextPath();
//            String loginURL = contexoAplicacao + paginaLogin;
//            String requestURI = request.getRequestURI();
//
//            boolean requisicaoResource = requestURI.startsWith(contexoAplicacao + ResourceHandler.RESOURCE_IDENTIFIER);
//            boolean requisicaoLogin = requestURI.startsWith(loginURL);
//            boolean logado = usuarioLogado.isLogado();
//            boolean paginaAutorizada = false;
//
//            for (PaginasEnum paginasEnum : usuarioLogado.getPaginasEnums()) {
//                if (paginasEnum.getUrl().equalsIgnoreCase(requestURI)) {
//                    paginaAutorizada = true;
//                    break;
//                }
//            }
//
//            if (requisicaoLogin) {
//                chain.doFilter(request, response);
//            } else if (logado) {
//                if (paginaAutorizada) {
//                    chain.doFilter(request, response);
//                } else {
//                    response.sendRedirect(contexoAplicacao + paginaNegado);
//                }
//            } else {
//                response.sendRedirect(contexoAplicacao + paginaLogin);
//            }
//        } catch (IOException | ServletException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//    }
//}
