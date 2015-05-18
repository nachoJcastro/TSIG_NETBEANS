/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.entity.Zona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vane
 */
@Local
public interface ZonaFacadeLocal {

    
    boolean crearZona(Zona zon);
    
    boolean editarZona(Zona zon);
    
    List<Zona> allZona();

    Zona buscarZona(int gidzona);
    
    boolean borrar(Zona zona);
    
}
