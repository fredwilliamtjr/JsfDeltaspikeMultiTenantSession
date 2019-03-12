package br.com.fwtj.MavenJSfPrimefaces.modelo;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    public Usuario() {
    }

    public Usuario(String email, boolean admin, Empresa empresaMatriz) {
        this.email = email;
        this.admin = admin;
        this.empresaMatriz = empresaMatriz;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private boolean admin = false;
    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Empresa empresaMatriz;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Empresa> empresas = new ArrayList<>();

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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Empresa getEmpresaMatriz() {
        return empresaMatriz;
    }

    public void setEmpresaMatriz(Empresa empresaMatriz) {
        this.empresaMatriz = empresaMatriz;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
}
