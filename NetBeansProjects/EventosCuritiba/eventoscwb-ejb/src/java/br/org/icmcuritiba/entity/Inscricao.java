/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author s016361
 */
@Entity
@Table(name = "tb_inscricao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscricao.findAll", query = "SELECT i FROM Inscricao i"),
    @NamedQuery(name = "Inscricao.findByCodmembro", query = "SELECT i FROM Inscricao i WHERE i.inscricaoPK.codmembro = :codmembro"),
    @NamedQuery(name = "Inscricao.findByCodevento", query = "SELECT i FROM Inscricao i WHERE i.inscricaoPK.codevento = :codevento"),
    @NamedQuery(name = "Inscricao.findByPagamento", query = "SELECT i FROM Inscricao i WHERE i.pagamento = :pagamento"),
    @NamedQuery(name = "Inscricao.findByStatus", query = "SELECT i FROM Inscricao i WHERE i.status = :status"),
    @NamedQuery(name = "Inscricao.findByInscritor", query = "SELECT i FROM Inscricao i WHERE i.inscritor = :inscritor"),
    @NamedQuery(name = "Inscricao.findByDatainscricao", query = "SELECT i FROM Inscricao i WHERE i.datainscricao = :datainscricao")})
public class Inscricao implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InscricaoPK inscricaoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pagamento")
    private boolean pagamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 31)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inscritor")
    private BigInteger inscritor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datainscricao")
    @Temporal(TemporalType.DATE)
    private Date datainscricao;
    @JoinColumn(name = "codmembro", referencedColumnName = "codmembro", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Membro membro;
    @JoinColumn(name = "codevento", referencedColumnName = "codevento", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Evento evento;
    @JoinColumn(name = "codequipe", referencedColumnName = "codequipe")
    @ManyToOne(fetch = FetchType.LAZY)
    private Equipe codequipe;
    @JoinColumn(name = "codcatinscricao", referencedColumnName = "codcatinscricao")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoriainscricao codcatinscricao;

    public Inscricao() {
    }

    public Inscricao(InscricaoPK inscricaoPK) {
        this.inscricaoPK = inscricaoPK;
    }

    public Inscricao(InscricaoPK inscricaoPK, boolean pagamento, String status, BigInteger inscritor, Date datainscricao) {
        this.inscricaoPK = inscricaoPK;
        this.pagamento = pagamento;
        this.status = status;
        this.inscritor = inscritor;
        this.datainscricao = datainscricao;
    }

    public Inscricao(BigInteger codmembro, BigInteger codevento) {
        this.inscricaoPK = new InscricaoPK(codmembro, codevento);
    }

    public InscricaoPK getInscricaoPK() {
        return inscricaoPK;
    }

    public void setInscricaoPK(InscricaoPK inscricaoPK) {
        this.inscricaoPK = inscricaoPK;
    }

    public boolean getPagamento() {
        return pagamento;
    }

    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getInscritor() {
        return inscritor;
    }

    public void setInscritor(BigInteger inscritor) {
        this.inscritor = inscritor;
    }

    public Date getDatainscricao() {
        return datainscricao;
    }

    public void setDatainscricao(Date datainscricao) {
        this.datainscricao = datainscricao;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Equipe getCodequipe() {
        return codequipe;
    }

    public void setCodequipe(Equipe codequipe) {
        this.codequipe = codequipe;
    }

    public Categoriainscricao getCodcatinscricao() {
        return codcatinscricao;
    }

    public void setCodcatinscricao(Categoriainscricao codcatinscricao) {
        this.codcatinscricao = codcatinscricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inscricaoPK != null ? inscricaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscricao)) {
            return false;
        }
        Inscricao other = (Inscricao) object;
        if ((this.inscricaoPK == null && other.inscricaoPK != null) || (this.inscricaoPK != null && !this.inscricaoPK.equals(other.inscricaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.Inscricao[ inscricaoPK=" + inscricaoPK + " ]";
    }
    
}
