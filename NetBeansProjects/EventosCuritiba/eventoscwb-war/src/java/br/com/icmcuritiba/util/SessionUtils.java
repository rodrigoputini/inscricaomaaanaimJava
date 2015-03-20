/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icmcuritiba.util;

import br.com.icmcuritiba.auth.to.MenuTO;
import br.com.icmcuritiba.auth.to.SessionTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 *
 * @author Rodrigo Camargo Putini - rodrigo.putini@gmail.com
 * @since 16 mar 2015
 */
public class SessionUtils {
    
    
    /**
     * 
     * @param role
     * @return 
     * retorn lista de menus do usuario pela role a que o usuario pertence
     */
    public List<MenuTO> loadMenuByRole(SessionTO session){
        List<MenuTO> lstMenu = new ArrayList<MenuTO>();
            try {
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target("http://localhost:8080/saicmpr-war/rest/auth/menu");
            Response response = target.request().post(Entity.entity(session, "application/json"));
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            //System.out.println("Server response : \n");
            lstMenu = response.readEntity(new GenericType<List<MenuTO>>() {});
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lstMenu;
    }

    
    
}
