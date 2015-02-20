/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migrationmaanaim;

import java.util.List;
import migrationmaanaim.entity.Pessoa;
import migrationmaanaim.mysql.MySqlDataRetrieving;
import migrationmaanaim.postgres.PostgresDataInjection;

/**
 *
 * @author Rodrigo C Putini
 */
public class MigrationMaanaim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MySqlDataRetrieving.loadPessoas();
        MySqlDataRetrieving.doAdjustMarriedStatus(MySqlDataRetrieving.listPessoa);
        MySqlDataRetrieving.doAdjustBloodType(MySqlDataRetrieving.listPessoa);
        MySqlDataRetrieving.doAdjustDisabilities(MySqlDataRetrieving.listPessoa);
        //PostgresDataInjection.injectPostgresDataPessoa(MySqlDataRetrieving.listPessoa);
        PostgresDataInjection.loadAddressesByCepList(MySqlDataRetrieving.listEndereco);
        PostgresDataInjection.injectPostgresDataAddress();
        
        //MySqlDataRetrieving.loadAddresses();
    }
    
}
