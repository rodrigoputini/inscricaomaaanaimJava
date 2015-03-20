select "insert into tb_membro(codmembro,codpessoa, codcategoriamembro, codendereco, codigreja) values (nextval('public.seq_tb_membro'),(select codpessoa from tb_pessoa where cpf ='",
m.cpf,
"'),",
m.codcategoria ,
",",
"(select codendereco from tb_endereco where cep = '",
m.cep,
"'),",
m.codigreja,
")" 
from tb_membro m
where m.cpfproprio = 'S'
and m.cep is not null
and length(trim(m.cep))>5
and m.codigreja is not null