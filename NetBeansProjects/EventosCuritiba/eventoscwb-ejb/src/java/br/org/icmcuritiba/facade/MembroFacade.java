/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.facade;

import br.org.icmcuritiba.entity.Membro;
import br.org.icmcuritiba.exception.EventosException;
import br.org.icmcuritiba.interfaces.MembroRemote;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
@Stateless
public class MembroFacade extends AbstractFacade<Membro> implements MembroRemote {
    @PersistenceContext(unitName = "eventoscwb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MembroFacade() {
        super(Membro.class);
    }

    @Override
    public Membro getMembroById(BigDecimal codMembro) {
        Membro membro = new Membro();
        try{
            Query q = this.getEntityManager().createNamedQuery("Membro.findByCodmembro");
            q.setParameter("codmembro", codMembro);
            membro = (Membro)q.getSingleResult();
        }
        catch(Exception e){
            new EventosException(e, MembroFacade.class.getName());
        }
        
        return membro;
    }
    @Override
    public Membro getMembroByCodPessoa(BigDecimal codPessoa) {
        Membro membro = new Membro();
        try{
            Query q = this.getEntityManager().createNamedQuery("Membro.findByCodPessoa");
            q.setParameter("codpessoa", codPessoa);
            membro = (Membro)q.getSingleResult();
        }
        catch(Exception e){
            new EventosException(e, MembroFacade.class.getName());
        }
        
        return membro;
    }
    
}
