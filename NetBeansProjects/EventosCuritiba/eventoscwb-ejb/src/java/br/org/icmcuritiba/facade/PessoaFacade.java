/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.facade;

import br.org.icmcuritiba.entity.Pessoa;
import br.org.icmcuritiba.interfaces.PessoaRemote;
import br.org.icmcuritiba.to.PessoaTO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo C Putini
 */

@Stateless
public class PessoaFacade extends AbstractFacade<Pessoa> implements PessoaRemote{
    @PersistenceContext(unitName = "eventoscwb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PessoaFacade() {
        super(Pessoa.class);
    }
    
    

    @Override
    public List<Pessoa> getAllPessoas(){
        List<Pessoa> lstPessoa= null;
        try {
            Query q = this.getEntityManager().createNamedQuery("Pessoa.findAll");
            lstPessoa = q.getResultList();
         } catch (Exception e) {
             e.printStackTrace();
        }
        return lstPessoa;
    }

    @Override
    public List<Pessoa> getAllByCodIgreja(String codPresbiterio) {
        List<Pessoa> lstPessoa = new ArrayList<Pessoa>();
        try {
            Query q = this.getEntityManager().createNamedQuery("Pessoa.findByCodIgreja");
            q.setParameter("codPresbiterio", codPresbiterio);
            lstPessoa = q.getResultList();
        } catch (Exception e) {
             e.printStackTrace();
        }
        return lstPessoa;
    }
    
}
