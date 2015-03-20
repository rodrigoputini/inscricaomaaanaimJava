select logr.log_tipo_logradouro as tipo, 
logr.log_no_sem_acento as logradrouro,
bairro.bai_no bairro,
loc.loc_no as localidade,
loc.ufe_sg as estado
from cep.log_logradouro logr,
cep.log_bairro bairro,
cep.log_localidade loc
where bairro.bai_nu_sequencial  =  logr.bai_nu_sequencial_ini 
and bairro.loc_nu_sequencial = loc.loc_nu_sequencial
and logr.cep = '82630160'
