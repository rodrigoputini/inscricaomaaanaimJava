/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icmcuritiba.util;

import br.com.icmcuritiba.auth.to.SessionTO;
import br.com.icmcuritiba.auth.to.UserTO;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 *
 * @author Rodrigo Camargo Putini - rodrigo.putini@gmail.com
 */
public class SaicmprAuth {

    public boolean saicmAuthentication(UserTO uto) {
        boolean result = false;

        try {
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target("http://localhost:8080/saicmpr-war/rest/auth/ldap");
            Response response = target.request().post(Entity.entity(uto, "application/json"));
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            //System.out.println("Server response : \n");
            String res = response.readEntity(String.class);
            if (res.contains("true")) {
                result = true;
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String saicmAutorization(UserTO uto) {
        String result = "";

        try {
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target("http://localhost:8080/saicmpr-war/rest/auth/autorization");
            Response response = target.request().post(Entity.entity(uto, "application/json"));
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            //System.out.println("Server response : \n");
            result = response.readEntity(String.class);
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

     public SessionTO userDetails(SessionTO session) {

        try {
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target("http://localhost:8080/saicmpr-war/rest/auth/userdetails");
            Response response = target.request().post(Entity.entity(session, "application/json"));
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            //System.out.println("Server response : \n");
            session = response.readEntity(SessionTO.class);
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }    
    
}
