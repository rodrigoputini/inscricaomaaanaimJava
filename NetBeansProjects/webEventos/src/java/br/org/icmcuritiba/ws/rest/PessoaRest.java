/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.ws.rest;

import javax.ejb.EJB;
import javax.ws.rs.*;

import br.org.icmcuritiba.facade.PessoaFacade;
import br.org.icmcuritiba.out.PessoaOut;

import javax.ws.rs.core.MediaType;


/**
 *
 * @author Rodrigo C Putini
 */


@Path("/pessoa")
public class PessoaRest {
    
    @EJB
    private PessoaFacade pessoaEjb;
    
    @GET
    @Path("/listAll")
    @Consumes(MediaType.APPLICATION_JSON)
    public PessoaOut listAll(){
        PessoaOut retorno = new PessoaOut();
        retorno.setPessoas(pessoaEjb.listAllPessoa());
        return retorno;
    }
    
    
}
