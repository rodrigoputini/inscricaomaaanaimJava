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
public class ProfissaoTO {
    
    private BigDecimal codprofissao;
    private String descprofissao;

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
}
