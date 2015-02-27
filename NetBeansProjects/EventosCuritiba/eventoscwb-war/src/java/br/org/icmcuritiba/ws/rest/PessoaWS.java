/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.ws.rest;

import br.org.icmcuritiba.entity.Pessoa;
import br.org.icmcuritiba.interfaces.PessoaRemote;
import java.util.List;
import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author s016361
 */
@Path("/pessoa")
public class PessoaWS {
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> getAll(){
        try {
        PessoaRemote pessoaEjb =  (PessoaRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/PessoaFacade!br.org.icmcuritiba.interfaces.PessoaRemote");       
        return pessoaEjb.getAllPessoas();
        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

 
    } 
    
}
