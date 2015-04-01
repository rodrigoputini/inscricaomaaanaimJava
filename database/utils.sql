SELECT codpessoa, nome FROM tb_pessoa where tb_pessoa.nome like '%PUTINI%'
UPDATE TB_PESSOA SET NOME='ANDREA PUTINI' WHERE CODPESSOA = 320

SELECT * FROM TB_MEMBRO WHERE codprofissao is not null
SELECT * FROM TB_PROFISSAO WHERE DESCPROFISSAO LIKE '%SIST%'

SELECT * FROM TB_IGREJA WHERE CODPRESBITERIO = '140049'
SELECT * FROM TB_CATEGORIAMEMBRO
--PROF 10
--IG 9
--CAT 5
--END 92

insert into tb_membro(codmembro,codpessoa, codprofissao, codcategoriamembro, codendereco, codigreja) values (nextval('public.seq_tb_membro'),320,10,5,92,9)
update tb_membro set codprofissao = 2 where codpessoa = 283

select * from tb_pessoa p where p.codpessoa not in (select codpessoa from tb_membro) 

