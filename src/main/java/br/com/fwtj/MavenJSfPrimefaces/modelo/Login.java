package br.com.fwtj.MavenJSfPrimefaces.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Login {

    public Login() {
    }

    public Login(String email, String senha, String cnpjMatriz, boolean api) {
        this.email = email;
        this.senha = senha;
        this.cnpjMatriz = cnpjMatriz;
        this.api = api;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private String cnpjMatriz;
    private boolean api = false;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Pagina> paginas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCnpjMatriz() {
        return cnpjMatriz;
    }

    public void setCnpjMatriz(String cnpjMatriz) {
        this.cnpjMatriz = cnpjMatriz;
    }

    public boolean isApi() {
        return api;
    }

    public void setApi(boolean api) {
        this.api = api;
    }

    public List<Pagina> getPaginas() {
        return paginas;
    }

    public void setPaginas(List<Pagina> paginas) {
        this.paginas = paginas;
    }

    public String getSchemaName() {
        return "schema".concat(cnpjMatriz);
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", cnpjMatriz='" + cnpjMatriz + '\'' +
                ", api=" + api +
                ", paginas=" + paginas +
                '}';
    }
}
