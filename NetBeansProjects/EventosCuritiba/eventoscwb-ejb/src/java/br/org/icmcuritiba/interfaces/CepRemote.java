/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.interfaces;

import br.org.icmcuritiba.entity.Cep;
import javax.ejb.Remote;

/**
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 * @since 09 Apr 2015
 */
@Remote
public interface CepRemote {
    
    public Cep loadUnknowAddress(String cep);
    
}
