/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
@Entity
@Table(name = "tb_funcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcao.findAll", query = "SELECT f FROM Funcao f"),
    @NamedQuery(name = "Funcao.findByCodfuncao", query = "SELECT f FROM Funcao f WHERE f.codfuncao = :codfuncao"),
    @NamedQuery(name = "Funcao.findByDescfuncao", query = "SELECT f FROM Funcao f WHERE f.descfuncao = :descfuncao")})
public class Funcao implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codfuncao")
    private BigDecimal codfuncao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descfuncao")
    private String descfuncao;
    @JoinTable(name = "tb_membrofuncao", joinColumns = {
        @JoinColumn(name = "codfuncao", referencedColumnName = "codfuncao")}, inverseJoinColumns = {
        @JoinColumn(name = "codmembro", referencedColumnName = "codmembro")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Membro> membroList;

    public Funcao() {
    }

    public Funcao(BigDecimal codfuncao) {
        this.codfuncao = codfuncao;
    }

    public Funcao(BigDecimal codfuncao, String descfuncao) {
        this.codfuncao = codfuncao;
        this.descfuncao = descfuncao;
    }

    public BigDecimal getCodfuncao() {
        return codfuncao;
    }

    public void setCodfuncao(BigDecimal codfuncao) {
        this.codfuncao = codfuncao;
    }

    public String getDescfuncao() {
        return descfuncao;
    }

    public void setDescfuncao(String descfuncao) {
        this.descfuncao = descfuncao;
    }

    @XmlTransient
    public List<Membro> getMembroList() {
        return membroList;
    }

    public void setMembroList(List<Membro> membroList) {
        this.membroList = membroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codfuncao != null ? codfuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcao)) {
            return false;
        }
        Funcao other = (Funcao) object;
        if ((this.codfuncao == null && other.codfuncao != null) || (this.codfuncao != null && !this.codfuncao.equals(other.codfuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.Funcao[ codfuncao=" + codfuncao + " ]";
    }
    
}
