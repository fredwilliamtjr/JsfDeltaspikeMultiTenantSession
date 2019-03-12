package br.com.fwtj.MavenJSfPrimefaces.bean;

import br.com.fwtj.MavenJSfPrimefaces.aplicativo.ApplicationResources;
import br.com.fwtj.MavenJSfPrimefaces.modelo.Empresa;
import br.com.fwtj.MavenJSfPrimefaces.modelo.Login;
import br.com.fwtj.MavenJSfPrimefaces.modelo.Pagina;
import br.com.fwtj.MavenJSfPrimefaces.modelo.Usuario;
import br.com.fwtj.MavenJSfPrimefaces.repositorio.LoginRepository;
import br.com.fwtj.MavenJSfPrimefaces.repositorio.UsuarioRepository;
import br.com.fwtj.MavenJSfPrimefaces.seguranca.QualificadorMetodoProtegido;
import br.com.fwtj.MavenJSfPrimefaces.util.jsf.FacesUtil;
import br.com.fwtj.MavenJSfPrimefaces.util.jsf.SessionUtil;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionToCatchEvent;

import javax.enterprise.event.Event;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;


@Named
@ViewScoped
public class LoginBean implements Serializable {

    @Inject
    private DadosUsuarioLogadoBean dadosUsuarioLogadoBean;

    @Inject
    private Event<ExceptionToCatchEvent> catchEvent;

    @Inject
    private ApplicationResources applicationResources;

    @Inject
    private LoginRepository loginRepository;

    @Inject
    private UsuarioRepository usuarioRepository;

    public ApplicationResources getApplicationResources() {
        return applicationResources;
    }

    private String email = "1@1.com";
    private String senha = "1";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void registro(){

        Empresa empresaMatrizRegistro = new Empresa("SMARTFULL SISTEMAS", "29426442000115");

        Login login1 = new Login("1@1.com", "1", empresaMatrizRegistro.getCnpj(), true);
        login1.getPaginas().add(new Pagina("index"));
        login1.getPaginas().add(new Pagina("dadosUsuario"));
        login1.getPaginas().add(new Pagina("graficoGoogleChartBarra"));
        login1.getPaginas().add(new Pagina("graficoGoogleChartPizza"));
        Login loginRegistro = loginRepository.save(login1);

        Empresa empresa2 = new Empresa("LM INFORMATICA", "40251563000177");

        Usuario usuario1 = new Usuario(loginRegistro.getEmail(), false, empresaMatrizRegistro);
        //empresa1.getUsuarios().add(usuario1);
        //empresa2.getUsuarios().add(usuario1);
        usuario1.getEmpresas().add(empresaMatrizRegistro);
        usuario1.getEmpresas().add(empresa2);

        dadosUsuarioLogadoBean.setLogin(loginRegistro);

        Usuario usuario1Salvo = usuarioRepository.save(usuario1);

        dadosUsuarioLogadoBean.setLogin(null);
        dadosUsuarioLogadoBean.setLogado(false);
        dadosUsuarioLogadoBean.setUsuario(null);


    }


//    Login loginSalvo;
//    Empresa empresaMatriz;
//
//    public void preparaLogin() {
//
//        empresaMatriz = new Empresa("SMARTFULL SISTEMAS", "29426442000115");
//
//        Login login1 = new Login("1@1.com", "1", empresaMatriz.getCnpj(), true);
//        login1.getPaginas().add(new Pagina("index"));
//        login1.getPaginas().add(new Pagina("dadosUsuario"));
//        login1.getPaginas().add(new Pagina("graficoGoogleChartBarra"));
//        login1.getPaginas().add(new Pagina("graficoGoogleChartPizza"));
//        loginSalvo = loginRepository.save(login1);
//
//    }

//    public void preparaUsuario() {
//
//        Empresa empresa2 = new Empresa("LM INFORMATICA", "40251563000177");
//
//        Usuario usuario1 = new Usuario(loginSalvo.getEmail(), false, empresaMatriz);
//        //empresa1.getUsuarios().add(usuario1);
//        //empresa2.getUsuarios().add(usuario1);
//        usuario1.getEmpresas().add(empresaMatriz);
//        usuario1.getEmpresas().add(empresa2);
//
//        dadosUsuarioLogadoBean.setLogin(loginSalvo);
//
//        Usuario usuario1Salvo = usuarioRepository.save(usuario1);
//
//        dadosUsuarioLogadoBean.setLogin(null);
//        dadosUsuarioLogadoBean.setLogado(false);
//        dadosUsuarioLogadoBean.setUsuario(null);
//
//    }

//    Login login;
//
//    public void buscaLogin() {
//        System.out.println("Email : " + email);
//        System.out.println("Senha : " + senha);
//        login = loginRepository.findBy(1L);
//    }

    public void login() throws IOException {

        System.out.println("Email : " + email);
        System.out.println("Senha : " + senha);
        Login login = loginRepository.findBy(1L);

        if (login != null) {

            dadosUsuarioLogadoBean.setLogin(login);
            Usuario usuario = usuarioRepository.findBy(1L);

            dadosUsuarioLogadoBean.setUsuario(usuario);
            dadosUsuarioLogadoBean.setLogado(true);
            FacesUtil.redirect("/index");
        } else {
            FacesUtil.redirect("/negado");
        }

    }

    public void logout() throws IOException {
        SessionUtil.invalidate();
        FacesUtil.redirect("/login");
    }

    public void dadosUsuario() throws IOException {
        FacesUtil.redirect("/dadosUsuario");
    }

    public void voltar() throws IOException {
        FacesUtil.redirect("/index");
    }

    public void erro() {
        try {
            Integer integer = Integer.valueOf("fgutrutu");
            System.out.println(integer);
        } catch (NumberFormatException e) {
            catchEvent.fire(new ExceptionToCatchEvent(e));
        }
    }

    public void DoubleSubmit() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("DoubleSubmit");
    }

    @QualificadorMetodoProtegido
    public void ApenasAdmin() {
        FacesUtil.addInfoMessage("Metodo Apenas Admin");
    }


}
