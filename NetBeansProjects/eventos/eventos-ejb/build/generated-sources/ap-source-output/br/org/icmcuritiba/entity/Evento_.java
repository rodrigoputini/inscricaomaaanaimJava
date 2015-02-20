package br.org.icmcuritiba.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Evento.class)
public abstract class Evento_ {

	public static volatile SingularAttribute<Evento, Date> dtfinalinsc;
	public static volatile SingularAttribute<Evento, String> coordenadaslocal;
	public static volatile SingularAttribute<Evento, BigInteger> numvagasfeminino;
	public static volatile SingularAttribute<Evento, String> descevento;
	public static volatile SingularAttribute<Evento, BigInteger> codusuario;
	public static volatile SingularAttribute<Evento, Boolean> status;
	public static volatile SingularAttribute<Evento, BigDecimal> codevento;
	public static volatile SingularAttribute<Evento, Date> dtinicialinscvolunt;
	public static volatile SingularAttribute<Evento, Date> dtfinalinscvolunt;
	public static volatile SingularAttribute<Evento, Date> dtinicialinsc;
	public static volatile SingularAttribute<Evento, Boolean> videoconferencia;
	public static volatile ListAttribute<Evento, Inscricao> inscricaoList;
	public static volatile SingularAttribute<Evento, Date> dtfinal;
	public static volatile SingularAttribute<Evento, Date> dtfinalsubs;
	public static volatile ListAttribute<Evento, EventoAlojamento> eventoAlojamentoList;
	public static volatile SingularAttribute<Evento, String> localevento;
	public static volatile SingularAttribute<Evento, Date> dtinicial;
	public static volatile SingularAttribute<Evento, BigInteger> vagasmasculino;
	public static volatile SingularAttribute<Evento, BigDecimal> valorinscricao;

}

