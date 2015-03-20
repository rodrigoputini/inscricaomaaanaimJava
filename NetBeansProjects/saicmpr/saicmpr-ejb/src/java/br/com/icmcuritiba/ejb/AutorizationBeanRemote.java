/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icmcuritiba.ejb;

import br.com.icmcuritiba.auth.to.MenuTO;
import br.com.icmcuritiba.auth.to.SessionTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Rodrigo Camargo Putini - rodrigo.putini@gmail.com
 */
@Remote
public interface AutorizationBeanRemote {
    
    public String loadRole(String username, String pass);
    public List<MenuTO> loadMenuByRole(String role, String sistema);
    public SessionTO loadCodIgrejaByUser(SessionTO session);
 
    
}
