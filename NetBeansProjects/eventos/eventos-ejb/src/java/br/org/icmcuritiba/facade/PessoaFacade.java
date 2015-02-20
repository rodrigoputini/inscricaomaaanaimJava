/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.facade;

import br.org.icmcuritiba.entity.Pessoa;
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
public class PessoaFacade extends AbstractFacade<Pessoa> {
    @PersistenceContext(unitName = "eventos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PessoaFacade() {
        super(Pessoa.class);
    }
    
    public List<Pessoa> listAllPessoa(){
        List<Pessoa> retorno = null;
        try{
            Query q  = getEntityManager().createNamedQuery("Pessoa.findAll",Pessoa.class);
            retorno = q.getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
        }
             
                

        return retorno;
    }
    
}
