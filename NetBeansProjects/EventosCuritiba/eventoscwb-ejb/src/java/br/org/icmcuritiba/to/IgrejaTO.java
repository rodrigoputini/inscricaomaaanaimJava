/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.to;

import java.math.BigDecimal;

/**
 *
 * @author Rodrigo Camargo Putini - rodrigo.putini@gmail.com
 * @since 26 mar 2015
 */
public class IgrejaTO {

    private BigDecimal codigreja;
    private String codpresbiterio;
    private String nomeigreja;
    private String complemento;
    private Integer numerorua;

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
    
    

    
}
