/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.facade;

import br.org.icmcuritiba.entity.Equipe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
@Stateless
public class EquipeFacade extends AbstractFacade<Equipe> {
    @PersistenceContext(unitName = "eventoscwb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipeFacade() {
        super(Equipe.class);
    }
    
}
