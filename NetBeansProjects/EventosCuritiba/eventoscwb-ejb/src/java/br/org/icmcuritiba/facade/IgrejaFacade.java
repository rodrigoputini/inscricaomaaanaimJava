/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.facade;

import br.org.icmcuritiba.entity.Igreja;
import br.org.icmcuritiba.exception.EventosException;
import br.org.icmcuritiba.interfaces.IgrejaRemote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
@Stateless
public class IgrejaFacade extends AbstractFacade<Igreja> implements IgrejaRemote{
    @PersistenceContext(unitName = "eventoscwb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IgrejaFacade() {
        super(Igreja.class);
    }

    @Override
    public Igreja getIgrejaByCodPresbiterio(String codPresbiterio) {
        Igreja igreja  = new Igreja();
        try{
            Query q = this.getEntityManager().createNamedQuery("Igreja.findByCodpresbiterio");
            q.setParameter("codpresbiterio", codPresbiterio);
            igreja = (Igreja)q.getSingleResult();
        }
        catch(Exception e){
            new EventosException(e, IgrejaFacade.class.getName());
        }
        return igreja;
    }
    
}
