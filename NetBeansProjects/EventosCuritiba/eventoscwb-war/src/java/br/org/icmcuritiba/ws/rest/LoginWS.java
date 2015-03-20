/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.ws.rest;

import br.com.icmcuritiba.auth.to.UserTO;
import br.com.icmcuritiba.util.SaicmprAuth;
import br.com.icmcuritiba.auth.to.SessionTO;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Rodrigo Camargo Putini - rodrigo.putini@gmail.com
 */
@Path("/login")
public class LoginWS {

    @POST
    @Path("/auth")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public SessionTO ldapAuth(UserTO uto, @Context HttpServletRequest req) {
        SessionTO result = new SessionTO();
        SaicmprAuth auth = new SaicmprAuth();
        String name = uto.getName();
        if (auth.saicmAuthentication(uto)) {
            String role = auth.saicmAutorization(uto);
            result.setRole(role);
            result.setUid(req.getSession(true).getId());
            result.setUsername(name);
            result = auth.userDetails(result);
        }
        return result;
    }
}
