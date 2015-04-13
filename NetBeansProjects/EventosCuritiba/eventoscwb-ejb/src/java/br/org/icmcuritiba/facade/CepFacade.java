/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.facade;

import br.org.icmcuritiba.entity.Cep;
import br.org.icmcuritiba.exception.EventosException;
import br.org.icmcuritiba.interfaces.CepRemote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 * @since 09 Apr 2015
 */
@Stateless
public class CepFacade implements CepRemote{
    @PersistenceContext(unitName = "eventoscwb-cep")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Cep loadUnknowAddress(String cep) {
        Cep endereco = new Cep();
        StringBuffer sql = new StringBuffer();
        sql.append("select 0 as codendereco, logr.log_tipo_logradouro ||' '|| ")
                    .append("logr.log_no_sem_acento as logradouro, ")
                    .append("bairro.bai_no bairro, ")
                    .append("loc.loc_no as cidade, ")
                    .append("loc.ufe_sg as estado, ")
                    .append("'Brasil' as pais, ")
                    .append("logr.cep as cep ")
                    .append("from cep.log_logradouro logr, ")
                    .append("cep.log_bairro bairro, ")
                    .append("cep.log_localidade loc ")
                    .append("where bairro.bai_nu_sequencial  =  logr.bai_nu_sequencial_ini  ")
                    .append("and bairro.loc_nu_sequencial = loc.loc_nu_sequencial ")
                    .append("and logr.cep = '")
                    .append(cep)
                    .append("'");
        try {
            endereco = (Cep)this.getEntityManager().createNativeQuery(sql.toString(),Cep.class).getSingleResult();
            
        } catch (Exception e) {
            e.printStackTrace();
            endereco = null;
        }
        return endereco;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
