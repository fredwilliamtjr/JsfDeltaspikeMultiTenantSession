package br.com.fwtj.MavenJSfPrimefaces.modelo;

import org.apache.deltaspike.data.api.audit.CreatedOn;
import org.apache.deltaspike.data.api.audit.ModifiedBy;
import org.apache.deltaspike.data.api.audit.ModifiedOn;
import org.apache.deltaspike.data.impl.audit.AuditEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditEntityListener.class)
public class Empresa {

    public Empresa() {
    }

    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedOn
    private Date criadoEm;
    @Temporal(TemporalType.TIMESTAMP)
    @ModifiedOn(onCreate = true)
    private Date modificadoEm;
    @ModifiedBy
    private String modificadoPor;

    private String nome;
    private String cnpj;

    @ManyToMany(mappedBy = "empresas", cascade = CascadeType.PERSIST)
    private List<Usuario> usuarios = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Date getModificadoEm() {
        return modificadoEm;
    }

    public void setModificadoEm(Date modificadoEm) {
        this.modificadoEm = modificadoEm;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
