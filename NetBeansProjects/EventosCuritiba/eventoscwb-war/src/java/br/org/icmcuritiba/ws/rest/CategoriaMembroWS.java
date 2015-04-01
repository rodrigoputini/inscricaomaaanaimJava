/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.icmcuritiba.ws.rest;

import br.org.icmcuritiba.entity.Categoriamembro;
import br.org.icmcuritiba.exception.EventosException;
import br.org.icmcuritiba.interfaces.CategoriaMembroRemote;
import br.org.icmcuritiba.to.CategoriaMembroTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Rodrigo C Putini - rodrigo.putini@gmail.com
 * @since 25 mar 2015
 */
@Path("/categoriamembro")
public class CategoriaMembroWS {
    
    @POST
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoriaMembroTO> getAll(){
        List<CategoriaMembroTO> lstCategoriaMembro = new ArrayList<CategoriaMembroTO>();
        try {
            CategoriaMembroRemote categoriaMembroEjb = (CategoriaMembroRemote) new InitialContext().lookup("ejb:EventosCuritiba/eventoscwb-ejb/CategoriamembroFacade!br.org.icmcuritiba.interfaces.CategoriaMembroRemote");
            List<Categoriamembro> lstEntityCategoriamembro = categoriaMembroEjb.getAllCategoriasMembro();
            for(Categoriamembro cm:lstEntityCategoriamembro){
                CategoriaMembroTO cmto = new CategoriaMembroTO();
                cmto.setCodcategoriamembro(cm.getCodcategoriamembro());
                cmto.setDesccategoriamembro(cm.getDesccategoriamembro());
                lstCategoriaMembro.add(cmto);
            }
        } catch (NamingException ex) {
            try {
                throw new EventosException(ex, CategoriaMembroWS.class.getName());
            } catch (EventosException ex1) {
                Logger.getLogger(CategoriaMembroWS.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
       return lstCategoriaMembro;
    }

}
