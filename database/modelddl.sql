/* Database generated with pgModeler (PostgreSQL Database Modeler).
  Project Site: pgmodeler.com.br
  Model Author: --- */


/* Database creation must be done outside an multicommand file.
   These commands were put in this file only for convenience.

-- object: icmcurbr | type: DATABASE -- 
CREATE DATABASE icmcurbr
	ENCODING = 'UTF8'
;

*/

-- object: public.tb_alojamento | type: TABLE -- 
CREATE TABLE public.tb_alojamento(
	codalojamento numeric NOT NULL,
	descalojamento varchar NOT NULL,
	vagas numeric NOT NULL,
	CONSTRAINT pk_alojamento PRIMARY KEY (codalojamento)
)
WITH (OIDS=FALSE);

COMMENT ON COLUMN public.tb_alojamento.codalojamento IS 'codigo do alojamento auto incrementado';
COMMENT ON COLUMN public.tb_alojamento.descalojamento IS 'nome do alojamento';
-- object: public.tb_categoriainscricao | type: TABLE -- 
CREATE TABLE public.tb_categoriainscricao(
	codcatinscricao numeric NOT NULL,
	desccatinscricao varchar NOT NULL,
	CONSTRAINT pk_categoriainscricao PRIMARY KEY (codcatinscricao)
)
WITH (OIDS=FALSE);

-- object: public.tb_evento | type: TABLE -- 
CREATE TABLE public.tb_evento(
	codevento numeric NOT NULL,
	descevento varchar(30) NOT NULL,
	videoconferencia boolean NOT NULL,
	localevento varchar NOT NULL,
	dtinicial date NOT NULL,
	dtfinal date NOT NULL,
	dtinicialinsc date NOT NULL,
	dtfinalinsc date NOT NULL,
	dtinicialinscvolunt date NOT NULL,
	dtfinalinscvolunt date NOT NULL,
	vagasmasculino numeric NOT NULL,
	numvagasfeminino numeric NOT NULL,
	valorinscricao numeric(3,2) NOT NULL,
	status boolean NOT NULL,
	dtfinalsubs date NOT NULL,
	codusuario numeric NOT NULL,
	coordenadaslocal varchar,
	CONSTRAINT pk_evento PRIMARY KEY (codevento)
)
WITH (OIDS=FALSE);

-- object: idx_evento_nome | type: INDEX -- 
CREATE INDEX  CONCURRENTLY idx_evento_nome ON public.tb_evento
	USING btree
	(descevento DESC NULLS LAST,dtinicial DESC NULLS LAST)
	WITH (FILLFACTOR = 10)
;

COMMENT ON TABLE public.tb_evento IS 'Registros de evento';
COMMENT ON COLUMN public.tb_evento.codevento IS 'chave da tabela evento';
COMMENT ON COLUMN public.tb_evento.descevento IS 'Nome do evento';
COMMENT ON COLUMN public.tb_evento.videoconferencia IS 'se o evento é local ou videoconferencia ';
COMMENT ON COLUMN public.tb_evento.localevento IS 'nome do local';
COMMENT ON COLUMN public.tb_evento.coordenadaslocal IS 'longitude e latitude obtidas no google maps';
-- object: public.tb_evento_alojamento | type: TABLE -- 
CREATE TABLE public.tb_evento_alojamento(
	codevento numeric NOT NULL,
	codalojamento numeric NOT NULL,
	sexo varchar(3) NOT NULL,
	CONSTRAINT pk_evento_alojamento PRIMARY KEY (codevento,codalojamento)
)
WITH (OIDS=FALSE);

-- object: public.tb_endereco | type: TABLE -- 
CREATE TABLE public.tb_endereco(
	codendereco numeric NOT NULL,
	logradouro varchar(150) NOT NULL,
	cep varchar(8) NOT NULL,
	bairro varchar(100) NOT NULL,
	cidade varchar(201) NOT NULL,
	estado varchar(2) NOT NULL,
	pais varbit(50) NOT NULL,
	CONSTRAINT pk_endereco PRIMARY KEY (codendereco),
	CONSTRAINT uk_cep UNIQUE (cep)
)
WITH (OIDS=TRUE);

-- object: idx_endereco | type: INDEX -- 
CREATE INDEX idx_endereco ON public.tb_endereco
	USING btree
	(cep DESC NULLS LAST)
	WITH (FILLFACTOR = 10)
