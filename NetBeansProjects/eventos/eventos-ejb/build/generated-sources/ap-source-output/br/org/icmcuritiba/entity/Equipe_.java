package br.org.icmcuritiba.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Equipe.class)
public abstract class Equipe_ {

	public static volatile ListAttribute<Equipe, Inscricao> inscricaoList;
	public static volatile SingularAttribute<Equipe, BigDecimal> codequipe;
	public static volatile SingularAttribute<Equipe, String> descequipe;

}

