package br.org.icmcuritiba.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Profissao.class)
public abstract class Profissao_ {

	public static volatile ListAttribute<Profissao, Membro> membroList;
	public static volatile SingularAttribute<Profissao, String> descprofissao;
	public static volatile SingularAttribute<Profissao, BigDecimal> codprofissao;

}

