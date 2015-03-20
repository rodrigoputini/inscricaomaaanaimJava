/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icmcuritiba.ejb;


import java.util.Hashtable;
import javax.ejb.Stateless;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author Rodrigo Camargo Putini - rodrigo.putini@gmail.com
 */
@Stateless
public class AuthBean implements AuthBeanRemote {

    @Override
    public boolean auth(String user, String pass) {
        boolean icmAuth = false;
        String username = "cn="+user+",ou=users,dc=icmcuritiba,dc=com,dc=br";  

        if (null != user && user.length() > 3) {
            if (null != pass && pass.length() > 0) {

                Hashtable authEnv = new Hashtable(11);

                authEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
                authEnv.put(Context.PROVIDER_URL, "ldap://localhost:389");
                authEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
                authEnv.put(Context.SECURITY_PRINCIPAL, username);
                authEnv.put(Context.SECURITY_CREDENTIALS, pass);
                try {
                    DirContext authContext = new InitialDirContext(authEnv);
                    //System.out.println(authContext.getNameInNamespace());
                    //System.out.println("Autenticado!");
                    icmAuth = true;

                } catch (AuthenticationException authEx) {
                    System.out.println("Erro na autenticação! ");
                    //authEx.printStackTrace();
                } catch (NamingException namEx) {
                    System.out.println("Erro na autenticação! ");
                    //namEx.getCause().printStackTrace();  
                }
            }

        }

        return icmAuth;

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
