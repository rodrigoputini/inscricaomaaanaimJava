/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.facade;

import br.org.icmcuritiba.entity.Categoriamembro;
import br.org.icmcuritiba.entity.Endereco;
import br.org.icmcuritiba.entity.Membro;
import br.org.icmcuritiba.entity.Pessoa;
import br.org.icmcuritiba.exception.EventosException;
import br.org.icmcuritiba.interfaces.PessoaRemote;
import br.org.icmcuritiba.to.MembroTO;
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
             new EventosException(e, PessoaFacade.class.getName());
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
             new EventosException(e, PessoaFacade.class.getName());
        }
        return lstPessoa;
    }

    @Override
    public List<Pessoa> getByNameAutocompleteNotMember(String nome) {
         List<Pessoa> lstPessoa = new ArrayList<Pessoa>();
         StringBuffer sql = new StringBuffer();
         sql.append("select * from tb_pessoa p where p.codpessoa not in (select m.codpessoa from tb_membro m ) and p.nome like '")
                 .append(nome).append("%'");
        try {
            lstPessoa = this.getEntityManager().createNativeQuery(sql.toString(), Pessoa.class).getResultList();
        } catch (Exception e) {
             new EventosException(e, PessoaFacade.class.getName());
        }
        return lstPessoa;
    }

    @Override
    public Pessoa getByCpf(String cpf) {
        Pessoa pessoa = new Pessoa();
        StringBuffer sql = new StringBuffer();
         sql.append("select * from tb_pessoa p where p.codpessoa in (select m.codpessoa from tb_membro m ) and p.cpf = '")
                 .append(cpf).append("'");
        try {
            pessoa = (Pessoa)this.getEntityManager().createNativeQuery(sql.toString(), Pessoa.class).getSingleResult();
            
        } catch (Exception e) {
             new EventosException(e, PessoaFacade.class.getName());
        }
        return pessoa;

    }

    @Override
    public Pessoa getByCpfNotMember(String cpf) {
        Pessoa pessoa = new Pessoa();
        try {
            Query q = this.getEntityManager().createNamedQuery("Pessoa.findByCpf");
            q.setParameter("cpf", cpf);
            pessoa = (Pessoa)q.getSingleResult();
        } catch (Exception e) {
             new EventosException(e, PessoaFacade.class.getName());
        }
        return pessoa;
    }

    @Override
    public MembroTO loadFullMembro(BigDecimal codpessoa) {
        MembroTO membroto = new MembroTO();
        Membro membro = new Membro();
        Endereco e = new Endereco();
        StringBuffer sql = new StringBuffer();
         sql.append("select * from tb_membro m where m.codpessoa = ")
                 .append(codpessoa);
        try{
            //Carrega membro
            membro = (Membro)this.getEntityManager().createNativeQuery(sql.toString(),Membro.class).getSingleResult();

            membroto.setCodmembro(membro.getCodmembro());
            membroto.setCodcategoriamembro(membro.getCodcategoriamembro().getCodcategoriamembro());
            membroto.setCodprofissao(membro.getCodprofissao().getCodprofissao());
            
            Query qe = this.getEntityManager().createNamedQuery("Endereco.findByCodendereco");
            qe.setParameter("codendereco", membro.getCodendereco().getCodendereco());
            e = (Endereco)qe.getSingleResult();
            
            membroto.setCodendereco(e.getCodendereco());
            membroto.setLogradouro(e.getLogradouro());
            membroto.setBairro(e.getBairro());
            membroto.setCidade(e.getCidade());
            membroto.setEstado(e.getEstado());
            membroto.setPais(e.getPais());
            membroto.setCep(e.getCep());
        }
        catch(Exception ex){
            new EventosException(ex, PessoaFacade.class.getName());
        }
        
        
        return membroto;
        
    }
    
}
