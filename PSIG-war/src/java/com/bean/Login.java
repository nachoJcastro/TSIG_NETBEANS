/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.logica.AdministradorL;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gaston
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class Login{

    private String password;
    private String nick;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext facesContext;
    private FacesMessage facesMessage;

    @EJB
    private AdministradorL AdmL;
    
    public String getUsuario() {
        return nick;
    }

    public void setUsuario(String nick) {
        this.nick = nick;
    }
        

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Login ()
    { 
        this.facesContext = FacesContext.getCurrentInstance();
        this.httpServletRequest=(HttpServletRequest)facesContext.getExternalContext().getRequest();
    }
    
    public String checkLogin(){
        System.err.println("Entre checklogin");
        boolean estaLogueado;
        estaLogueado = false;
        //String msg = "";
        //String retorno=null;
        
            if(AdmL.login(nick, password))
            {
                System.err.println("Entre if login");
                httpServletRequest.getSession().setAttribute("nick", nick);
                httpServletRequest.getSession().setAttribute("nombre", AdmL.findadm(nick).getNombre());
                facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Acceso correcto",null);
                facesContext.addMessage(null, facesMessage);
                estaLogueado = true;
                return "admin";
            }
            else
            {   System.err.println("Entre else login");
                estaLogueado= false;
                facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario o contraseña invalido",null);
                facesContext.addMessage(null, facesMessage);
                return "login";
            }
    }
    
    
        
    

    
    /*public void checkLogin(){
        
        boolean estaLogueado;
        estaLogueado = false;
        String msg = "";
        
        if(AdmL.login(nick, password))
        {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nick", nick);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nombre", AdmL.findadm(nick).getNombre());
            estaLogueado = true;
      
        }
        else
        {
            estaLogueado= false;
            FacesMessage fm = new FacesMessage("Usuario o contraseña invalido");
            FacesContext.getCurrentInstance().addMessage("msg", fm);

        }
        
        if (estaLogueado == true ){
                if (!AdmL.findadm(nick).getRol())
                        try {
                                msg = "Bienvenido "+AdmL.findadm(nick).getNombre().trim()+"!";
                                FacesContext.getCurrentInstance().getExternalContext().redirect("index");
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                else
                        try {
                                msg = "Bienvenido "+AdmL.findadm(nick).getNombre().trim()+"!";
                                FacesMessage fm = new FacesMessage(msg);
                                FacesContext.getCurrentInstance().addMessage("msg", fm);
                                FacesContext.getCurrentInstance().getExternalContext().redirect("index");
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
             
        }
        
    }*/
    
    
        
    
}
