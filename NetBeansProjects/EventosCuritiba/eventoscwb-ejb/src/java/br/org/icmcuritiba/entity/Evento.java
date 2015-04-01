/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
@Entity
@Table(name = "tb_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByCodevento", query = "SELECT e FROM Evento e WHERE e.codevento = :codevento"),
    @NamedQuery(name = "Evento.findByDescevento", query = "SELECT e FROM Evento e WHERE e.descevento = :descevento"),
    @NamedQuery(name = "Evento.findByVideoconferencia", query = "SELECT e FROM Evento e WHERE e.videoconferencia = :videoconferencia"),
    @NamedQuery(name = "Evento.findByLocalevento", query = "SELECT e FROM Evento e WHERE e.localevento = :localevento"),
    @NamedQuery(name = "Evento.findByDtinicial", query = "SELECT e FROM Evento e WHERE e.dtinicial = :dtinicial"),
    @NamedQuery(name = "Evento.findByDtfinal", query = "SELECT e FROM Evento e WHERE e.dtfinal = :dtfinal"),
    @NamedQuery(name = "Evento.findByDtinicialinsc", query = "SELECT e FROM Evento e WHERE e.dtinicialinsc = :dtinicialinsc"),
    @NamedQuery(name = "Evento.findByDtfinalinsc", query = "SELECT e FROM Evento e WHERE e.dtfinalinsc = :dtfinalinsc"),
    @NamedQuery(name = "Evento.findByDtinicialinscvolunt", query = "SELECT e FROM Evento e WHERE e.dtinicialinscvolunt = :dtinicialinscvolunt"),
    @NamedQuery(name = "Evento.findByDtfinalinscvolunt", query = "SELECT e FROM Evento e WHERE e.dtfinalinscvolunt = :dtfinalinscvolunt"),
    @NamedQuery(name = "Evento.findByVagasmasculino", query = "SELECT e FROM Evento e WHERE e.vagasmasculino = :vagasmasculino"),
    @NamedQuery(name = "Evento.findByNumvagasfeminino", query = "SELECT e FROM Evento e WHERE e.numvagasfeminino = :numvagasfeminino"),
    @NamedQuery(name = "Evento.findByValorinscricao", query = "SELECT e FROM Evento e WHERE e.valorinscricao = :valorinscricao"),
    @NamedQuery(name = "Evento.findByStatus", query = "SELECT e FROM Evento e WHERE e.status = :status"),
    @NamedQuery(name = "Evento.findByDtfinalsubs", query = "SELECT e FROM Evento e WHERE e.dtfinalsubs = :dtfinalsubs"),
    @NamedQuery(name = "Evento.findByCodusuario", query = "SELECT e FROM Evento e WHERE e.codusuario = :codusuario"),
    @NamedQuery(name = "Evento.findByCoordenadaslocal", query = "SELECT e FROM Evento e WHERE e.coordenadaslocal = :coordenadaslocal")})
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codevento")
    private BigDecimal codevento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "descevento")
    private String descevento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "videoconferencia")
    private boolean videoconferencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "localevento")
    private String localevento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtinicial")
    @Temporal(TemporalType.DATE)
    private Date dtinicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtfinal")
    @Temporal(TemporalType.DATE)
    private Date dtfinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtinicialinsc")
    @Temporal(TemporalType.DATE)
    private Date dtinicialinsc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtfinalinsc")
    @Temporal(TemporalType.DATE)
    private Date dtfinalinsc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtinicialinscvolunt")
    @Temporal(TemporalType.DATE)
    private Date dtinicialinscvolunt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtfinalinscvolunt")
    @Temporal(TemporalType.DATE)
    private Date dtfinalinscvolunt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vagasmasculino")
    private BigInteger vagasmasculino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numvagasfeminino")
    private BigInteger numvagasfeminino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorinscricao")
    private BigDecimal valorinscricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtfinalsubs")
    @Temporal(TemporalType.DATE)
    private Date dtfinalsubs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codusuario")
    private BigInteger codusuario;
    @Size(max = 2147483647)
    @Column(name = "coordenadaslocal")
    private String coordenadaslocal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento", fetch = FetchType.LAZY)
    private List<EventoAlojamento> eventoAlojamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento", fetch = FetchType.LAZY)
    private List<Inscricao> inscricaoList;

    public Evento() {
    }

    public Evento(BigDecimal codevento) {
        this.codevento = codevento;
    }

    public Evento(BigDecimal codevento, String descevento, boolean videoconferencia, String localevento, Date dtinicial, Date dtfinal, Date dtinicialinsc, Date dtfinalinsc, Date dtinicialinscvolunt, Date dtfinalinscvolunt, BigInteger vagasmasculino, BigInteger numvagasfeminino, BigDecimal valorinscricao, boolean status, Date dtfinalsubs, BigInteger codusuario) {
        this.codevento = codevento;
        this.descevento = descevento;
        this.videoconferencia = videoconferencia;
        this.localevento = localevento;
        this.dtinicial = dtinicial;
        this.dtfinal = dtfinal;
        this.dtinicialinsc = dtinicialinsc;
        this.dtfinalinsc = dtfinalinsc;
        this.dtinicialinscvolunt = dtinicialinscvolunt;
        this.dtfinalinscvolunt = dtfinalinscvolunt;
        this.vagasmasculino = vagasmasculino;
        this.numvagasfeminino = numvagasfeminino;
        this.valorinscricao = valorinscricao;
        this.status = status;
        this.dtfinalsubs = dtfinalsubs;
        this.codusuario = codusuario;
    }

    public BigDecimal getCodevento() {
        return codevento;
    }

    public void setCodevento(BigDecimal codevento) {
        this.codevento = codevento;
    }

    public String getDescevento() {
        return descevento;
    }

    public void setDescevento(String descevento) {
        this.descevento = descevento;
    }

    public boolean getVideoconferencia() {
        return videoconferencia;
    }

    public void setVideoconferencia(boolean videoconferencia) {
        this.videoconferencia = videoconferencia;
    }

    public String getLocalevento() {
        return localevento;
    }

    public void setLocalevento(String localevento) {
        this.localevento = localevento;
    }

    public Date getDtinicial() {
        return dtinicial;
    }

    public void setDtinicial(Date dtinicial) {
        this.dtinicial = dtinicial;
    }

    public Date getDtfinal() {
        return dtfinal;
    }

    public void setDtfinal(Date dtfinal) {
        this.dtfinal = dtfinal;
    }

    public Date getDtinicialinsc() {
        return dtinicialinsc;
    }

    public void setDtinicialinsc(Date dtinicialinsc) {
        this.dtinicialinsc = dtinicialinsc;
    }

    public Date getDtfinalinsc() {
        return dtfinalinsc;
    }

    public void setDtfinalinsc(Date dtfinalinsc) {
        this.dtfinalinsc = dtfinalinsc;
    }

    public Date getDtinicialinscvolunt() {
        return dtinicialinscvolunt;
    }

    public void setDtinicialinscvolunt(Date dtinicialinscvolunt) {
        this.dtinicialinscvolunt = dtinicialinscvolunt;
    }

    public Date getDtfinalinscvolunt() {
        return dtfinalinscvolunt;
    }

    public void setDtfinalinscvolunt(Date dtfinalinscvolunt) {
        this.dtfinalinscvolunt = dtfinalinscvolunt;
    }

    public BigInteger getVagasmasculino() {
        return vagasmasculino;
    }

    public void setVagasmasculino(BigInteger vagasmasculino) {
        this.vagasmasculino = vagasmasculino;
    }

    public BigInteger getNumvagasfeminino() {
        return numvagasfeminino;
    }

    public void setNumvagasfeminino(BigInteger numvagasfeminino) {
        this.numvagasfeminino = numvagasfeminino;
    }

    public BigDecimal getValorinscricao() {
        return valorinscricao;
    }

    public void setValorinscricao(BigDecimal valorinscricao) {
        this.valorinscricao = valorinscricao;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDtfinalsubs() {
        return dtfinalsubs;
    }

    public void setDtfinalsubs(Date dtfinalsubs) {
        this.dtfinalsubs = dtfinalsubs;
    }

    public BigInteger getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(BigInteger codusuario) {
        this.codusuario = codusuario;
    }

    public String getCoordenadaslocal() {
        return coordenadaslocal;
    }

    public void setCoordenadaslocal(String coordenadaslocal) {
        this.coordenadaslocal = coordenadaslocal;
    }

    @XmlTransient
    public List<EventoAlojamento> getEventoAlojamentoList() {
        return eventoAlojamentoList;
    }

    public void setEventoAlojamentoList(List<EventoAlojamento> eventoAlojamentoList) {
        this.eventoAlojamentoList = eventoAlojamentoList;
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
        hash += (codevento != null ? codevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.codevento == null && other.codevento != null) || (this.codevento != null && !this.codevento.equals(other.codevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.Evento[ codevento=" + codevento + " ]";
    }
    
}
