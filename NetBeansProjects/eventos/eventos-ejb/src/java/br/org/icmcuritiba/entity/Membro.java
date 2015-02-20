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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author s016361
 */
@Entity
@Table(name = "tb_membro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membro.findAll", query = "SELECT m FROM Membro m"),
    @NamedQuery(name = "Membro.findByCodmembro", query = "SELECT m FROM Membro m WHERE m.codmembro = :codmembro")})
public class Membro implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codmembro")
    private BigDecimal codmembro;
    @ManyToMany(mappedBy = "membroList")
    private List<Funcao> funcaoList;
    @JoinColumn(name = "codprofissao", referencedColumnName = "codprofissao")
    @ManyToOne
    private Profissao codprofissao;
    @JoinColumn(name = "codpessoa", referencedColumnName = "codpessoa")
    @OneToOne(optional = false)
    private Pessoa codpessoa;
    @JoinColumn(name = "codigreja", referencedColumnName = "codigreja")
    @ManyToOne
    private Igreja codigreja;
    @JoinColumn(name = "codendereco", referencedColumnName = "codendereco")
    @ManyToOne
    private Endereco codendereco;
    @JoinColumn(name = "codcategoriamembro", referencedColumnName = "codcategoriamembro")
    @ManyToOne(optional = false)
    private Categoriamembro codcategoriamembro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membro")
    private List<Inscricao> inscricaoList;

    public Membro() {
    }

    public Membro(BigDecimal codmembro) {
        this.codmembro = codmembro;
    }

    public BigDecimal getCodmembro() {
        return codmembro;
    }

    public void setCodmembro(BigDecimal codmembro) {
        this.codmembro = codmembro;
    }

    @XmlTransient
    public List<Funcao> getFuncaoList() {
        return funcaoList;
    }

    public void setFuncaoList(List<Funcao> funcaoList) {
        this.funcaoList = funcaoList;
    }

    public Profissao getCodprofissao() {
        return codprofissao;
    }

    public void setCodprofissao(Profissao codprofissao) {
        this.codprofissao = codprofissao;
    }

    public Pessoa getCodpessoa() {
        return codpessoa;
    }

    public void setCodpessoa(Pessoa codpessoa) {
        this.codpessoa = codpessoa;
    }

    public Igreja getCodigreja() {
        return codigreja;
    }

    public void setCodigreja(Igreja codigreja) {
        this.codigreja = codigreja;
    }

    public Endereco getCodendereco() {
        return codendereco;
    }

    public void setCodendereco(Endereco codendereco) {
        this.codendereco = codendereco;
    }

    public Categoriamembro getCodcategoriamembro() {
        return codcategoriamembro;
    }

    public void setCodcategoriamembro(Categoriamembro codcategoriamembro) {
        this.codcategoriamembro = codcategoriamembro;
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
        hash += (codmembro != null ? codmembro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membro)) {
            return false;
        }
        Membro other = (Membro) object;
        if ((this.codmembro == null && other.codmembro != null) || (this.codmembro != null && !this.codmembro.equals(other.codmembro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.Membro[ codmembro=" + codmembro + " ]";
    }
    
}
