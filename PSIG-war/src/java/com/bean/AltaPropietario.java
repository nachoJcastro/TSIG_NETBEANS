/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;
import com.entity.Propietario;
import com.logica.PropietarioL;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author nacheen
 */
@ManagedBean
@RequestScoped
public class AltaPropietario {
    
    private String nombre;
    private String apellido;
    private int telefono;
    private String email;
    private int ci;
    private FacesMessage facesMessage;
    
    @EJB
    private PropietarioL propL;
    private Propietario prop;

    
    public AltaPropietario() {
    }
    
    public void crearPropietario(){
        if(propL.crearPropietario(nombre, apellido, telefono, email, ci))
        {
            facesMessage= new FacesMessage(FacesMessage.SEVERITY_INFO,"El usuario se creo correctamente",null);
            this.prop = new Propietario();
        }
        else
        {
            facesMessage= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al crear usuario",null);
        }
  
    }
    
    public List<Propietario> listarPropietarios(){
        return propL.listarPropietarios();
    }
    
    public void editarPropietario(){
        
    }
    
    
    public String editPropietario(Propietario propietario){
        this.prop = propietario;
        return "EditarPropietario";
    }
    
    public void editPropietario(){
        if(propL.editAdministrador(prop))
        {
            facesMessage= new FacesMessage(FacesMessage.SEVERITY_INFO,"El usuario se creo correctamente",null);
        }
        else
        {
            facesMessage= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al crear usuario",null);
        }
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

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer cedula) {
        this.ci = cedula;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer tel) {
        this.telefono = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Propietario getProp() {
        return prop;
    }

    public void setProp(Propietario prop) {
        this.prop = prop;
    }
}
