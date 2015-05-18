/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logica;

import com.DAO.PropietarioFacadeLocal;
import com.entity.Propietario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Gaston
 */
@Stateless
@LocalBean
public class PropietarioL {
    
    @EJB
    private PropietarioFacadeLocal propFacadeLocal;

    public boolean crearPropietario(String nombre,String apellido,int telefono, String email, int ci){
       
        Propietario prop = new Propietario();
        prop.setNombre(nombre);
        prop.setApellido(apellido);
        prop.setTelefono(telefono);
        prop.setEmail(email);
        prop.setCi(ci);
  
        return propFacadeLocal.crearPropietario(prop);        
    }
    
     
    public boolean editAdministrador(Propietario prop){
        Propietario pro = findProp(prop.nombre);
        pro.setApellido(prop.apellido);
        pro.setTelefono(prop.telefono);
        pro.setEmail(prop.email);
        pro.setCi(prop.ci);

        return propFacadeLocal.editarPropietario(prop);
    }
    
    public List<Propietario> listarPropietarios(){
        return propFacadeLocal.findAll();
    }
    
    public Propietario findProp(String id){
        return propFacadeLocal.find(id);
    }
    
    
}
