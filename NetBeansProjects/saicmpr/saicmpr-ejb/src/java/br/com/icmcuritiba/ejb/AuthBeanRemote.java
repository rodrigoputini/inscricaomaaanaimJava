/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icmcuritiba.ejb;

import javax.ejb.Remote;

/**
 *
 * @author Rodrigo Camargo Putini - rodrigo.putini@gmail.com
 */
@Remote
public interface AuthBeanRemote {
    
    public boolean auth(String user, String pass);
    
}
