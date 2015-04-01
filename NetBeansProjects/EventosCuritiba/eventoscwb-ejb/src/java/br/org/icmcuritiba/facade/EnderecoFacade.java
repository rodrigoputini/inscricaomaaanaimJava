/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.facade;

import br.org.icmcuritiba.entity.Endereco;
import br.org.icmcuritiba.exception.EventosException;
import br.org.icmcuritiba.interfaces.EnderecoRemote;
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
public class EnderecoFacade extends AbstractFacade<Endereco> implements EnderecoRemote{
    @PersistenceContext(unitName = "eventoscwb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnderecoFacade() {
        super(Endereco.class);
    }

    @Override
    public Endereco getEnderecoByCep(String cep) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Endereco getEnderecoById(BigDecimal codEndereco) {
        Endereco endereco  = new Endereco();
        try{
            Query q = this.getEntityManager().createNamedQuery("Endereco.findByCodendereco");
            q.setParameter("codendereco", codEndereco);
            endereco = (Endereco)q.getSingleResult();
        }
        catch(Exception e){
            new EventosException(e, EnderecoFacade.class.getName());
        }
        return endereco;
    }
    
    
    
}
