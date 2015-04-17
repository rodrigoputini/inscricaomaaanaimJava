/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icmcuritiba.auth.rest;

import br.com.icmcuritiba.auth.to.MenuTO;
import br.com.icmcuritiba.auth.to.SessionTO;
import br.com.icmcuritiba.auth.to.UserTO;
import br.com.icmcuritiba.ejb.AuthBeanRemote;
import br.com.icmcuritiba.ejb.AutorizationBeanRemote;
import java.util.List;
import javax.naming.InitialContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Rodrigo Camargo Putini - rodrigo.putini@gmail.com
 */
@Path("/auth")
public class AuthICMRest {
    
    @POST
    @Path("/ldap")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean ldapAuth(UserTO uto){
        boolean auth = false;
        try {
            AuthBeanRemote authBean = (AuthBeanRemote)new InitialContext().lookup("ejb:saicmpr/saicmpr-ejb/AuthBean!br.com.icmcuritiba.ejb.AuthBeanRemote");       
            auth = authBean.auth(uto.getName(), uto.getPass());
      
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auth;
    } 
    
    @POST
    @Path("/autorization")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String ldapAutorization(UserTO uto){
        String role = null;
        try {
            AutorizationBeanRemote autoBean = (AutorizationBeanRemote)new InitialContext().lookup("ejb:saicmpr/saicmpr-ejb/AutorizationBean!br.com.icmcuritiba.ejb.AutorizationBeanRemote");       
            role = autoBean.loadRole(uto.getName(), uto.getPass());
      
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    } 

    @POST
    @Path("/menu")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<MenuTO> loadMenu(SessionTO session){
        List<MenuTO> lstMenu = null;
        try {
            AutorizationBeanRemote autoBean = (AutorizationBeanRemote)new InitialContext().lookup("ejb:saicmpr/saicmpr-ejb/AutorizationBean!br.com.icmcuritiba.ejb.AutorizationBeanRemote");       
            lstMenu = autoBean.loadMenuByRole(session.getRole(),session.getSistema());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstMenu;
    }

    @POST
    @Path("/userdetails")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public SessionTO userDetails(SessionTO session){
        try {
            AutorizationBeanRemote autoBean = (AutorizationBeanRemote)new InitialContext().lookup("ejb:saicmpr/saicmpr-ejb/AutorizationBean!br.com.icmcuritiba.ejb.AutorizationBeanRemote");       
            session = autoBean.loadCodIgrejaByUser(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }    
    

}
