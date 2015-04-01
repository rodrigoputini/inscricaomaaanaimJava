/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 */
@Entity
@Table(name = "tb_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByCodpessoa", query = "SELECT p FROM Pessoa p WHERE p.codpessoa = :codpessoa"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoa.findBySexo", query = "SELECT p FROM Pessoa p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Pessoa.findByEstadocivil", query = "SELECT p FROM Pessoa p WHERE p.estadocivil = :estadocivil"),
    @NamedQuery(name = "Pessoa.findByDatanascimento", query = "SELECT p FROM Pessoa p WHERE p.datanascimento = :datanascimento"),
    @NamedQuery(name = "Pessoa.findByTiposangue", query = "SELECT p FROM Pessoa p WHERE p.tiposangue = :tiposangue"),
    @NamedQuery(name = "Pessoa.findByDoadorsangue", query = "SELECT p FROM Pessoa p WHERE p.doadorsangue = :doadorsangue"),
    @NamedQuery(name = "Pessoa.findByIdentidade", query = "SELECT p FROM Pessoa p WHERE p.identidade = :identidade"),
    @NamedQuery(name = "Pessoa.findByRgorgaoexpedidor", query = "SELECT p FROM Pessoa p WHERE p.rgorgaoexpedidor = :rgorgaoexpedidor"),
    @NamedQuery(name = "Pessoa.findByRgdataexpedicao", query = "SELECT p FROM Pessoa p WHERE p.rgdataexpedicao = :rgdataexpedicao"),
    @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email"),
    @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Pessoa.findByPne", query = "SELECT p FROM Pessoa p WHERE p.pne = :pne"),
    @NamedQuery(name = "Pessoa.findByTipopne", query = "SELECT p FROM Pessoa p WHERE p.tipopne = :tipopne"),
    @NamedQuery(name = "Pessoa.findByObservacoes", query = "SELECT p FROM Pessoa p WHERE p.observacoes = :observacoes"),
    @NamedQuery(name = "Pessoa.findByDocinternacional", query = "SELECT p FROM Pessoa p WHERE p.docinternacional = :docinternacional"),
    @NamedQuery(name = "Pessoa.findByCelular", query = "SELECT p FROM Pessoa p WHERE p.celular = :celular"),
    @NamedQuery(name = "Pessoa.findByTelefone", query = "SELECT p FROM Pessoa p WHERE p.telefone = :telefone"),
    @NamedQuery(name = "Pessoa.findByTelcomercial", query = "SELECT p FROM Pessoa p WHERE p.telcomercial = :telcomercial"),
    @NamedQuery(name = "Pessoa.findByComplemento", query = "SELECT p FROM Pessoa p WHERE p.complemento = :complemento"),
    @NamedQuery(name = "Pessoa.findByNumerorua", query = "SELECT p FROM Pessoa p WHERE p.numerorua = :numerorua"),
    @NamedQuery(name = "Pessoa.findByCodIgreja", query = "SELECT p FROM Pessoa p WHERE p.membro.codigreja.codpresbiterio = :codPresbiterio ORDER BY p.nome")
})
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codpessoa")
    private BigDecimal codpessoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estadocivil")
    private String estadocivil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datanascimento")
    @Temporal(TemporalType.DATE)
    private Date datanascimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tiposangue")
    private String tiposangue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doadorsangue")
    private boolean doadorsangue;
    @Size(max = 20)
    @Column(name = "identidade")
    private String identidade;
    @Size(max = 30)
    @Column(name = "rgorgaoexpedidor")
    private String rgorgaoexpedidor;
    @Column(name = "rgdataexpedicao")
    @Temporal(TemporalType.DATE)
    private Date rgdataexpedicao;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pne")
    private boolean pne;
    @Size(max = 50)
    @Column(name = "tipopne")
    private String tipopne;
    @Size(max = 300)
    @Column(name = "observacoes")
    private String observacoes;
    @Size(max = 100)
    @Column(name = "docinternacional")
    private String docinternacional;
    @Size(max = 15)
    @Column(name = "celular")
    private String celular;
    @Size(max = 15)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 15)
    @Column(name = "telcomercial")
    private String telcomercial;
    @Size(max = 50)
    @Column(name = "complemento")
    private String complemento;
    @Size(max = 20)
    @Column(name = "numerorua")
    private String numerorua;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "codpessoa", fetch = FetchType.LAZY)
    private Membro membro;

    public Pessoa() {
    }

    public Pessoa(BigDecimal codpessoa) {
        this.codpessoa = codpessoa;
    }

    public Pessoa(BigDecimal codpessoa, String nome, String sexo, String estadocivil, Date datanascimento, String tiposangue, boolean doadorsangue, String cpf, boolean pne) {
        this.codpessoa = codpessoa;
        this.nome = nome;
        this.sexo = sexo;
        this.estadocivil = estadocivil;
        this.datanascimento = datanascimento;
        this.tiposangue = tiposangue;
        this.doadorsangue = doadorsangue;
        this.cpf = cpf;
        this.pne = pne;
    }

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

    public boolean getDoadorsangue() {
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

    public boolean getPne() {
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

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpessoa != null ? codpessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.codpessoa == null && other.codpessoa != null) || (this.codpessoa != null && !this.codpessoa.equals(other.codpessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.icmcuritiba.entity.Pessoa[ codpessoa=" + codpessoa + " ]";
    }
    
}
