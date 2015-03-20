/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icmcuritiba.ejb;

import br.com.icmcuritiba.auth.to.MenuTO;
import br.com.icmcuritiba.auth.to.SessionTO;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 *
 * @author s016361
 */
@Stateless
public class AutorizationBean implements AutorizationBeanRemote {

    @Override
    public String loadRole(String username, String pass) {
        String role = null;
        Hashtable env = new Hashtable(11);
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        env.put(Context.SECURITY_AUTHENTICATION, "none");
        env.put(Context.SECURITY_PRINCIPAL, username);
        env.put(Context.SECURITY_CREDENTIALS, pass);
        try {
            LdapContext ctx = new InitialLdapContext(env,null);
            SearchControls sc = new SearchControls();
            sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String base = "dc=icmcuritiba,dc=com,dc=br";
            String filter = "(&(cn=*)(memberUid=" + username + "))";
            NamingEnumeration<?> answer = ctx.search(base, filter, sc);
            while (answer.hasMore()) {
                Attributes attrs = ((SearchResult) answer.next()).getAttributes();
                // Para pegar um atributo da busca
                Attribute attr = attrs.get("cn");
                role = attr.get().toString();
                //System.out.print(role + ": ");
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return role;
    }

    @Override
    public List<MenuTO> loadMenuByRole(String role, String sistema) {
        List<MenuTO> lstMenu = new ArrayList<MenuTO>();
        Hashtable env = new Hashtable(11);
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        env.put(Context.SECURITY_AUTHENTICATION, "none");
        //env.put(Context.SECURITY_PRINCIPAL, username);
        //env.put(Context.SECURITY_CREDENTIALS, pass);
        try {
            LdapContext ctx = new InitialLdapContext(env,null);
            SearchControls sc = new SearchControls();
            sc.setSearchScope(SearchControls.ONELEVEL_SCOPE);
            String base = "cn="+role+",ou=users,ou="+sistema+",dc=icmcuritiba,dc=com,dc=br";
            String filter = "objectClass=*";
            NamingEnumeration<?> answer = ctx.search(base, filter, sc);
            while (answer.hasMore()) {
                MenuTO menu = new MenuTO();
                Attributes attrs = ((SearchResult) answer.next()).getAttributes();
                // Para pegar um atributo da busca
                Attribute link = attrs.get("description");
                Attribute desc = attrs.get("ou");
                menu.setLink(link.get().toString());
                menu.setDesc(desc.get().toString());
                //System.out.print(role + ": ");
                lstMenu.add(menu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return lstMenu;
    }

     @Override
    public SessionTO loadCodIgrejaByUser(SessionTO session) {
        Hashtable env = new Hashtable(11);
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        env.put(Context.SECURITY_AUTHENTICATION, "none");
        //env.put(Context.SECURITY_PRINCIPAL, username);
        //env.put(Context.SECURITY_CREDENTIALS, pass);
        try {
            LdapContext ctx = new InitialLdapContext(env,null);
            SearchControls sc = new SearchControls();
            sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String base = "cn="+session.getUsername()+",ou=users,dc=icmcuritiba,dc=com,dc=br";
            String filter = "objectClass=*";
            NamingEnumeration<?> answer = ctx.search(base, filter, sc);
            while (answer.hasMore()) {
                MenuTO menu = new MenuTO();
                Attributes attrs = ((SearchResult) answer.next()).getAttributes();
                // Para pegar um atributo da busca
                Attribute givenname = attrs.get("givenname");
                Attribute sn = attrs.get("sn");
                Attribute departmentNumber = attrs.get("departmentnumber");
                session.setNomeCompleto(givenname.get()+" "+sn.get());
                session.setCodIgreja(departmentNumber.get().toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return session;
    }
    

}
