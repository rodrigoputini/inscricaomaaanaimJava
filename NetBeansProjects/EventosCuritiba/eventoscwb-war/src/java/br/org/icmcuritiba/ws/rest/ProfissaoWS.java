/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.ws.rest;

import br.org.icmcuritiba.entity.Profissao;
import br.org.icmcuritiba.exception.EventosException;
import br.org.icmcuritiba.interfaces.ProfissaoRemote;
import br.org.icmcuritiba.to.ProfissaoTO;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 * @since 25 mar 2015
 */
@Path("/profissao")
public class ProfissaoWS {
    
    @POST
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProfissaoTO> getAll(){
        List<ProfissaoTO> lstProfissao = new ArrayList<ProfissaoTO>();
        try {
            ProfissaoRemote profissaoEjb = (ProfissaoRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/ProfissaoFacade!br.org.icmcuritiba.interfaces.ProfissaoRemote");
            List<Profissao> lstEntityProfissao = profissaoEjb.getAllProfissoes();
            for(Profissao p:lstEntityProfissao){
                ProfissaoTO to = new ProfissaoTO();
                to.setCodprofissao(p.getCodprofissao());
                to.setDescprofissao(p.getDescprofissao());
                lstProfissao.add(to);
            }
        } catch (NamingException ex) {
            new EventosException(ex, ProfissaoWS.class.getName());
        }
       return lstProfissao;
    }

}