;

-- object: public.tb_equipe | type: TABLE -- 
CREATE TABLE public.tb_equipe(
	codequipe numeric NOT NULL,
	descequipe varchar(50) NOT NULL,
	CONSTRAINT pk_equipe PRIMARY KEY (codequipe)
)
WITH (OIDS=FALSE);

-- object: public.tb_igreja | type: TABLE -- 
CREATE TABLE public.tb_igreja(
	codigreja numeric NOT NULL,
	codpresbiterio varchar(10) NOT NULL,
	nomeigreja varchar(50) NOT NULL,
	codpolo numeric NOT NULL,
	pastor numeric NOT NULL,
	codendereco numeric NOT NULL,
	complemento varchar(50),
	CONSTRAINT pk_igreja PRIMARY KEY (codigreja)
)
WITH (OIDS=FALSE);

-- object: public.tb_pessoa | type: TABLE -- 
CREATE TABLE public.tb_pessoa(
	codpessoa numeric NOT NULL,
	nome varchar(150) NOT NULL,
	sexo varchar(3) NOT NULL,
	estadocivil varchar(20) NOT NULL,
	datanascimento date NOT NULL,
	tiposangue varchar(3) NOT NULL,
	doadorsangue boolean NOT NULL,
	identidade varchar(20),
	rgorgaoexpedidor varchar(30),
	rgdataexpedicao date,
	email varchar(100),
	cpf varchar(11) NOT NULL,
	pne boolean NOT NULL,
	tipopne varchar(50),
	observacoes varchar(300),
	docinternacional varchar(100),
	celular varchar(15),
	telefone varchar(15),
	telcomercial varchar(15),
	complemento varchar(50),
	numerorua varchar(20),
	CONSTRAINT pk_pessoa PRIMARY KEY (codpessoa),
	CONSTRAINT uk_cpf UNIQUE (cpf)
)
WITH (OIDS=TRUE);

-- object: idx_pessoa | type: INDEX -- 
CREATE INDEX idx_pessoa ON public.tb_pessoa
	USING btree
	(cpf DESC NULLS LAST,nome DESC NULLS LAST)
	WITH (FILLFACTOR = 10)
;

COMMENT ON COLUMN public.tb_pessoa.codpessoa IS 'chave de registro';
COMMENT ON COLUMN public.tb_pessoa.nome IS 'nome da pessoa';
COMMENT ON COLUMN public.tb_pessoa.sexo IS 'mas de masculino ou fem de feminino';
COMMENT ON COLUMN public.tb_pessoa.estadocivil IS 'estado civil da pessoa';
COMMENT ON COLUMN public.tb_pessoa.datanascimento IS 'data de nascimento da pessoa';
COMMENT ON COLUMN public.tb_pessoa.tiposangue IS 'tipo sanguineo e fator Rhesus';
COMMENT ON COLUMN public.tb_pessoa.doadorsangue IS 'se doador sim senão nao';
COMMENT ON COLUMN public.tb_pessoa.identidade IS 'registro geral para brasileiros ou passaporte para outros paises';
COMMENT ON COLUMN public.tb_pessoa.rgorgaoexpedidor IS 'orgao expedidor do rg para brasileiros ou nome do pais';
COMMENT ON COLUMN public.tb_pessoa.rgdataexpedicao IS 'data da expedição do rg ou do passaporte';
COMMENT ON COLUMN public.tb_pessoa.email IS 'email pessoal de contato';
COMMENT ON COLUMN public.tb_pessoa.cpf IS 'cadastro de pessoa fisica, ';
COMMENT ON COLUMN public.tb_pessoa.pne IS 'portador de necessidades especiais';
COMMENT ON COLUMN public.tb_pessoa.tipopne IS 'tipo da necessidade especial';
COMMENT ON COLUMN public.tb_pessoa.docinternacional IS 'numero de passaporte ou outro documento ';
COMMENT ON COLUMN public.tb_pessoa.celular IS 'nr de telefone movel';
COMMENT ON COLUMN public.tb_pessoa.telefone IS 'nr telefone residencial fixo';
COMMENT ON COLUMN public.tb_pessoa.telcomercial IS 'telefone comercial';
-- object: public.tb_polo | type: TABLE -- 
CREATE TABLE public.tb_polo(
	codpolo numeric NOT NULL,
	descpolo smallint,
	responsavel numeric NOT NULL,
	codarea numeric NOT NULL,
	CONSTRAINT pk_polo PRIMARY KEY (codpolo)
)
WITH (OIDS=FALSE);

