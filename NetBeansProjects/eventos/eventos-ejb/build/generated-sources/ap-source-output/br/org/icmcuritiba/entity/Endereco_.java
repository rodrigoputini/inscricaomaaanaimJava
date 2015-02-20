package br.org.icmcuritiba.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Endereco.class)
public abstract class Endereco_ {

	public static volatile SingularAttribute<Endereco, String> cidade;
	public static volatile SingularAttribute<Endereco, String> bairro;
	public static volatile SingularAttribute<Endereco, String> estado;
	public static volatile SingularAttribute<Endereco, String> cep;
	public static volatile ListAttribute<Endereco, Membro> membroList;
	public static volatile SingularAttribute<Endereco, String> pais;
	public static volatile SingularAttribute<Endereco, BigDecimal> codendereco;
	public static volatile SingularAttribute<Endereco, String> logradouro;
	public static volatile ListAttribute<Endereco, Igreja> igrejaList;

}

