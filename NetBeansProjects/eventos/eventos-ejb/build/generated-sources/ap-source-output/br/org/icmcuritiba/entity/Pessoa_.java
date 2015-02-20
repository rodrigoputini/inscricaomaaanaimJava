package br.org.icmcuritiba.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pessoa.class)
public abstract class Pessoa_ {

	public static volatile SingularAttribute<Pessoa, String> complemento;
	public static volatile SingularAttribute<Pessoa, String> rgorgaoexpedidor;
	public static volatile SingularAttribute<Pessoa, Date> datanascimento;
	public static volatile SingularAttribute<Pessoa, String> sexo;
	public static volatile SingularAttribute<Pessoa, String> observacoes;
	public static volatile SingularAttribute<Pessoa, Date> rgdataexpedicao;
	public static volatile SingularAttribute<Pessoa, String> tipopne;
	public static volatile SingularAttribute<Pessoa, String> telcomercial;
	public static volatile SingularAttribute<Pessoa, BigDecimal> codpessoa;
	public static volatile SingularAttribute<Pessoa, String> tiposangue;
	public static volatile SingularAttribute<Pessoa, String> estadocivil;
	public static volatile SingularAttribute<Pessoa, String> numerorua;
	public static volatile SingularAttribute<Pessoa, String> email;
	public static volatile SingularAttribute<Pessoa, Membro> membro;
	public static volatile SingularAttribute<Pessoa, String> telefone;
	public static volatile SingularAttribute<Pessoa, String> docinternacional;
	public static volatile SingularAttribute<Pessoa, String> nome;
	public static volatile SingularAttribute<Pessoa, String> cpf;
	public static volatile SingularAttribute<Pessoa, Boolean> pne;
	public static volatile SingularAttribute<Pessoa, String> identidade;
	public static volatile SingularAttribute<Pessoa, String> celular;
	public static volatile SingularAttribute<Pessoa, Boolean> doadorsangue;

}

