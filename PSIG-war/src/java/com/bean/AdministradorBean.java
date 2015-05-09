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
    @EJB
    private AdministradorL AdmL;
    
    public AdministradorBean(){
    }
    
    
}
