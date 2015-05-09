/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.logica.AdministradorL;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author vane
 */
@ManagedBean
@SessionScoped
public class AdministradorBean {
    
    private String login;
    private String clave;
    private String nombre;
    private String apellido;
    private int cedula;
    private int telefono;
    private String email;
    private boolean rol;
    
    
    @EJB
    private AdministradorL AdmL;
    
    public AdministradorBean(){
    }
    
    public boolean crearAdministrador(){
        
        AdmL.crearAdministrador(login, clave, nombre, apellido, cedula, telefono, email, rol);
        return true;
    }
}
