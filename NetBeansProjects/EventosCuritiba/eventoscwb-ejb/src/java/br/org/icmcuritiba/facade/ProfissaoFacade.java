/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.facade;

import br.org.icmcuritiba.entity.Profissao;
import br.org.icmcuritiba.exception.EventosException;
import br.org.icmcuritiba.interfaces.ProfissaoRemote;
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
public class ProfissaoFacade extends AbstractFacade<Profissao> implements ProfissaoRemote{
    @PersistenceContext(unitName = "eventoscwb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfissaoFacade() {
        super(Profissao.class);
    }

    /**
     * retorna lista com todas as profissoes cadastradas no sistema
     * @return 
     */
    @Override
    public List<Profissao> getAllProfissoes(){
        List<Profissao> lstProfissao = new ArrayList<Profissao>();
        try {
            Query q = this.getEntityManager().createNamedQuery("Profissao.findAll");
            lstProfissao = q.getResultList();
        } catch (Exception e) {
             new EventosException(e, ProfissaoFacade.class.getName());
        }        
        return lstProfissao;
    }
    
    
    @Override
    public Profissao getProfissaoById(BigDecimal codProfissao){
        Profissao profissao = new Profissao();
        try {
            Query q = this.getEntityManager().createNamedQuery("Profissao.findByCodprofissao");
            q.setParameter("codprofissao", codProfissao);
            profissao = (Profissao)q.getSingleResult();
        } catch (Exception e) {
             new EventosException(e, ProfissaoFacade.class.getName());
        }        
        return profissao;
    }
}
