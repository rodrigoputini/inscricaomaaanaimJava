/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.ws.rest;

import br.com.icmcuritiba.auth.to.SessionTO;
import br.org.icmcuritiba.entity.Categoriamembro;
import br.org.icmcuritiba.entity.Cep;
import br.org.icmcuritiba.entity.Endereco;
import br.org.icmcuritiba.entity.Igreja;
import br.org.icmcuritiba.entity.Membro;
import br.org.icmcuritiba.entity.Pessoa;
import br.org.icmcuritiba.entity.Profissao;
import br.org.icmcuritiba.exception.EventosException;
import br.org.icmcuritiba.interfaces.CategoriaMembroRemote;
import br.org.icmcuritiba.interfaces.CepRemote;
import br.org.icmcuritiba.interfaces.EnderecoRemote;
import br.org.icmcuritiba.interfaces.IgrejaRemote;
import br.org.icmcuritiba.interfaces.MembroRemote;
import br.org.icmcuritiba.interfaces.PessoaRemote;
import br.org.icmcuritiba.interfaces.ProfissaoRemote;
import br.org.icmcuritiba.to.MembroTO;
import br.org.icmcuritiba.to.Mensagem;
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
                to.setDoadorsangue(String.valueOf(p.getDoadorsangue()));
                to.setIdentidade(p.getIdentidade());
                to.setRgorgaoexpedidor(p.getRgorgaoexpedidor());
                to.setRgdataexpedicao(p.getRgdataexpedicao());
                to.setEmail(p.getEmail());
                to.setCpf(p.getCpf());
                to.setPne(String.valueOf(p.getPne()));
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
        System.out.println("nome pessoa: " + pessoa.getNomePessoa());
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
    public MembroTO getByCpf(PessoaTO pto) throws EventosException {
        MembroTO to = new MembroTO();
        try {
            PessoaRemote pessoaEjb = (PessoaRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/PessoaFacade!br.org.icmcuritiba.interfaces.PessoaRemote");
            IgrejaRemote igrejaEjb = (IgrejaRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/IgrejaFacade!br.org.icmcuritiba.interfaces.IgrejaRemote");
            //CategoriaMembroRemote cmEjb = (CategoriaMembroRemote) ic.lookup("ejb:EventosCuritiba/eventoscwb-ejb/CategoriamembroFacade!br.org.icmcuritiba.interfaces.CategoriaMembroRemote");
            //ProfissaoRemote profEjb = (ProfissaoRemote) ic.lookup("ejb:EventosCuritiba/eventoscwb-ejb/ProfissaoFacade!br.org.icmcuritiba.interfaces.ProfissaoRemote");
            //EnderecoRemote enderecoEjb = (EnderecoRemote) ic.lookup("ejb:EventosCuritiba/eventoscwb-ejb/EnderecoFacade!br.org.icmcuritiba.interfaces.EnderecoRemote");
            //MembroRemote membroEjb = (MembroRemote) ic.lookup("ejb:EventosCuritiba/eventoscwb-ejb/MembroFacade!br.org.icmcuritiba.interfaces.MembroRemote");

            Pessoa p = pessoaEjb.getByCpf(pto.getCpf());

            if (null != p && null != p.getCpf()) {
                Igreja igreja = igrejaEjb.getIgrejaByCodPresbiterio(pto.getCodPresbiterio());
                to = pessoaEjb.loadFullMembro(p.getCodpessoa());
                if (igreja.getCodpresbiterio().equals(to.getCodigreja())) {
                    to.setCodpessoa(p.getCodpessoa());
                    to.setStatus("membro");
                    to.setNome(p.getNome());
                    to.setSexo(p.getSexo());
                    to.setEstadocivil(p.getEstadocivil());
                    to.setDatanascimento(p.getDatanascimento());
                    to.setTiposangue(p.getTiposangue());
                    to.setDoadorsangue(String.valueOf(p.getDoadorsangue()));
                    to.setIdentidade(p.getIdentidade());
                    to.setRgorgaoexpedidor(p.getRgorgaoexpedidor());
                    to.setRgdataexpedicao(p.getRgdataexpedicao());
                    to.setEmail(p.getEmail());
                    to.setCpf(p.getCpf());
                    to.setPne(String.valueOf(p.getPne()));
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
                } else {
                    to.setNome(p.getNome());
                    to.setStatus("membroOutraIgreja");
                    to.setMensagem(to.getNome() + " é membro registrado em outra igreja, impossível modificar dados!");
                    to.setNome("");
                }

            } else {
                p = pessoaEjb.getByCpfNotMember(pto.getCpf());
                if (null != p) {
                    to.setStatus("naomembro");
                    to.setCodigreja(pto.getCodPresbiterio());
                    to.setCodpessoa(p.getCodpessoa());
                    to.setNome(p.getNome());
                    to.setSexo(p.getSexo());
                    to.setEstadocivil(p.getEstadocivil());
                    to.setDatanascimento(p.getDatanascimento());
                    to.setTiposangue(p.getTiposangue());
                    to.setDoadorsangue(String.valueOf(p.getDoadorsangue()));
                    to.setIdentidade(p.getIdentidade());
                    to.setRgorgaoexpedidor(p.getRgorgaoexpedidor());
                    to.setRgdataexpedicao(p.getRgdataexpedicao());
                    to.setEmail(p.getEmail());
                    to.setCpf(p.getCpf());
                    to.setPne(String.valueOf(p.getPne()));
                    to.setTipopne(p.getTipopne());
                    to.setObservacoes(p.getObservacoes());
                    to.setDocinternacional(p.getDocinternacional());
                    to.setCelular(p.getCelular());
                    to.setTelefone(p.getTelefone());
                    to.setTelcomercial(p.getTelcomercial());
                    to.setComplemento(p.getComplemento());
                    to.setNumerorua(p.getNumerorua());
                    to.setCep("");
                    to.setMensagem("Pessoa não membro encontrada, favor atualizar dados");
                } else {
                    to.setStatus("novo");
                    to.setNome("");
                    to.setSexo("");
                    to.setEstadocivil("");
                    to.setTiposangue("");
                    to.setIdentidade("");
                    to.setEmail("");
                    to.setObservacoes("");
                    to.setCep("");
                    to.setCpf(pto.getCpf());
                }
            }

        } catch (Exception e) {
            throw new EventosException(e, PessoaWS.class.getName());
        }
        return to;
    }

    @POST
    @Path("/savemember")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensagem saveMember(MembroTO mto) throws EventosException {
        Mensagem msg = new Mensagem();
        try {
            PessoaRemote pessoaEjb = (PessoaRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/PessoaFacade!br.org.icmcuritiba.interfaces.PessoaRemote");
            MembroRemote membroEjb = (MembroRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/MembroFacade!br.org.icmcuritiba.interfaces.MembroRemote");
            EnderecoRemote enderecoEjb = (EnderecoRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/EnderecoFacade!br.org.icmcuritiba.interfaces.EnderecoRemote");
            CepRemote cepEjb = (CepRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/CepFacade!br.org.icmcuritiba.interfaces.CepRemote");
            IgrejaRemote igrejaEjb = (IgrejaRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/IgrejaFacade!br.org.icmcuritiba.interfaces.IgrejaRemote");
            CategoriaMembroRemote catMembroEjb = (CategoriaMembroRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/CategoriamembroFacade!br.org.icmcuritiba.interfaces.CategoriaMembroRemote");
            ProfissaoRemote profEjb = (ProfissaoRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/ProfissaoFacade!br.org.icmcuritiba.interfaces.ProfissaoRemote");
            if (mto.getStatus().equalsIgnoreCase("novo")) {
                //dados para novo registro de tabela pessoa
                Pessoa pessoa = new Pessoa();
                pessoa.setCelular(mto.getCelular());
                pessoa.setComplemento(mto.getComplemento());
                pessoa.setCpf(mto.getCpf());
                pessoa.setDatanascimento(mto.getDatanascimento());
                pessoa.setDoadorsangue(Boolean.parseBoolean(mto.getDoadorsangue()));
                pessoa.setDocinternacional(mto.getDocinternacional());
                pessoa.setEmail(mto.getEmail());
                pessoa.setEstadocivil(mto.getEstadocivil());
                pessoa.setIdentidade(mto.getIdentidade());
                pessoa.setNome(mto.getNome());
                pessoa.setNumerorua(mto.getNumerorua());
                pessoa.setObservacoes(mto.getObservacoes());
                pessoa.setPne(Boolean.parseBoolean(mto.getPne()));
                pessoa.setRgdataexpedicao(mto.getRgdataexpedicao());
                pessoa.setRgorgaoexpedidor(mto.getRgorgaoexpedidor());
                pessoa.setSexo(mto.getSexo());
                pessoa.setTelcomercial(mto.getTelcomercial());
                pessoa.setTelefone(mto.getTelefone());
                pessoa.setTipopne(mto.getTipopne());
                pessoa.setTiposangue(mto.getTiposangue());
                pessoaEjb.create(pessoa);
                pessoa = pessoaEjb.getByCpfNotMember(mto.getCpf());
                //dados novo registro de tabela membro
                Membro membro = new Membro();
                Endereco endereco = enderecoEjb.getEnderecoByCep(mto.getCep());
                //endereco do membro
                if (null != endereco) {
                    membro.setCodendereco(endereco);
                } else {
                    Cep cep = cepEjb.loadUnknowAddress(mto.getCep());
                    endereco = new Endereco();
                    endereco.setCep(cep.getCep());
                    endereco.setBairro(cep.getBairro());
                    endereco.setCidade(cep.getCidade());
                    endereco.setEstado(cep.getEstado());
                    endereco.setLogradouro(cep.getLogradouro());
                    endereco.setPais(cep.getPais());
                    enderecoEjb.create(endereco);
                    endereco = enderecoEjb.getEnderecoByCep(mto.getCep());
                }
                membro.setCodendereco(endereco);
                //igreja do membro

                Igreja igreja = igrejaEjb.getIgrejaByCodPresbiterio(mto.getCodigreja());
                membro.setCodigreja(igreja);
                //categoria do membro

                Categoriamembro catmem = catMembroEjb.getCategoriaMembroById(mto.getCodcategoriamembro());
                membro.setCodcategoriamembro(catmem);
                //pessoa membro de igreja
                membro.setCodpessoa(pessoa);
                //profissao do membro
                if (null != mto.getCodprofissao()) {
                    Profissao profissao = profEjb.getProfissaoById(mto.getCodprofissao());
                    membro.setCodprofissao(profissao);
                }

                //persiste membro com dados de pessoa, endereco, igreja, profissao, categoria
                membroEjb.create(membro);
                msg.setMensagem("Membro cadastrado com sucesso!");

            } else if (mto.getStatus().equalsIgnoreCase("naomembro")) {
                //dados para novo registro de tabela pessoa
                Pessoa pessoa = pessoaEjb.getByCpfNotMember(mto.getCpf());
                pessoa.setCelular(mto.getCelular());
                pessoa.setComplemento(mto.getComplemento());
                pessoa.setCpf(mto.getCpf());
                pessoa.setDatanascimento(mto.getDatanascimento());
                pessoa.setDoadorsangue(Boolean.parseBoolean(mto.getDoadorsangue()));
                pessoa.setDocinternacional(mto.getDocinternacional());
                pessoa.setEmail(mto.getEmail());
                pessoa.setEstadocivil(mto.getEstadocivil());
                pessoa.setIdentidade(mto.getIdentidade());
                pessoa.setNome(mto.getNome());
                pessoa.setNumerorua(mto.getNumerorua());
                pessoa.setObservacoes(mto.getObservacoes());
                pessoa.setPne(Boolean.parseBoolean(mto.getPne()));
                pessoa.setRgdataexpedicao(mto.getRgdataexpedicao());
                pessoa.setRgorgaoexpedidor(mto.getRgorgaoexpedidor());
                pessoa.setSexo(mto.getSexo());
                pessoa.setTelcomercial(mto.getTelcomercial());
                pessoa.setTelefone(mto.getTelefone());
                pessoa.setTipopne(mto.getTipopne());
                pessoa.setTiposangue(mto.getTiposangue());
                pessoaEjb.edit(pessoa);
                //dados novo registro de tabela membro
                Membro membro = new Membro();
                Endereco endereco = enderecoEjb.getEnderecoByCep(mto.getCep());
                //endereco do membro
                if (null != endereco) {
                    membro.setCodendereco(endereco);
                } else {
                    Cep cep = cepEjb.loadUnknowAddress(mto.getCep());
                    endereco = new Endereco();
                    endereco.setCep(cep.getCep());
                    endereco.setBairro(cep.getBairro());
                    endereco.setCidade(cep.getCidade());
                    endereco.setEstado(cep.getEstado());
                    endereco.setLogradouro(cep.getLogradouro());
                    endereco.setPais(cep.getPais());
                    enderecoEjb.create(endereco);
                    endereco = enderecoEjb.getEnderecoByCep(mto.getCep());
                }
                membro.setCodendereco(endereco);
                //igreja do membro
                Igreja igreja = igrejaEjb.getIgrejaByCodPresbiterio(mto.getCodigreja());
                membro.setCodigreja(igreja);
                //categoria do membro
                Categoriamembro catmem = catMembroEjb.getCategoriaMembroById(mto.getCodcategoriamembro());
                membro.setCodcategoriamembro(catmem);
                //pessoa membro de igreja
                membro.setCodpessoa(pessoa);
                //profissao do membro
                if (null != mto.getCodprofissao()) {
                    Profissao profissao = profEjb.getProfissaoById(mto.getCodprofissao());
                    membro.setCodprofissao(profissao);
                }

                //persiste membro com dados de pessoa, endereco, igreja, profissao, categoria
                membroEjb.create(membro);
                msg.setMensagem("Membro atualizado com sucesso!");

            } else if (mto.getStatus().equalsIgnoreCase("membro")) {
                Pessoa pessoa = pessoaEjb.getByCpf(mto.getCpf());
                pessoa.setCelular(mto.getCelular());
                pessoa.setComplemento(mto.getComplemento());
                pessoa.setCpf(mto.getCpf());
                pessoa.setDatanascimento(mto.getDatanascimento());
                pessoa.setDoadorsangue(Boolean.parseBoolean(mto.getDoadorsangue()));
                pessoa.setDocinternacional(mto.getDocinternacional());
                pessoa.setEmail(mto.getEmail());
                pessoa.setEstadocivil(mto.getEstadocivil());
                pessoa.setIdentidade(mto.getIdentidade());
                pessoa.setNome(mto.getNome());
                pessoa.setNumerorua(mto.getNumerorua());
                pessoa.setObservacoes(mto.getObservacoes());
                pessoa.setPne(Boolean.parseBoolean(mto.getPne()));
                pessoa.setRgdataexpedicao(mto.getRgdataexpedicao());
                pessoa.setRgorgaoexpedidor(mto.getRgorgaoexpedidor());
                pessoa.setSexo(mto.getSexo());
                pessoa.setTelcomercial(mto.getTelcomercial());
                pessoa.setTelefone(mto.getTelefone());
                pessoa.setTipopne(mto.getTipopne());
                pessoa.setTiposangue(mto.getTiposangue());
                pessoaEjb.edit(pessoa);
                //dados novo registro de tabela membro
                Membro membro = new Membro();
                Endereco endereco = enderecoEjb.getEnderecoByCep(mto.getCep());
                //endereco do membro
                if (null != endereco) {
                    membro.setCodendereco(endereco);
                } else {
                    Cep cep = cepEjb.loadUnknowAddress(mto.getCep());
                    endereco = new Endereco();
                    endereco.setCep(cep.getCep());
                    endereco.setBairro(cep.getBairro());
                    endereco.setCidade(cep.getCidade());
                    endereco.setEstado(cep.getEstado());
                    endereco.setLogradouro(cep.getLogradouro());
                    endereco.setPais(cep.getPais());
                    enderecoEjb.create(endereco);
                    endereco = enderecoEjb.getEnderecoByCep(mto.getCep());
                }
                membro.setCodendereco(endereco);
                //igreja do membro
                Igreja igreja = igrejaEjb.getIgrejaByCodPresbiterio(mto.getCodigreja());
                membro.setCodigreja(igreja);
                //categoria do membro
                Categoriamembro catmem = catMembroEjb.getCategoriaMembroById(mto.getCodcategoriamembro());
                membro.setCodcategoriamembro(catmem);
                //pessoa membro de igreja
                membro.setCodpessoa(pessoa);
                //profissao do membro
                if (null != mto.getCodprofissao()) {
                    Profissao profissao = profEjb.getProfissaoById(mto.getCodprofissao());
                    membro.setCodprofissao(profissao);
                }

                //persiste membro com dados de pessoa, endereco, igreja, profissao, categoria
                membro.setCodmembro(mto.getCodmembro());
                membroEjb.edit(membro);
                msg.setMensagem("Membro atualizado com sucesso!");
            }

        } catch (Exception e) {
            msg.setMensagem("Problemas ao cadastrar membro: " + e.getMessage());
            throw new EventosException(e, PessoaWS.class.getName());
        }
        
        if(msg.getMensagem().length()<=0){
            msg.setMensagem("NAO FOI POSSIVEL CADASTRAR OU ATUALIZAR DADOS!");
        }

        return msg;
    }

}
