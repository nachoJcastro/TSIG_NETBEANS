/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entity.Administrador;
import com.logica.AdministradorL;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author vane
 */
@ManagedBean
@RequestScoped
public class indexBean {
    
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
    private Administrador adm;
    
    public indexBean(){
    }
    
    public boolean crearAdministrador(){
                
        AdmL.crearAdministrador(login, clave, nombre, apellido, cedula, telefono, email, rol);
        return true;
    }
    
    public boolean loginadm(){
        return AdmL.login(adm.getLogin(),adm.getClave());    
        //return AdmL.login("vanecas","1");    
    }
    
    public boolean editAdministrador(String login,String clave,String nombre,String apellido,int cedula,int telefono,String email,boolean rol){
        return AdmL.editAdministrador(login, clave, nombre, apellido, cedula, telefono, email, rol);
    }
        
    
     public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getRol() {
        return rol;
    }

    public void setRol(Boolean rol) {
        this.rol = rol;
    }
}
