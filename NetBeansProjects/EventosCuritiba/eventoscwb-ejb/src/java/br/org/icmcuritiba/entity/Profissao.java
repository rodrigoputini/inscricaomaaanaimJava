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
 * @author s016361
 */
@Entity
@Table(name = "tb_profissao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profissao.findAll", query = "SELECT p FROM Profissao p"),
    @NamedQuery(name = "Profissao.findByCodprofissao", query = "SELECT p FROM Profissao p WHERE p.codprofissao = :codprofissao"),
    @NamedQuery(name = "Profissao.findByDescprofissao", query = "SELECT p FROM Profissao p WHERE p.descprofissao = :descprofissao")})
public class Profissao implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codprofissao")
    private BigDecimal codprofissao;
    @Size(max = 100)
    @Column(name = "descprofissao")
    private String descprofissao;
    @OneToMany(mappedBy = "codprofissao", fetch = FetchType.LAZY)
    private List<Membro> membroList;

    public Profissao() {
    }

    public Profissao(BigDecimal codprofissao) {
        this.codprofissao = codprofissao;
    }

    public BigDecimal getCodprofissao() {
        return codprofissao;
    }

    public void setCodprofissao(BigDecimal codprofissao) {
        this.codprofissao = codprofissao;
    }

    public String getDescprofissao() {
        return descprofissao;
    }

    public void setDescprofissao(String descprofissao) {
        this.descprofissao = descprofissao;
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
        hash += (codprofissao != null ? codprofissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profissao)) {
            return false;
        }
        Profissao other = (Profissao) object;
        if ((this.codprofissao == null && other.codprofissao != null) || (this.codprofissao != null && !this.codprofissao.equals(other.codprofissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.Profissao[ codprofissao=" + codprofissao + " ]";
    }
    
}
