/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.to;

import java.util.List;
import br.org.icmcuritiba.entity.Pessoa;

/**
 *
 * @author Rodrigo Camargo Putini - rodrigo.putini@gmail.com
 */
public class PessoaTO {
    
    private String nomePessoa;
    private String cpf;
    private String codPresbiterio;
    private String cep;

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCodPresbiterio() {
        return codPresbiterio;
    }

    public void setCodPresbiterio(String codPresbiterio) {
        this.codPresbiterio = codPresbiterio;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
}
