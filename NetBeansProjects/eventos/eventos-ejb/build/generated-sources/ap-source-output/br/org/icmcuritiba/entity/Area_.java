package br.org.icmcuritiba.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Area.class)
public abstract class Area_ {

	public static volatile SingularAttribute<Area, String> descarea;
	public static volatile ListAttribute<Area, Polo> poloList;
	public static volatile SingularAttribute<Area, String> regiao;
	public static volatile SingularAttribute<Area, BigDecimal> codarea;

}

