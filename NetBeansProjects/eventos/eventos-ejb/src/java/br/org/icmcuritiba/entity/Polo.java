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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_polo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Polo.findAll", query = "SELECT p FROM Polo p"),
    @NamedQuery(name = "Polo.findByCodpolo", query = "SELECT p FROM Polo p WHERE p.codpolo = :codpolo"),
    @NamedQuery(name = "Polo.findByDescpolo", query = "SELECT p FROM Polo p WHERE p.descpolo = :descpolo")})
public class Polo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codpolo")
    private BigDecimal codpolo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "descpolo")
    private String descpolo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codpolo")
    private List<Igreja> igrejaList;
    @JoinColumn(name = "codarea", referencedColumnName = "codarea")
    @ManyToOne(optional = false)
    private Area codarea;

    public Polo() {
    }

    public Polo(BigDecimal codpolo) {
        this.codpolo = codpolo;
    }

    public Polo(BigDecimal codpolo, String descpolo) {
        this.codpolo = codpolo;
        this.descpolo = descpolo;
    }

    public BigDecimal getCodpolo() {
        return codpolo;
    }

    public void setCodpolo(BigDecimal codpolo) {
        this.codpolo = codpolo;
    }

    public String getDescpolo() {
        return descpolo;
    }

    public void setDescpolo(String descpolo) {
        this.descpolo = descpolo;
    }

    @XmlTransient
    public List<Igreja> getIgrejaList() {
        return igrejaList;
    }

    public void setIgrejaList(List<Igreja> igrejaList) {
        this.igrejaList = igrejaList;
    }

    public Area getCodarea() {
        return codarea;
    }

    public void setCodarea(Area codarea) {
        this.codarea = codarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpolo != null ? codpolo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polo)) {
            return false;
        }
        Polo other = (Polo) object;
        if ((this.codpolo == null && other.codpolo != null) || (this.codpolo != null && !this.codpolo.equals(other.codpolo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.Polo[ codpolo=" + codpolo + " ]";
    }
    
}
