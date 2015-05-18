/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logica;

import com.DAO.PropietarioFacadeLocal;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.EJB;
import com.entity.Propietario;
import java.util.List;
/**
 *
 * @author Gaston
 */
@Stateless
@LocalBean
public class PropietarioL {
//se implementa
    @EJB
    private PropietarioFacadeLocal propFacade;
    
    public boolean crearInmueble(Propietario prop){        
        propFacade.crearPropietario(prop);
        return true;
    }
    
    public boolean editarInmueble(Propietario prop){
        Propietario propietario = propFacade.findPropietario(prop.getIdPropietario());
        
        propietario.setNombre(prop.getNombre());
        propietario.setApellido(prop.getApellido());
        propietario.setTelefono(prop.getTelefono());
        propietario.setCi(prop.getCi());
        propietario.setEmail(prop.getEmail());

                        
        return propFacade.editarPropietario(propietario);
    }
    
    
    public List<Propietario> AllPropietarios(){                
        return propFacade.findAll();
    }
    
    
    
    
}
