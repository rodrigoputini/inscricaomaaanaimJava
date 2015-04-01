/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.ws.rest;

import br.com.icmcuritiba.auth.to.SessionTO;
import br.org.icmcuritiba.entity.Igreja;
import br.org.icmcuritiba.exception.EventosException;
import br.org.icmcuritiba.interfaces.IgrejaRemote;
import br.org.icmcuritiba.to.IgrejaTO;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 * @since 26 mar 2015
 */
@Path("/igreja")
public class IgrejaWS {
    
    @POST
    @Path("/bycodpes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public IgrejaTO getByCodPresbiterio(SessionTO session){
        IgrejaTO ito = new IgrejaTO();
        try {
            IgrejaRemote igrejaEjb = (IgrejaRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/IgrejaFacade!br.org.icmcuritiba.interfaces.IgrejaRemote");
            Igreja igreja = igrejaEjb.getIgrejaByCodPresbiterio(session.getCodIgreja());
            ito.setCodigreja(igreja.getCodigreja());
            ito.setCodpresbiterio(igreja.getCodpresbiterio());
            ito.setNomeigreja(igreja.getNomeigreja());
        } catch (NamingException ex) {
            new EventosException(ex, IgrejaWS.class.getName());
        }
       return ito;
    }

}
