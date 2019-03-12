package br.com.fwtj.MavenJSfPrimefaces.modelo;

import org.apache.deltaspike.data.api.audit.CreatedOn;
import org.apache.deltaspike.data.api.audit.ModifiedBy;
import org.apache.deltaspike.data.api.audit.ModifiedOn;
import org.apache.deltaspike.data.impl.audit.AuditEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditEntityListener.class)
public class Produto {

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
    @OneToOne
    private Empresa empresa;

    private String nome;
    private Double valor;

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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", criadoEm=" + criadoEm +
                ", modificadoEm=" + modificadoEm +
                ", modificadoPor='" + modificadoPor + '\'' +
                ", empresa=" + empresa +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}
