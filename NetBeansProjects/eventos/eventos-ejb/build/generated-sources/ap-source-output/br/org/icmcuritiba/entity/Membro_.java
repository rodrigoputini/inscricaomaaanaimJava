package br.org.icmcuritiba.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Membro.class)
public abstract class Membro_ {

	public static volatile SingularAttribute<Membro, Pessoa> codpessoa;
	public static volatile ListAttribute<Membro, Funcao> funcaoList;
	public static volatile ListAttribute<Membro, Inscricao> inscricaoList;
	public static volatile SingularAttribute<Membro, BigDecimal> codmembro;
	public static volatile SingularAttribute<Membro, Categoriamembro> codcategoriamembro;
	public static volatile SingularAttribute<Membro, Endereco> codendereco;
	public static volatile SingularAttribute<Membro, Profissao> codprofissao;
	public static volatile SingularAttribute<Membro, Igreja> codigreja;

}