-- object: public.tb_area | type: TABLE -- 
CREATE TABLE public.tb_area(
	codarea numeric NOT NULL,
	descarea varchar NOT NULL,
	regiao varchar(50) NOT NULL,
	CONSTRAINT pk_area PRIMARY KEY (codarea)
)
WITH (OIDS=FALSE);

-- object: public.tb_profissao | type: TABLE -- 
CREATE TABLE public.tb_profissao(
	codprofissao numeric NOT NULL,
	descprofissao varchar(100),
	CONSTRAINT pk_profissao PRIMARY KEY (codprofissao)
)
WITH (OIDS=FALSE);

-- object: public.tb_categoriamembro | type: TABLE -- 
CREATE TABLE public.tb_categoriamembro(
	codcategoriamembro numeric NOT NULL,
	desccategoriamembro varchar(50),
	CONSTRAINT pk_categoriamembro PRIMARY KEY (codcategoriamembro)
)
WITH (OIDS=FALSE);

-- object: public.tb_membro | type: TABLE -- 
CREATE TABLE public.tb_membro(
	codmembro numeric NOT NULL,
	codpessoa numeric NOT NULL,
	codprofissao numeric,
	codcategoriamembro numeric NOT NULL,
	codendereco numeric NOT NULL,
	codigreja numeric NOT NULL,
	CONSTRAINT pk_membro PRIMARY KEY (codmembro),
	CONSTRAINT uk_pessoa UNIQUE (codpessoa)
)
WITH (OIDS=FALSE);

-- object: public.tb_funcao | type: TABLE -- 
CREATE TABLE public.tb_funcao(
	codfuncao numeric NOT NULL,
	descfuncao varchar(50) NOT NULL,
	CONSTRAINT pk_funcao PRIMARY KEY (codfuncao)
)
WITH (OIDS=FALSE);

-- object: public.tb_membrofuncao | type: TABLE -- 
CREATE TABLE public.tb_membrofuncao(
	codmembro numeric NOT NULL,
	codfuncao numeric NOT NULL,
	CONSTRAINT pk_membrofuncao PRIMARY KEY (codmembro,codfuncao)
)
WITH (OIDS=FALSE);

-- object: public.tb_inscricao | type: TABLE -- 
CREATE TABLE public.tb_inscricao(
	codmembro numeric NOT NULL,
	codevento numeric NOT NULL,
	pagamento boolean NOT NULL,
	status varchar(31) NOT NULL,
	codcatinscricao numeric NOT NULL,
	codequipe numeric,
	inscritor numeric NOT NULL,
	datainscricao date NOT NULL,
	CONSTRAINT pk_inscricao PRIMARY KEY (codmembro,codevento)
)
WITH (OIDS=FALSE);

-- object: idx_inscricao | type: INDEX -- 
CREATE INDEX idx_inscricao ON public.tb_inscricao
	USING btree
	(inscritor DESC NULLS LAST,datainscricao DESC NULLS LAST)
	WITH (FILLFACTOR = 10)
;

