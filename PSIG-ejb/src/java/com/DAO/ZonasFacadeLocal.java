/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.entity.Zonas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vane
 */
@Local
public interface ZonasFacadeLocal {

    void create(Zonas zonas);

    void edit(Zonas zonas);

    void remove(Zonas zonas);

    Zonas find(Object id);

    List<Zonas> findAll();

    List<Zonas> findRange(int[] range);

    int count();
    
}
