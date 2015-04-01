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
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
@Entity
@Table(name = "tb_igreja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Igreja.findAll", query = "SELECT i FROM Igreja i"),
    @NamedQuery(name = "Igreja.findByCodigreja", query = "SELECT i FROM Igreja i WHERE i.codigreja = :codigreja"),
    @NamedQuery(name = "Igreja.findByCodpresbiterio", query = "SELECT i FROM Igreja i WHERE i.codpresbiterio = :codpresbiterio"),
    @NamedQuery(name = "Igreja.findByNomeigreja", query = "SELECT i FROM Igreja i WHERE i.nomeigreja = :nomeigreja"),
    @NamedQuery(name = "Igreja.findByComplemento", query = "SELECT i FROM Igreja i WHERE i.complemento = :complemento"),
    @NamedQuery(name = "Igreja.findByNumerorua", query = "SELECT i FROM Igreja i WHERE i.numerorua = :numerorua")})
public class Igreja implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigreja")
    private BigDecimal codigreja;
    @Size(max = 10)
    @Column(name = "codpresbiterio")
    private String codpresbiterio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomeigreja")
    private String nomeigreja;
    @Size(max = 50)
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "numerorua")
    private Integer numerorua;
    @OneToMany(mappedBy = "codigreja", fetch = FetchType.LAZY)
    private List<Membro> membroList;
    @JoinColumn(name = "codpolo", referencedColumnName = "codpolo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Polo codpolo;
    @JoinColumn(name = "codendereco", referencedColumnName = "codendereco")
    @ManyToOne(fetch = FetchType.LAZY)
    private Endereco codendereco;

    public Igreja() {
    }

    public Igreja(BigDecimal codigreja) {
        this.codigreja = codigreja;
    }

    public Igreja(BigDecimal codigreja, String nomeigreja) {
        this.codigreja = codigreja;
        this.nomeigreja = nomeigreja;
    }

    public BigDecimal getCodigreja() {
        return codigreja;
    }

    public void setCodigreja(BigDecimal codigreja) {
        this.codigreja = codigreja;
    }

    public String getCodpresbiterio() {
        return codpresbiterio;
    }

    public void setCodpresbiterio(String codpresbiterio) {
        this.codpresbiterio = codpresbiterio;
    }

    public String getNomeigreja() {
        return nomeigreja;
    }

    public void setNomeigreja(String nomeigreja) {
        this.nomeigreja = nomeigreja;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumerorua() {
        return numerorua;
    }

    public void setNumerorua(Integer numerorua) {
        this.numerorua = numerorua;
    }

    @XmlTransient
    public List<Membro> getMembroList() {
        return membroList;
    }

    public void setMembroList(List<Membro> membroList) {
        this.membroList = membroList;
    }

    public Polo getCodpolo() {
        return codpolo;
    }

    public void setCodpolo(Polo codpolo) {
        this.codpolo = codpolo;
    }

    public Endereco getCodendereco() {
        return codendereco;
    }

    public void setCodendereco(Endereco codendereco) {
        this.codendereco = codendereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigreja != null ? codigreja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Igreja)) {
            return false;
        }
        Igreja other = (Igreja) object;
        if ((this.codigreja == null && other.codigreja != null) || (this.codigreja != null && !this.codigreja.equals(other.codigreja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.Igreja[ codigreja=" + codigreja + " ]";
    }
    
}
