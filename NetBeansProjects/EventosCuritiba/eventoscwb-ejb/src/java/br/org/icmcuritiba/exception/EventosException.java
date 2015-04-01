/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
public class EventosException extends Exception{
    
    public EventosException(Exception e, String className){
         Logger.getLogger(className).log(Level.SEVERE, null, e);
        //loga exception
        // envia alerta de excessão
        
    }
    
    
}