-- object: fk_equipe | type: CONSTRAINT -- 
ALTER TABLE public.tb_inscricao ADD CONSTRAINT fk_equipe FOREIGN KEY (codequipe)
REFERENCES public.tb_equipe (codequipe) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_catinscricao | type: CONSTRAINT -- 
ALTER TABLE public.tb_inscricao ADD CONSTRAINT fk_catinscricao FOREIGN KEY (codcatinscricao)
REFERENCES public.tb_categoriainscricao (codcatinscricao) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_evento | type: CONSTRAINT -- 
ALTER TABLE public.tb_inscricao ADD CONSTRAINT fk_evento FOREIGN KEY (codevento)
REFERENCES public.tb_evento (codevento) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_membro | type: CONSTRAINT -- 
ALTER TABLE public.tb_inscricao ADD CONSTRAINT fk_membro FOREIGN KEY (codmembro)
REFERENCES public.tb_membro (codmembro) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_funcao | type: CONSTRAINT -- 
ALTER TABLE public.tb_membrofuncao ADD CONSTRAINT fk_funcao FOREIGN KEY (codfuncao)
REFERENCES public.tb_funcao (codfuncao) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_membro | type: CONSTRAINT -- 
ALTER TABLE public.tb_membrofuncao ADD CONSTRAINT fk_membro FOREIGN KEY (codmembro)
REFERENCES public.tb_membro (codmembro) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_igreja | type: CONSTRAINT -- 
ALTER TABLE public.tb_membro ADD CONSTRAINT fk_igreja FOREIGN KEY (codigreja)
REFERENCES public.tb_igreja (codigreja) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_categoriamembro | type: CONSTRAINT -- 
ALTER TABLE public.tb_membro ADD CONSTRAINT fk_categoriamembro FOREIGN KEY (codcategoriamembro)
REFERENCES public.tb_categoriamembro (codcategoriamembro) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_endereco | type: CONSTRAINT -- 
ALTER TABLE public.tb_membro ADD CONSTRAINT fk_endereco FOREIGN KEY (codendereco)
REFERENCES public.tb_endereco (codendereco) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_profissao | type: CONSTRAINT -- 
ALTER TABLE public.tb_membro ADD CONSTRAINT fk_profissao FOREIGN KEY (codprofissao)
REFERENCES public.tb_profissao (codprofissao) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_pessoa | type: CONSTRAINT -- 
ALTER TABLE public.tb_membro ADD CONSTRAINT fk_pessoa FOREIGN KEY (codpessoa)
REFERENCES public.tb_pessoa (codpessoa) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_area | type: CONSTRAINT -- 
ALTER TABLE public.tb_polo ADD CONSTRAINT fk_area FOREIGN KEY (codarea)
REFERENCES public.tb_area (codarea) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_endereco | type: CONSTRAINT -- 
ALTER TABLE public.tb_igreja ADD CONSTRAINT fk_endereco FOREIGN KEY (codendereco)
REFERENCES public.tb_endereco (codendereco) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_polo | type: CONSTRAINT -- 
ALTER TABLE public.tb_igreja ADD CONSTRAINT fk_polo FOREIGN KEY (codpolo)
REFERENCES public.tb_polo (codpolo) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_alojamento | type: CONSTRAINT -- 
ALTER TABLE public.tb_evento_alojamento ADD CONSTRAINT fk_alojamento FOREIGN KEY (codalojamento)
REFERENCES public.tb_alojamento (codalojamento) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_evento | type: CONSTRAINT -- 
ALTER TABLE public.tb_evento_alojamento ADD CONSTRAINT fk_evento FOREIGN KEY (codevento)
REFERENCES public.tb_evento (codevento) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;


-- object: public.seq_tb_pessoa | type: SEQUENCE -- 
CREATE SEQUENCE public.seq_tb_pessoa
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- object: public.seq_tb_profissao | type: SEQUENCE -- 
CREATE SEQUENCE public.seq_tb_profissao
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- object: public.seq_tb_categoriamembro | type: SEQUENCE -- 
CREATE SEQUENCE public.seq_tb_categoriamembro
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- object: public.seq_tb_funcao | type: SEQUENCE -- 
CREATE SEQUENCE public.seq_tb_funcao
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- object: public.seq_tb_membro | type: SEQUENCE -- 
CREATE SEQUENCE public.seq_tb_membro
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- object: public.seq_tb_endereco | type: SEQUENCE -- 
CREATE SEQUENCE public.seq_tb_endereco
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- object: public.seq_tb_evento | type: SEQUENCE -- 
CREATE SEQUENCE public.seq_tb_evento
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- object: public.seq_tb_alojamento | type: SEQUENCE -- 
CREATE SEQUENCE public.seq_tb_alojamento
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- object: public.seq_tb_equipe | type: SEQUENCE -- 
CREATE SEQUENCE public.seq_tb_equipe
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- object: public.seq_tb_categoriainscricao | type: SEQUENCE -- 
CREATE SEQUENCE public.seq_tb_categoriainscricao
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- object: public.seq_tb_igreja | type: SEQUENCE -- 
CREATE SEQUENCE public.seq_tb_igreja
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- object: public.seq_tb_polo | type: SEQUENCE -- 
CREATE SEQUENCE public.seq_tb_polo
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- object: public.seq_tb_area | type: SEQUENCE -- 
CREATE SEQUENCE public.seq_tb_area
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;


