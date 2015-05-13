/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logica;

import com.DAO.ImagenesFacadeLocal;
import com.DAO.InmuebleFacadeLocal;
import com.entity.Imagenes;
import com.entity.Inmueble;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author vane
 */
@Stateless
@LocalBean
public class InmuebleL {
    
    @EJB
    private InmuebleFacadeLocal inmfacade;
    private ImagenesFacadeLocal imagenfacade;
    
    public boolean crearInmueble(Inmueble inm){        
        inmfacade.crearInmueble(inm);
        return true;
    }
    
    public boolean editarInmueble(Inmueble inm){
        Inmueble inmueble = inmfacade.findInmueble(inm.getGidInm());
        
        inmueble.setBanios(inm.getBanios());
        inmueble.setDescripcion(inm.getDescripcion());
        inmueble.setDireccion(inm.getDireccion());
        inmueble.setEstado(inm.getEstado());
        inmueble.setGarage(inm.getGarage());
        inmueble.setGidzona(inm.getGidzona());
        inmueble.setHabitaciones(inm.getHabitaciones());
        inmueble.setIdAdmin(inm.getIdAdmin());
        inmueble.setIdPropietario(inm.getIdPropietario());
        inmueble.setJardin(inm.getJardin());
        inmueble.setPadron(inm.getPadron());
        inmueble.setPisos(inm.getPisos());
        inmueble.setProposito(inm.getProposito());
        inmueble.setTipo(inm.getTipo());
        inmueble.setValormax(inm.getValormax());
        inmueble.setValormin(inm.getValormin());
        inmueble.setTitulo(inm.getTitulo());
                        
        return inmfacade.editarInmueble(inmueble);
    }
    
    
    public List<Inmueble> AllInmueble(){                
        return inmfacade.findAll();
    }
    
    
    public List<Imagenes> findImagenesInm(Object gidinmueble){
        List<Imagenes> all = imagenfacade.findAllImg();
        List<Imagenes> resultado = null;
        
        for(int i=0;i< all.size()-1;i++){
            Imagenes img = (Imagenes) all.get(i);
            
            if(gidinmueble == img.getGidInm()){
                resultado.add(img);
            } 
        }           
        return resultado;
    }
    
     public List<Imagenes> findImagenDestacada(Object gidinmueble){
        List<Imagenes> all = imagenfacade.findAllImg();
        List<Imagenes> resultado = null;
        
        for(int i=0;i< all.size()-1;i++){
            Imagenes img = (Imagenes) all.get(i);
            
            if(gidinmueble == img.getGidInm() && img.getDestacada() == true){
                resultado.add(img);
            } 
        }           
        return resultado;
    }
    
}
