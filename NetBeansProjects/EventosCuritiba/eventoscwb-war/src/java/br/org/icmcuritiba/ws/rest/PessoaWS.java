/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.ws.rest;

import br.com.icmcuritiba.auth.to.SessionTO;
import br.org.icmcuritiba.entity.Categoriamembro;
import br.org.icmcuritiba.entity.Endereco;
import br.org.icmcuritiba.entity.Membro;
import br.org.icmcuritiba.entity.Pessoa;
import br.org.icmcuritiba.entity.Profissao;
import br.org.icmcuritiba.exception.EventosException;
import br.org.icmcuritiba.interfaces.CategoriaMembroRemote;
import br.org.icmcuritiba.interfaces.EnderecoRemote;
import br.org.icmcuritiba.interfaces.MembroRemote;
import br.org.icmcuritiba.interfaces.PessoaRemote;
import br.org.icmcuritiba.interfaces.ProfissaoRemote;
import br.org.icmcuritiba.to.MembroTO;
import br.org.icmcuritiba.to.PessoaTO;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Rodrigo Camargo Putini - rodrigo.putini@gmail.com
 */
@Path("/pessoa")
public class PessoaWS {

    @POST
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<MembroTO> getAll(SessionTO session) {
        List<MembroTO> lstMembroTO = new ArrayList<MembroTO>();
        try {

            PessoaRemote pessoaEjb = (PessoaRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/PessoaFacade!br.org.icmcuritiba.interfaces.PessoaRemote");
            List<Pessoa> lstPessoa = pessoaEjb.getAllByCodIgreja(session.getCodIgreja());
            for (Pessoa p : lstPessoa) {
                MembroTO to = new MembroTO();
                to.setCodpessoa(p.getCodpessoa());
                to.setNome(p.getNome());
                to.setSexo(p.getSexo());
                to.setEstadocivil(p.getEstadocivil());
                to.setDatanascimento(p.getDatanascimento());
                to.setTiposangue(p.getTiposangue());
                to.setDoadorsangue(p.getDoadorsangue());
                to.setIdentidade(p.getIdentidade());
                to.setRgorgaoexpedidor(p.getRgorgaoexpedidor());
                to.setRgdataexpedicao(p.getRgdataexpedicao());
                to.setEmail(p.getEmail());
                to.setCpf(p.getCpf());
                to.setPne(p.getPne());
                to.setTipopne(p.getTipopne());
                to.setObservacoes(p.getObservacoes());
                to.setDocinternacional(p.getDocinternacional());
                to.setCelular(p.getCelular());
                to.setTelefone(p.getTelefone());
                to.setTelcomercial(p.getTelcomercial());
                to.setComplemento(p.getComplemento());
                to.setNumerorua(p.getNumerorua());
                to.setCodmembro(p.getMembro().getCodmembro());
                lstMembroTO.add(to);
            }

        } catch (Exception e) {
            new EventosException(e, PessoaWS.class.getName());
        }
        return lstMembroTO;
    }

    @POST
    @Path("/autonotmember")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<MembroTO> getAutoNotMember(PessoaTO pessoa) {
        List<MembroTO> lstMembroTO = new ArrayList<MembroTO>();
        System.out.println("nome pessoa: "+pessoa.getNomePessoa());
        try {
            PessoaRemote pessoaEjb = (PessoaRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/PessoaFacade!br.org.icmcuritiba.interfaces.PessoaRemote");
            List<Pessoa> lstPessoa = pessoaEjb.getByNameAutocompleteNotMember(pessoa.getNomePessoa());
            for (Pessoa p : lstPessoa) {
                MembroTO to = new MembroTO();
                to.setCodpessoa(p.getCodpessoa());
                to.setNome(p.getNome());
                lstMembroTO.add(to);
            }
        } catch (Exception e) {
            new EventosException(e, PessoaWS.class.getName());
        }
        return lstMembroTO;
    }

    @POST
    @Path("/findbycpf")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MembroTO getByCpf(PessoaTO pto) {
        MembroTO to = new MembroTO();
        try {
            PessoaRemote pessoaEjb = (PessoaRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/PessoaFacade!br.org.icmcuritiba.interfaces.PessoaRemote");
            //CategoriaMembroRemote cmEjb = (CategoriaMembroRemote) ic.lookup("ejb:EventosCuritiba/eventoscwb-ejb/CategoriamembroFacade!br.org.icmcuritiba.interfaces.CategoriaMembroRemote");
            //ProfissaoRemote profEjb = (ProfissaoRemote) ic.lookup("ejb:EventosCuritiba/eventoscwb-ejb/ProfissaoFacade!br.org.icmcuritiba.interfaces.ProfissaoRemote");
            //EnderecoRemote enderecoEjb = (EnderecoRemote) ic.lookup("ejb:EventosCuritiba/eventoscwb-ejb/EnderecoFacade!br.org.icmcuritiba.interfaces.EnderecoRemote");
            //MembroRemote membroEjb = (MembroRemote) ic.lookup("ejb:EventosCuritiba/eventoscwb-ejb/MembroFacade!br.org.icmcuritiba.interfaces.MembroRemote");
            
            Pessoa p = pessoaEjb.getByCpf(pto.getCpf());
            
            if(null != p && null!= p.getCpf()){
                to =  pessoaEjb.loadFullMembro(p.getCodpessoa());
                to.setStatus("membro");
                to.setNome(p.getNome());
                to.setSexo(p.getSexo());
                to.setEstadocivil(p.getEstadocivil());
                to.setDatanascimento(p.getDatanascimento());
                to.setTiposangue(p.getTiposangue());
                to.setDoadorsangue(p.getDoadorsangue());
                to.setIdentidade(p.getIdentidade());
                to.setRgorgaoexpedidor(p.getRgorgaoexpedidor());
                to.setRgdataexpedicao(p.getRgdataexpedicao());
                to.setEmail(p.getEmail());
                to.setCpf(p.getCpf());
                to.setPne(p.getPne());
                to.setTipopne(p.getTipopne());
                to.setObservacoes(p.getObservacoes());
                to.setDocinternacional(p.getDocinternacional());
                to.setCelular(p.getCelular());
                to.setTelefone(p.getTelefone());
                to.setTelcomercial(p.getTelcomercial());
                to.setComplemento(p.getComplemento());
                to.setNumerorua(p.getNumerorua());
                to.setCodmembro(p.getMembro().getCodmembro());
                to.setMensagem("Membro existente, dados modificados serão atualizados");

            }
            else{
                p = pessoaEjb.getByCpfNotMember(pto.getCpf());
                if(null != p){
                    to.setStatus("naomembro");
                    to.setCodpessoa(p.getCodpessoa());
                    to.setNome(p.getNome());
                    to.setSexo(p.getSexo());
                    to.setEstadocivil(p.getEstadocivil());
                    to.setDatanascimento(p.getDatanascimento());
                    to.setTiposangue(p.getTiposangue());
                    to.setDoadorsangue(p.getDoadorsangue());
                    to.setIdentidade(p.getIdentidade());
                    to.setRgorgaoexpedidor(p.getRgorgaoexpedidor());
                    to.setRgdataexpedicao(p.getRgdataexpedicao());
                    to.setEmail(p.getEmail());
                    to.setCpf(p.getCpf());
                    to.setPne(p.getPne());
                    to.setTipopne(p.getTipopne());
                    to.setObservacoes(p.getObservacoes());
                    to.setDocinternacional(p.getDocinternacional());
                    to.setCelular(p.getCelular());
                    to.setTelefone(p.getTelefone());
                    to.setTelcomercial(p.getTelcomercial());
                    to.setComplemento(p.getComplemento());
                    to.setNumerorua(p.getNumerorua());
                    to.setMensagem("Pessoa não membro encontrada, favor atualizar dados");
                }
                else{
                    to = null;
                }
            }


        } catch (Exception e) {
            new EventosException(e, PessoaWS.class.getName());
        }
        return to;
    }    
    
}
