/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.ws.rest;

import br.org.icmcuritiba.entity.Cep;
import br.org.icmcuritiba.entity.Endereco;
import br.org.icmcuritiba.exception.EventosException;
import br.org.icmcuritiba.interfaces.CepRemote;
import br.org.icmcuritiba.interfaces.EnderecoRemote;
import br.org.icmcuritiba.to.EnderecoTO;
import br.org.icmcuritiba.to.PessoaTO;
import javax.naming.InitialContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Rodrigo Camargo Putini - rodrigo.putini@gmail.com
 * @since 09 Apr 2015
 */
@Path("/endereco")
public class EnderecoWS {

    @POST
    @Path("/findbycep")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public EnderecoTO getAll(PessoaTO pto) throws EventosException {
        EnderecoTO eto = new EnderecoTO();
        Endereco e = null;
        try {
            EnderecoRemote enderecoEjb = (EnderecoRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/EnderecoFacade!br.org.icmcuritiba.interfaces.EnderecoRemote");
            CepRemote cepEjb = (CepRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/CepFacade!br.org.icmcuritiba.interfaces.CepRemote");
            e = enderecoEjb.getEnderecoByCep(pto.getCep());
            Cep cep = null;
            if (null != e) {
                eto.setCodendereco(e.getCodendereco());
                eto.setCep(e.getCep());
                eto.setBairro(e.getBairro());
                eto.setCidade(e.getCidade());
                eto.setEstado(e.getEstado());
                eto.setLogradouro(e.getLogradouro());
                eto.setPais(e.getPais());
            } else {
                cep = cepEjb.loadUnknowAddress(pto.getCep());
            }
            if (null != cep) {
                eto.setCep(cep.getCep());
                eto.setBairro(cep.getBairro());
                eto.setCidade(cep.getCidade());

                eto.setEstado(cep.getEstado());
                eto.setLogradouro(cep.getLogradouro());
                eto.setPais(cep.getPais());
            }
        } catch (Exception ex) {
            throw new EventosException(ex, EnderecoWS.class.getName());
        }
        return eto;
    }
}
