/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icmcuritiba.auth.to;

import java.io.Serializable;

/**
 *
 * @author s016361
 */
public class SessionTO implements Serializable{
    
    private String uid;
    private String role;
    private String username;
    private String sistema;
    private String nomeCompleto;
    private String codIgreja;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCodIgreja() {
        return codIgreja;
    }

    public void setCodIgreja(String codIgreja) {
        this.codIgreja = codIgreja;
    }
    
    
    
    
    
}
