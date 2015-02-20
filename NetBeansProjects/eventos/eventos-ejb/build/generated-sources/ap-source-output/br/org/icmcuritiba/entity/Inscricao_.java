package br.org.icmcuritiba.entity;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Inscricao.class)
public abstract class Inscricao_ {

	public static volatile SingularAttribute<Inscricao, InscricaoPK> inscricaoPK;
	public static volatile SingularAttribute<Inscricao, Equipe> codequipe;
	public static volatile SingularAttribute<Inscricao, String> status;
	public static volatile SingularAttribute<Inscricao, Membro> membro;
	public static volatile SingularAttribute<Inscricao, Date> datainscricao;
	public static volatile SingularAttribute<Inscricao, Boolean> pagamento;
	public static volatile SingularAttribute<Inscricao, Categoriainscricao> codcatinscricao;
	public static volatile SingularAttribute<Inscricao, Evento> evento;
	public static volatile SingularAttribute<Inscricao, BigInteger> inscritor;

}

