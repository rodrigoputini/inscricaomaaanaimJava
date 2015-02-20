package br.org.icmcuritiba.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Igreja.class)
public abstract class Igreja_ {

	public static volatile SingularAttribute<Igreja, String> codpresbiterio;
	public static volatile SingularAttribute<Igreja, Integer> numerorua;
	public static volatile SingularAttribute<Igreja, String> complemento;
	public static volatile SingularAttribute<Igreja, String> nomeigreja;
	public static volatile SingularAttribute<Igreja, Endereco> codendereco;
	public static volatile ListAttribute<Igreja, Membro> membroList;
	public static volatile SingularAttribute<Igreja, Polo> codpolo;
	public static volatile SingularAttribute<Igreja, BigDecimal> codigreja;

}

