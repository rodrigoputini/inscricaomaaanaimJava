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
@Table(name = "tb_area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByCodarea", query = "SELECT a FROM Area a WHERE a.codarea = :codarea"),
    @NamedQuery(name = "Area.findByDescarea", query = "SELECT a FROM Area a WHERE a.descarea = :descarea"),
    @NamedQuery(name = "Area.findByRegiao", query = "SELECT a FROM Area a WHERE a.regiao = :regiao")})
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codarea")
    private BigDecimal codarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descarea")
    private String descarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "regiao")
    private String regiao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codarea")
    private List<Polo> poloList;

    public Area() {
    }

    public Area(BigDecimal codarea) {
        this.codarea = codarea;
    }

    public Area(BigDecimal codarea, String descarea, String regiao) {
        this.codarea = codarea;
        this.descarea = descarea;
        this.regiao = regiao;
    }

    public BigDecimal getCodarea() {
        return codarea;
    }

    public void setCodarea(BigDecimal codarea) {
        this.codarea = codarea;
    }

    public String getDescarea() {
        return descarea;
    }

    public void setDescarea(String descarea) {
        this.descarea = descarea;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    @XmlTransient
    public List<Polo> getPoloList() {
        return poloList;
    }

    public void setPoloList(List<Polo> poloList) {
        this.poloList = poloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codarea != null ? codarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.codarea == null && other.codarea != null) || (this.codarea != null && !this.codarea.equals(other.codarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.Area[ codarea=" + codarea + " ]";
    }
    
}
