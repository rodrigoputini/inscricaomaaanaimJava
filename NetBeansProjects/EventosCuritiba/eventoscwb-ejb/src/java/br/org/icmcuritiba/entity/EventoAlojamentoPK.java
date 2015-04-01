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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
@Embeddable
public class EventoAlojamentoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codevento")
    private BigInteger codevento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codalojamento")
    private BigInteger codalojamento;

    public EventoAlojamentoPK() {
    }

    public EventoAlojamentoPK(BigInteger codevento, BigInteger codalojamento) {
        this.codevento = codevento;
        this.codalojamento = codalojamento;
    }

    public BigInteger getCodevento() {
        return codevento;
    }

    public void setCodevento(BigInteger codevento) {
        this.codevento = codevento;
    }

    public BigInteger getCodalojamento() {
        return codalojamento;
    }

    public void setCodalojamento(BigInteger codalojamento) {
        this.codalojamento = codalojamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codevento != null ? codevento.hashCode() : 0);
        hash += (codalojamento != null ? codalojamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoAlojamentoPK)) {
            return false;
        }
        EventoAlojamentoPK other = (EventoAlojamentoPK) object;
        if ((this.codevento == null && other.codevento != null) || (this.codevento != null && !this.codevento.equals(other.codevento))) {
            return false;
        }
        if ((this.codalojamento == null && other.codalojamento != null) || (this.codalojamento != null && !this.codalojamento.equals(other.codalojamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.EventoAlojamentoPK[ codevento=" + codevento + ", codalojamento=" + codalojamento + " ]";
    }
    
}
