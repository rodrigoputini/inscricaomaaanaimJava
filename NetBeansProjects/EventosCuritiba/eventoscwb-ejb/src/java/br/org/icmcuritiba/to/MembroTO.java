/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Rodrigo Camargo Putini - rodrigo.putini@gmail.com
 * @since 20 mar 2015
 */
public class MembroTO implements Serializable {

    private BigDecimal codpessoa;
    private String nome;
    private String sexo;
    private String estadocivil;
    private Date datanascimento;
    private String tiposangue;
    private boolean doadorsangue;
    private String identidade;
    private String rgorgaoexpedidor;
    private Date rgdataexpedicao;
    private String email;
    private String cpf;
    private boolean pne;
    private String tipopne;
    private String observacoes;
    private String docinternacional;
    private String celular;
    private String telefone;
    private String telcomercial;
    private String complemento;
    private String numerorua;
    private BigDecimal codmembro;
    private String codigreja; //no front-end representa o codpresbiterio
    private BigDecimal codprofissao;
    private String descprofissao;
    private BigDecimal codcategoriamembro;
    private String desccategoriamembro;
    private BigDecimal codendereco;
    private String logradouro;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String mensagem;
    
    //campo que representa para o front-end se a pessoa é membro ou nao-membro //entende-se membro os cod pessoa 
    //que constam na tabela de membros e nao somente na tabela pessoas
    private String status;    

    public BigDecimal getCodpessoa() {
        return codpessoa;
    }

    public void setCodpessoa(BigDecimal codpessoa) {
        this.codpessoa = codpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getTiposangue() {
        return tiposangue;
    }

    public void setTiposangue(String tiposangue) {
        this.tiposangue = tiposangue;
    }

    public boolean isDoadorsangue() {
        return doadorsangue;
    }

    public void setDoadorsangue(boolean doadorsangue) {
        this.doadorsangue = doadorsangue;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getRgorgaoexpedidor() {
        return rgorgaoexpedidor;
    }

    public void setRgorgaoexpedidor(String rgorgaoexpedidor) {
        this.rgorgaoexpedidor = rgorgaoexpedidor;
    }

    public Date getRgdataexpedicao() {
        return rgdataexpedicao;
    }

    public void setRgdataexpedicao(Date rgdataexpedicao) {
        this.rgdataexpedicao = rgdataexpedicao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isPne() {
        return pne;
    }

    public void setPne(boolean pne) {
        this.pne = pne;
    }

    public String getTipopne() {
        return tipopne;
    }

    public void setTipopne(String tipopne) {
        this.tipopne = tipopne;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDocinternacional() {
        return docinternacional;
    }

    public void setDocinternacional(String docinternacional) {
        this.docinternacional = docinternacional;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelcomercial() {
        return telcomercial;
    }

    public void setTelcomercial(String telcomercial) {
        this.telcomercial = telcomercial;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumerorua() {
        return numerorua;
    }

    public void setNumerorua(String numerorua) {
        this.numerorua = numerorua;
    }

    public BigDecimal getCodmembro() {
        return codmembro;
    }

    public void setCodmembro(BigDecimal codmembro) {
        this.codmembro = codmembro;
    }

    public String getCodigreja() {
        return codigreja;
    }

    public void setCodigreja(String codigreja) {
        this.codigreja = codigreja;
    }

    public BigDecimal getCodprofissao() {
        return codprofissao;
    }

    public void setCodprofissao(BigDecimal codprofissao) {
        this.codprofissao = codprofissao;
    }

    public String getDescprofissao() {
        return descprofissao;
    }

    public void setDescprofissao(String descprofissao) {
        this.descprofissao = descprofissao;
    }

    public BigDecimal getCodcategoriamembro() {
        return codcategoriamembro;
    }

    public void setCodcategoriamembro(BigDecimal codcategoriamembro) {
        this.codcategoriamembro = codcategoriamembro;
    }

    public String getDesccategoriamembro() {
        return desccategoriamembro;
    }

    public void setDesccategoriamembro(String desccategoriamembro) {
        this.desccategoriamembro = desccategoriamembro;
    }

    public BigDecimal getCodendereco() {
        return codendereco;
    }

    public void setCodendereco(BigDecimal codendereco) {
        this.codendereco = codendereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
}
