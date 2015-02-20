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
@Table(name = "tb_categoriainscricao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoriainscricao.findAll", query = "SELECT c FROM Categoriainscricao c"),
    @NamedQuery(name = "Categoriainscricao.findByCodcatinscricao", query = "SELECT c FROM Categoriainscricao c WHERE c.codcatinscricao = :codcatinscricao"),
    @NamedQuery(name = "Categoriainscricao.findByDesccatinscricao", query = "SELECT c FROM Categoriainscricao c WHERE c.desccatinscricao = :desccatinscricao")})
public class Categoriainscricao implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codcatinscricao")
    private BigDecimal codcatinscricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "desccatinscricao")
    private String desccatinscricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcatinscricao")
    private List<Inscricao> inscricaoList;

    public Categoriainscricao() {
    }

    public Categoriainscricao(BigDecimal codcatinscricao) {
        this.codcatinscricao = codcatinscricao;
    }

    public Categoriainscricao(BigDecimal codcatinscricao, String desccatinscricao) {
        this.codcatinscricao = codcatinscricao;
        this.desccatinscricao = desccatinscricao;
    }

    public BigDecimal getCodcatinscricao() {
        return codcatinscricao;
    }

    public void setCodcatinscricao(BigDecimal codcatinscricao) {
        this.codcatinscricao = codcatinscricao;
    }

    public String getDesccatinscricao() {
        return desccatinscricao;
    }

    public void setDesccatinscricao(String desccatinscricao) {
        this.desccatinscricao = desccatinscricao;
    }

    @XmlTransient
    public List<Inscricao> getInscricaoList() {
        return inscricaoList;
    }

    public void setInscricaoList(List<Inscricao> inscricaoList) {
        this.inscricaoList = inscricaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcatinscricao != null ? codcatinscricao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoriainscricao)) {
            return false;
        }
        Categoriainscricao other = (Categoriainscricao) object;
        if ((this.codcatinscricao == null && other.codcatinscricao != null) || (this.codcatinscricao != null && !this.codcatinscricao.equals(other.codcatinscricao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.Categoriainscricao[ codcatinscricao=" + codcatinscricao + " ]";
    }
    
}
