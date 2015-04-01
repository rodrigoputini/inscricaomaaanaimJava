/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.interfaces;

import br.org.icmcuritiba.entity.Igreja;
import javax.ejb.Remote;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
@Remote
public interface IgrejaRemote {
    public Igreja getIgrejaByCodPresbiterio(String codPresbiterio);
    
}
