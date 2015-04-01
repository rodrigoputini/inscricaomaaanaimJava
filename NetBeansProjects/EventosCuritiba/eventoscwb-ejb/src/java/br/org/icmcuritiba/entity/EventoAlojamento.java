/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
@Entity
@Table(name = "tb_evento_alojamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventoAlojamento.findAll", query = "SELECT e FROM EventoAlojamento e"),
    @NamedQuery(name = "EventoAlojamento.findByCodevento", query = "SELECT e FROM EventoAlojamento e WHERE e.eventoAlojamentoPK.codevento = :codevento"),
    @NamedQuery(name = "EventoAlojamento.findByCodalojamento", query = "SELECT e FROM EventoAlojamento e WHERE e.eventoAlojamentoPK.codalojamento = :codalojamento"),
    @NamedQuery(name = "EventoAlojamento.findBySexo", query = "SELECT e FROM EventoAlojamento e WHERE e.sexo = :sexo")})
public class EventoAlojamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventoAlojamentoPK eventoAlojamentoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "sexo")
    private String sexo;
    @JoinColumn(name = "codevento", referencedColumnName = "codevento", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Evento evento;
    @JoinColumn(name = "codalojamento", referencedColumnName = "codalojamento", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Alojamento alojamento;

    public EventoAlojamento() {
    }

    public EventoAlojamento(EventoAlojamentoPK eventoAlojamentoPK) {
        this.eventoAlojamentoPK = eventoAlojamentoPK;
    }

    public EventoAlojamento(EventoAlojamentoPK eventoAlojamentoPK, String sexo) {
        this.eventoAlojamentoPK = eventoAlojamentoPK;
        this.sexo = sexo;
    }

    public EventoAlojamento(BigInteger codevento, BigInteger codalojamento) {
        this.eventoAlojamentoPK = new EventoAlojamentoPK(codevento, codalojamento);
    }

    public EventoAlojamentoPK getEventoAlojamentoPK() {
        return eventoAlojamentoPK;
    }

    public void setEventoAlojamentoPK(EventoAlojamentoPK eventoAlojamentoPK) {
        this.eventoAlojamentoPK = eventoAlojamentoPK;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Alojamento getAlojamento() {
        return alojamento;
    }

    public void setAlojamento(Alojamento alojamento) {
        this.alojamento = alojamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventoAlojamentoPK != null ? eventoAlojamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoAlojamento)) {
            return false;
        }
        EventoAlojamento other = (EventoAlojamento) object;
        if ((this.eventoAlojamentoPK == null && other.eventoAlojamentoPK != null) || (this.eventoAlojamentoPK != null && !this.eventoAlojamentoPK.equals(other.eventoAlojamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.EventoAlojamento[ eventoAlojamentoPK=" + eventoAlojamentoPK + " ]";
    }
    
}
