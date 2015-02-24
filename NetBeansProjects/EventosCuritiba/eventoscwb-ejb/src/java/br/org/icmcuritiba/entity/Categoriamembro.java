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
 * @author s016361
 */
@Entity
@Table(name = "tb_categoriamembro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoriamembro.findAll", query = "SELECT c FROM Categoriamembro c"),
    @NamedQuery(name = "Categoriamembro.findByCodcategoriamembro", query = "SELECT c FROM Categoriamembro c WHERE c.codcategoriamembro = :codcategoriamembro"),
    @NamedQuery(name = "Categoriamembro.findByDesccategoriamembro", query = "SELECT c FROM Categoriamembro c WHERE c.desccategoriamembro = :desccategoriamembro")})
public class Categoriamembro implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codcategoriamembro")
    private BigDecimal codcategoriamembro;
    @Size(max = 50)
    @Column(name = "desccategoriamembro")
    private String desccategoriamembro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcategoriamembro", fetch = FetchType.LAZY)
    private List<Membro> membroList;

    public Categoriamembro() {
    }

    public Categoriamembro(BigDecimal codcategoriamembro) {
        this.codcategoriamembro = codcategoriamembro;
    }

    public BigDecimal getCodcategoriamembro() {
        return codcategoriamembro;
    }

    public void setCodcategoriamembro(BigDecimal codcategoriamembro) {
        this.codcategoriamembro = codcategoriamembro;
    }

    public String getDesccategoriamembro() {
        return desccategoriamembro;
    }

    public void setDesccategoriamembro(String desccategoriamembro) {
        this.desccategoriamembro = desccategoriamembro;
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
        hash += (codcategoriamembro != null ? codcategoriamembro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoriamembro)) {
            return false;
        }
        Categoriamembro other = (Categoriamembro) object;
        if ((this.codcategoriamembro == null && other.codcategoriamembro != null) || (this.codcategoriamembro != null && !this.codcategoriamembro.equals(other.codcategoriamembro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.Categoriamembro[ codcategoriamembro=" + codcategoriamembro + " ]";
    }
    
}
