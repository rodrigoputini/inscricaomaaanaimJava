/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.facade;

import br.org.icmcuritiba.entity.Categoriamembro;
import br.org.icmcuritiba.exception.EventosException;
import br.org.icmcuritiba.interfaces.CategoriaMembroRemote;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
@Stateless
public class CategoriamembroFacade extends AbstractFacade<Categoriamembro> implements CategoriaMembroRemote {
    @PersistenceContext(unitName = "eventoscwb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriamembroFacade() {
        super(Categoriamembro.class);
    }

    @Override
    public List<Categoriamembro> getAllCategoriasMembro() {
        List<Categoriamembro> lstCatMembro = new ArrayList<Categoriamembro>();
        try {
            Query q = this.getEntityManager().createNamedQuery("Categoriamembro.findAll");
            lstCatMembro = q.getResultList();
        } catch (Exception e) {
             new EventosException(e, CategoriamembroFacade.class.getName());
        }   
        return lstCatMembro;
    }

    @Override
    public Categoriamembro getCategoriasMembroById(BigDecimal codCatMembro) {
        Categoriamembro catMembro = new Categoriamembro();
        try {
            Query q = this.getEntityManager().createNamedQuery("Categoriamembro.findByCodcategoriamembro");
            q.setParameter("codcategoriamembro", codCatMembro);
            catMembro = (Categoriamembro)q.getSingleResult();
        } catch (Exception e) {
             new EventosException(e, CategoriamembroFacade.class.getName());
        }   
        return catMembro;
    }    
    
}
