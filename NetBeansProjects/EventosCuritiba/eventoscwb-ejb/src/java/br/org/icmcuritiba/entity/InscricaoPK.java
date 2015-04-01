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
public class InscricaoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codmembro")
    private BigInteger codmembro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codevento")
    private BigInteger codevento;

    public InscricaoPK() {
    }

    public InscricaoPK(BigInteger codmembro, BigInteger codevento) {
        this.codmembro = codmembro;
        this.codevento = codevento;
    }

    public BigInteger getCodmembro() {
        return codmembro;
    }

    public void setCodmembro(BigInteger codmembro) {
        this.codmembro = codmembro;
    }

    public BigInteger getCodevento() {
        return codevento;
    }

    public void setCodevento(BigInteger codevento) {
        this.codevento = codevento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmembro != null ? codmembro.hashCode() : 0);
        hash += (codevento != null ? codevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscricaoPK)) {
            return false;
        }
        InscricaoPK other = (InscricaoPK) object;
        if ((this.codmembro == null && other.codmembro != null) || (this.codmembro != null && !this.codmembro.equals(other.codmembro))) {
            return false;
        }
        if ((this.codevento == null && other.codevento != null) || (this.codevento != null && !this.codevento.equals(other.codevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.InscricaoPK[ codmembro=" + codmembro + ", codevento=" + codevento + " ]";
    }
    
}
