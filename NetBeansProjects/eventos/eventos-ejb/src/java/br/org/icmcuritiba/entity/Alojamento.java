/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author s016361
 */
@Entity
@Table(name = "tb_alojamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alojamento.findAll", query = "SELECT a FROM Alojamento a"),
    @NamedQuery(name = "Alojamento.findByCodalojamento", query = "SELECT a FROM Alojamento a WHERE a.codalojamento = :codalojamento"),
    @NamedQuery(name = "Alojamento.findByDescalojamento", query = "SELECT a FROM Alojamento a WHERE a.descalojamento = :descalojamento"),
    @NamedQuery(name = "Alojamento.findByVagas", query = "SELECT a FROM Alojamento a WHERE a.vagas = :vagas")})
public class Alojamento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codalojamento")
    private BigDecimal codalojamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descalojamento")
    private String descalojamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vagas")
    private BigInteger vagas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alojamento")
    private List<EventoAlojamento> eventoAlojamentoList;

    public Alojamento() {
    }

    public Alojamento(BigDecimal codalojamento) {
        this.codalojamento = codalojamento;
    }

    public Alojamento(BigDecimal codalojamento, String descalojamento, BigInteger vagas) {
        this.codalojamento = codalojamento;
        this.descalojamento = descalojamento;
        this.vagas = vagas;
    }

    public BigDecimal getCodalojamento() {
        return codalojamento;
    }

    public void setCodalojamento(BigDecimal codalojamento) {
        this.codalojamento = codalojamento;
    }

    public String getDescalojamento() {
        return descalojamento;
    }

    public void setDescalojamento(String descalojamento) {
        this.descalojamento = descalojamento;
    }

    public BigInteger getVagas() {
        return vagas;
    }

    public void setVagas(BigInteger vagas) {
        this.vagas = vagas;
    }

    @XmlTransient
    public List<EventoAlojamento> getEventoAlojamentoList() {
        return eventoAlojamentoList;
    }

    public void setEventoAlojamentoList(List<EventoAlojamento> eventoAlojamentoList) {
        this.eventoAlojamentoList = eventoAlojamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codalojamento != null ? codalojamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alojamento)) {
            return false;
        }
        Alojamento other = (Alojamento) object;
        if ((this.codalojamento == null && other.codalojamento != null) || (this.codalojamento != null && !this.codalojamento.equals(other.codalojamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.Alojamento[ codalojamento=" + codalojamento + " ]";
    }
    
}
