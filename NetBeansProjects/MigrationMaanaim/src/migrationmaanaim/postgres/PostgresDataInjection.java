/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migrationmaanaim.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import migrationmaanaim.entity.Endereco;
import migrationmaanaim.entity.Pessoa;

/**
 *
 * @author Rodrigo C Putini
 */
public class PostgresDataInjection {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/icmcurbr";
    static final String DB_URL_CEP = "jdbc:postgresql://localhost:5432/cep";
    static final String USER = "postgres";
    static final String PASS = "1ndr21@@";
    private static Connection c = null;
    private static Connection ccep = null;
    public static List<Endereco> lstEnd = null;

    private static Connection loadConnection() {
        if (null == c) {
            try {
                //STEP 2: Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                //STEP 3: Open a connection
                System.out.println("Connecting to database...");
                c = DriverManager.getConnection(DB_URL, USER, PASS);
                

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return c;
    }
    
    private static Connection loadCepConnection() {
        if (null == ccep) {
            try {
                //STEP 2: Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                //STEP 3: Open a connection
                System.out.println("Connecting to database...");
                ccep = DriverManager.getConnection(DB_URL_CEP, USER, PASS);
                

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ccep;
    }
    

    public static void injectPostgresDataPessoa(List<Pessoa> listPessoa) {
        Statement stmt = null;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            stmt = loadConnection().createStatement();
            for(Pessoa p : listPessoa){
                StringBuffer sql = new StringBuffer();
                sql.append("INSERT INTO public.tb_pessoa (codpessoa,nome,sexo,estadocivil,")
                .append("datanascimento,tiposangue,doadorsangue,identidade,rgorgaoexpedidor,")
                .append("rgdataexpedicao,email,cpf,pne,tipopne,observacoes,docinternacional,")
                .append("celular,telefone,telcomercial,complemento,numerorua) ")
                .append("VALUES (nextval('public.seq_tb_pessoa'),")
                .append("'").append(p.getNome()).append("',")
                .append("'").append(p.getSexo()).append("',")
                .append("'").append(p.getEstadocivil()).append("',")
                .append("{d '").append(formatter.format(p.getDatanascimento())).append("'},")
                .append("'").append(p.getTiposangue()).append("',")
                .append(p.getDoadorsangue()).append(",")
                .append("'").append(p.getIdentidade()).append("',")
                .append("'").append(p.getRgorgaoexpedidor()).append("',")
                .append("{d '").append(formatter.format(p.getRgdataexpedicao())).append("'},")
                .append("'").append(p.getEmail()).append("',")
                .append("'").append(p.getCpf()).append("',")
                .append(p.getPne()).append(",")
                .append("'").append(p.getTipopne()).append("',")
                .append("'").append(p.getObservacoes()).append("',")
                .append("'").append(p.getDocinternacional()).append("',")
                .append("'").append(p.getCelular()).append("',")
                .append("'").append(p.getTelefone()).append("',")
                .append("'").append(p.getTelcomercial()).append("',")
                .append("'").append(p.getComplemento()).append("',")
                .append("'").append(p.getNumeroRua()).append("')");
                stmt.executeUpdate(sql.toString());
            }
            stmt.close();
            //c.commit();
            c.close();
            c = null;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
    
    public static void loadAddressesByCepList(List<Endereco> ceps){
        lstEnd = new ArrayList<Endereco>();
        StringBuffer sql = new StringBuffer();
        Statement stmt = null;
        ResultSet rs = null;
        sql.append("select logr.log_tipo_logradouro as tipo, ")  
        .append("logr.log_no_sem_acento as logradrouro, ")
        .append("bairro.bai_no bairro, ")
        .append("loc.loc_no as localidade, ")
        .append("loc.ufe_sg as estado ")
        .append("from cep.log_logradouro logr, ")
        .append("cep.log_bairro bairro, ")
        .append("cep.log_localidade loc ")
        .append("where bairro.bai_nu_sequencial  =  logr.bai_nu_sequencial_ini  ")
        .append("and bairro.loc_nu_sequencial = loc.loc_nu_sequencial ")
        .append("and logr.cep = '");
        
        try{
            stmt = loadCepConnection().createStatement();
            for(Endereco e: ceps){
                if(null!=e.getCep() && e.getCep().trim().length()>7){
                    String cep = e.getCep();
                    if(cep.indexOf("-")!=-1){
                        cep = e.getCep().substring(0,5)+e.getCep().substring(6);
                    }
                    rs = stmt.executeQuery(sql.toString()+cep+"'");
                    if(rs.next()){
                        Endereco end = new Endereco();
                        end.setLogradouro(rs.getString("tipo").trim()+" "+rs.getString("logradrouro").trim());
                        end.setBairro(rs.getString("bairro").trim());
                        end.setCidade(rs.getString("localidade").trim());
                        end.setEstado(rs.getString("estado").trim());
                        end.setCep(cep);
                        lstEnd.add(end);
                    }
                }
            }
            stmt.close();
            //c.commit();
            ccep.close();
            ccep = null;
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void injectPostgresDataAddress() {
        Statement stmt = null;
        try {
            stmt = loadConnection().createStatement();
            for(Endereco e : lstEnd){
                try{
                 StringBuffer sql = new StringBuffer();
                 sql.append("INSERT INTO tb_endereco (codendereco,logradouro,cep,bairro,cidade,estado,pais) ")
                .append("VALUES(nextval('public.seq_tb_endereco'),")
                .append("'").append(e.getLogradouro()).append("',")
                .append("'").append(e.getCep()).append("',")
                .append("'").append(e.getBairro()).append("',")
                .append("'").append(e.getCidade()).append("',")
                .append("'").append(e.getEstado()).append("','Brasil')");
                stmt.executeUpdate(sql.toString());
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            stmt.close();
            //c.commit();
            c.close();
            c = null;
        } catch (Exception e) {
        }
        System.out.println("Records created successfully");
    }

}
