package br.org.icmcuritiba.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Alojamento.class)
public abstract class Alojamento_ {

	public static volatile SingularAttribute<Alojamento, BigInteger> vagas;
	public static volatile SingularAttribute<Alojamento, BigDecimal> codalojamento;
	public static volatile ListAttribute<Alojamento, EventoAlojamento> eventoAlojamentoList;
	public static volatile SingularAttribute<Alojamento, String> descalojamento;

}

