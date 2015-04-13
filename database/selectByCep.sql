select 0 as codendereco, 
logr.log_tipo_logradouro ||' '|| 
logr.log_no_sem_acento as logradouro,
bairro.bai_no bairro,
loc.loc_no as cidade,
loc.ufe_sg as estado,
''as pais,
logr.cep as cep
from cep.log_logradouro logr,
cep.log_bairro bairro,
cep.log_localidade loc
where bairro.bai_nu_sequencial  =  logr.bai_nu_sequencial_ini 
and bairro.loc_nu_sequencial = loc.loc_nu_sequencial
and logr.cep = '81630060'



