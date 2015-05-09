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
    
    public String crearAdministrador(String login,String clave,String nombre,String apellido,int cedula,int telefono,String email,boolean rol){
        admfacadelocal.crearAdministrador(login,clave,nombre,apellido,cedula,telefono,email,rol);
        return "OK";
    }
    
}
