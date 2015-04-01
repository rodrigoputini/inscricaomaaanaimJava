/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.interfaces;

import br.org.icmcuritiba.entity.Membro;
import java.math.BigDecimal;
import javax.ejb.Remote;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
@Remote
public interface MembroRemote {
    
    public Membro getMembroById(BigDecimal codMembro);
    public Membro getMembroByCodPessoa(BigDecimal codPessoa);
    
}
