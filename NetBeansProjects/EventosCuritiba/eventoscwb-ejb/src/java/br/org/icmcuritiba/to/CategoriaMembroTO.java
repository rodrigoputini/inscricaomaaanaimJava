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
 * @since 25 mar 2015
 */
public class CategoriaMembroTO {
    
    private BigDecimal codcategoriamembro;
    private String desccategoriamembro;

    public BigDecimal getCodcategoriamembro() {
        return codcategoriamembro;
    }

    public void setCodcategoriamembro(BigDecimal codcategoriamembro) {
        this.codcategoriamembro = codcategoriamembro;
    }

    public String getDesccategoriamembro() {
        return desccategoriamembro;
    }

    public void setDesccategoriamembro(String desccategoriamembro) {
        this.desccategoriamembro = desccategoriamembro;
    }

}
