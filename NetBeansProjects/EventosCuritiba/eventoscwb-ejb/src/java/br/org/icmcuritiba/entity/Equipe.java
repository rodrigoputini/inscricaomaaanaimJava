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
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
@Entity
@Table(name = "tb_equipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipe.findAll", query = "SELECT e FROM Equipe e"),
    @NamedQuery(name = "Equipe.findByCodequipe", query = "SELECT e FROM Equipe e WHERE e.codequipe = :codequipe"),
    @NamedQuery(name = "Equipe.findByDescequipe", query = "SELECT e FROM Equipe e WHERE e.descequipe = :descequipe")})
public class Equipe implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codequipe")
    private BigDecimal codequipe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descequipe")
    private String descequipe;
    @OneToMany(mappedBy = "codequipe", fetch = FetchType.LAZY)
    private List<Inscricao> inscricaoList;

    public Equipe() {
    }

    public Equipe(BigDecimal codequipe) {
        this.codequipe = codequipe;
    }

    public Equipe(BigDecimal codequipe, String descequipe) {
        this.codequipe = codequipe;
        this.descequipe = descequipe;
    }

    public BigDecimal getCodequipe() {
        return codequipe;
    }

    public void setCodequipe(BigDecimal codequipe) {
        this.codequipe = codequipe;
    }

    public String getDescequipe() {
        return descequipe;
    }

    public void setDescequipe(String descequipe) {
        this.descequipe = descequipe;
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
        hash += (codequipe != null ? codequipe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.codequipe == null && other.codequipe != null) || (this.codequipe != null && !this.codequipe.equals(other.codequipe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.Equipe[ codequipe=" + codequipe + " ]";
    }
    
}
