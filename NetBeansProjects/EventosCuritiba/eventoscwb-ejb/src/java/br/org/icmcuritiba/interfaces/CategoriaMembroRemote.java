/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.interfaces;

import br.org.icmcuritiba.entity.Categoriamembro;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
@Remote
public interface CategoriaMembroRemote {
    public List<Categoriamembro> getAllCategoriasMembro();
    public Categoriamembro getCategoriasMembroById(BigDecimal codCatMembro);
    
}
