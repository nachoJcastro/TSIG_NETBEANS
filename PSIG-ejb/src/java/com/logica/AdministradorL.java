/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logica;

import com.DAO.AdministradorFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author vane
 */
@Stateless
@LocalBean
public class AdministradorL {
    @EJB
    private AdministradorFacadeLocal admfacadelocal;
    
    public String crearAdministrador(){
     //   admfacadelocal.crearAdministrador(null, null, null, null, cedula, telefono, null, true);
        return "AAP";
    }
    
}
