/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.facade;

import br.org.icmcuritiba.entity.Categoriainscricao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s016361
 */
@Stateless
public class CategoriainscricaoFacade extends AbstractFacade<Categoriainscricao> {
    @PersistenceContext(unitName = "eventos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriainscricaoFacade() {
        super(Categoriainscricao.class);
    }
    
}