/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migrationmaanaim.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import migrationmaanaim.entity.Endereco;
import migrationmaanaim.entity.Pessoa;

/**
 *
 * @author Rodrigo C Putini
 */
public class MySqlDataRetrieving {

    // JDBC driver name and database URL

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/icmcurbr";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    private static Connection conn = null;
    public static List<Pessoa> listPessoa = new ArrayList<Pessoa>();
    public static List<Endereco> listEndereco = new ArrayList<Endereco>();

    public static void loadPessoas() {

        Statement stmt = null;
        try {
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = loadConnection().createStatement();

            StringBuffer sql = new StringBuffer();

            sql.append("SELECT ")
                    .append("tb_membro.descmembro as descmembro, ")
                    .append("tb_membro.cpf as cpf, ")
                    .append("tb_membro.sexo as sexo, ")
                    .append("tb_membro.codestadocivil as codestadocivil, ")
                    .append("tb_membro.datanascimento as datanascimento, ")
                    .append("tb_membro.codtiposangue as codtiposangue, ")
                    .append("tb_membro.doador as doador, ")
                    .append("tb_membro.identidade as identidade, ")
                    .append("tb_membro.orgao_expeditor as orgao_expeditor, ")
                    .append("tb_membro.dataemissao_ident as dataemissao_ident, ")
                    .append("tb_membro.email as email, ")
                    .append("tb_membro.codnecessidade as codnecessidade, ")
                    .append("tb_membro.telresidencial as telresidencial, ")
                    .append("tb_membro.telcomercial as telcomercial, ")
                    .append("tb_membro.telcelular as telcelular,  ")
                    .append("tb_membro.docinternacional as docinternacional, ")
                    .append("tb_membro.complemento as complemento, ")
                    .append("tb_membro.numero as numero, ")
                    .append("tb_membro.observacao as observacao, ")
                    .append("tb_membro.cep as cep ")
                    .append("FROM tb_membro ")
                    .append("where tb_membro.cpfproprio = 'S'");

            ResultSet rs = stmt.executeQuery(sql.toString());
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            //STEP 5: Extract data from result set
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                Endereco endereco = new Endereco();
                pessoa.setNome(rs.getString("descmembro").trim());
                pessoa.setCpf(rs.getString("cpf").trim());
                pessoa.setSexo(rs.getString("sexo").trim());
                pessoa.setEstadocivil(rs.getString("codestadocivil").trim());

                String dtN = rs.getString("datanascimento").trim();
                if (null != dtN && dtN.length() > 0) {
                    Date dataNasc = (Date) formatter.parse(dtN);
                    if (null != dataNasc) {
                        pessoa.setDatanascimento(dataNasc);
                    }
                }

                pessoa.setTiposangue(rs.getString("codtiposangue").trim());
                pessoa.setDoadorsangue(rs.getBoolean("doador"));
                pessoa.setIdentidade(rs.getString("identidade").trim());
                pessoa.setRgorgaoexpedidor(rs.getString("orgao_expeditor").trim());

                String dtRg = rs.getString("dataemissao_ident").trim();
                if (null != dtRg && dtRg.length() > 0) {
                    Date dataRg = (Date) formatter.parse(dtRg);
                    if (null != dataRg) {
                        pessoa.setRgdataexpedicao(dataRg);
                    }
                }

                pessoa.setEmail(rs.getString("email").trim());
                pessoa.setTipopne(rs.getString("codnecessidade").trim());
                if (null != pessoa.getTipopne() && pessoa.getTipopne().length() > 0) {
                    pessoa.setPne(Boolean.TRUE);
                } else {
                    pessoa.setPne(Boolean.FALSE);
                }
                pessoa.setTelefone(rs.getString("telresidencial").trim());
                pessoa.setTelcomercial(rs.getString("telcomercial").trim());
                pessoa.setCelular(rs.getString("telcelular").trim());
                pessoa.setDocinternacional(rs.getString("docinternacional"));
                pessoa.setComplemento(rs.getString("complemento").trim());
                pessoa.setNumeroRua(rs.getString("numero").trim());
                pessoa.setObservacoes(rs.getString("observacao").trim());
                listPessoa.add(pessoa);
                
                endereco.setCep(rs.getString("cep").trim());
                endereco.setPais("Brasil");
                listEndereco.add(endereco);
            }

             //show results
             for(Endereco p: listEndereco){
             System.out.println(p.getLogradouro()+"-"+p.getBairro()+"-"+p.getCidade()+"-"+p.getEstado()+"-"+p.getCep());
             }
            System.out.println("Quantidade de registros recuperados:" + listPessoa.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (loadConnection() != null) {
                try {
                    loadConnection().close();
                    conn = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static Connection loadConnection() {
        if (null == conn) {
            try {
                //STEP 2: Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                //STEP 3: Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * Ajuste de estado civil
     *
     * @param listPessoa
     */
    public static void doAdjustMarriedStatus(List<Pessoa> listPessoa) {
        if (null != listPessoa && listPessoa.size() > 0) {
            for (Pessoa p : listPessoa) {
                if (p.getEstadocivil().trim().equalsIgnoreCase("1")) {
                    p.setEstadocivil("CASADO");
                } else if (p.getEstadocivil().trim().equalsIgnoreCase("2")) {
                    p.setEstadocivil("SOLTEIRO");
                } else if (p.getEstadocivil().trim().equalsIgnoreCase("4")) {
                    p.setEstadocivil("DIVORCIADO");
                } else if (p.getEstadocivil().trim().equalsIgnoreCase("5")) {
                    p.setEstadocivil("CONVIVENCIA MUTUA");
                } else if (p.getEstadocivil().trim().equalsIgnoreCase("6")) {
                    p.setEstadocivil("VIUVO");
                }

                //System.out.println(p.getNome()+" / "+p.getEstadocivil());
            }

        }
    }

    /**
     * Ajuste de tipo sanguineo
     *
     * @param listPessoa
     */
    public static void doAdjustBloodType(List<Pessoa> listPessoa) {
        if (null != listPessoa && listPessoa.size() > 0) {
            for (Pessoa p : listPessoa) {
                if (p.getTiposangue().equalsIgnoreCase("1")) {
                    p.setTiposangue("O+");
                } else if (p.getTiposangue().equalsIgnoreCase("2")) {
                    p.setTiposangue("O-");
                } else if (p.getTiposangue().equalsIgnoreCase("3")) {
                    p.setTiposangue("A-");
                } else if (p.getTiposangue().equalsIgnoreCase("4")) {
                    p.setTiposangue("AB+");
                } else if (p.getTiposangue().equalsIgnoreCase("5")) {
                    p.setTiposangue("AB-");
                } else if (p.getTiposangue().equalsIgnoreCase("6")) {
                    p.setTiposangue("A-");
                } else if (p.getTiposangue().equalsIgnoreCase("7")) {
                    p.setTiposangue("B+");
                } else if (p.getTiposangue().equalsIgnoreCase("8")) {
                    p.setTiposangue("B-");
                } else if (p.getTiposangue().equalsIgnoreCase("0")) {
                    p.setTiposangue("");
                }

                //System.out.println(p.getNome()+" / "+p.getEstadocivil() +" / "+p.getTiposangue() +" / "+p.getDoadorsangue());
            }

        }
    }

    /**
     * Ajuste de necessidades especiais
     *
     * @param listPessoa
     */
    public static void doAdjustDisabilities(List<Pessoa> listPessoa) {
        if (null != listPessoa && listPessoa.size() > 0) {
            for (Pessoa p : listPessoa) {
                if (p.getTipopne().equalsIgnoreCase("2")) {
                    p.setTipopne("DEFICIENCIA VISUAL");
                } else if (p.getTipopne().equalsIgnoreCase("3")) {
                    p.setTipopne("PARALISIA MEMBROS INFERIORES");
                } else if (p.getTipopne().equalsIgnoreCase("4")) {
                    p.setTipopne("DEFICIENCIA AUDITIVA");
                } else if (p.getTipopne().equalsIgnoreCase("5")) {
                    p.setTipopne("SURDO");
                } else if (p.getTipopne().equalsIgnoreCase("0")) {
                    p.setTipopne("");
                }

                System.out.println(p.getNome() + " / " + p.getNumeroRua() + " / " + p.getComplemento());
            }

        }
    }

   /* public static void loadAddresses() {
        List<Endereco> listEndereco = new ArrayList<Endereco>();
        Statement stmt = null;
        try {
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = loadConnection().createStatement();

            StringBuffer sql = new StringBuffer();

            sql.append("SELECT DISTINCT ")
                    .append("tb_membro.cep as cep ")
                    .append("FROM tb_membro ");

            ResultSet rs = stmt.executeQuery(sql.toString());

            //STEP 5: Extract data from result set
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setCep(rs.getString("cep").trim());
                listEndereco.add(endereco);
            }

            for (Endereco e : listEndereco) {
                if(e.getCep().trim().length()>0)
            }

             //show results
             for(Pessoa p: listPessoa){
             System.out.println(p.getNome());
             }
            System.out.println("Quantidade de cep's recuperados:" + listEndereco.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (loadConnection() != null) {
                try {
                    loadConnection().close();
                    conn = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }*/


}
