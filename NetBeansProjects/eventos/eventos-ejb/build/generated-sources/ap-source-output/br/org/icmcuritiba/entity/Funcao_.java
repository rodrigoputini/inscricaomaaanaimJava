package br.org.icmcuritiba.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Funcao.class)
public abstract class Funcao_ {

	public static volatile SingularAttribute<Funcao, String> descfuncao;
	public static volatile ListAttribute<Funcao, Membro> membroList;
	public static volatile SingularAttribute<Funcao, BigDecimal> codfuncao;

}

