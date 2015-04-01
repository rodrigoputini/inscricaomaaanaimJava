/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.interfaces;

import java.util.List;
import javax.ejb.Remote;
import br.org.icmcuritiba.entity.Pessoa;
import br.org.icmcuritiba.to.MembroTO;
import java.math.BigDecimal;

@Remote
public interface PessoaRemote {
     public List<Pessoa> getAllPessoas();
     public List<Pessoa> getAllByCodIgreja(String codIgreja);
     public List<Pessoa> getByNameAutocompleteNotMember(String nome);
     public Pessoa getByCpf(String cpf);
     public MembroTO loadFullMembro(BigDecimal codPessoa);
     public Pessoa getByCpfNotMember(String cpf);
}
