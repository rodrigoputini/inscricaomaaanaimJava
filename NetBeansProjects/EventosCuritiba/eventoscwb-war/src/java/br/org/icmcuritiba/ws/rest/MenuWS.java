/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.ws.rest;

import br.com.icmcuritiba.auth.to.MenuTO;
import br.com.icmcuritiba.auth.to.SessionTO;
import br.com.icmcuritiba.util.SessionUtils;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Rodrigo Camargo Putini - rodrigo.putini@gmail.com
 * @since 17 mar 2015
 */
@Path("/menu")
public class MenuWS {
    
    
    @POST
    @Path("/loadmenu")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<MenuTO> loadMenu(SessionTO session){
        List<MenuTO> lstMenu = null;
        SessionUtils sessionUtils = new SessionUtils();
        lstMenu = sessionUtils.loadMenuByRole(session);
        return lstMenu;
    }
}
