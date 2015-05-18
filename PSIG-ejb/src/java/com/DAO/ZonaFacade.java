/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.entity.Zona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vane
 */
@Stateless
public class ZonaFacade extends AbstractFacade<Zona> implements ZonaFacadeLocal {
    @PersistenceContext(unitName = "PSIG-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ZonaFacade() {
        super(Zona.class);
    }
    
    public boolean crearZona(Zona zon){
        em.persist(zon);
        return true;
     }
    
    public boolean editarZona(Zona zon){
        em.merge(zon);
        return true;
    }
    
    @Override
    public List<Zona> allZona() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Zona.class));
        return getEntityManager().createQuery(cq).getResultList();                
    }
    
    public Zona buscarZona(int gidzona){
        List<Zona> list_zona = findAll();                     
        
        for(int i=0;i< list_zona.size()-1;i++){
            Zona zon = (Zona) list_zona.get(i);
            if(gidzona == zon.getGidzona()){
                //busco si tiene el mismo login y si es asi lo retorno
                return zon;
            } 
        }   
        return null;
    }

    @Override
    public boolean borrar(Zona zon) {
        em.remove(zon);
        return true;
    }
}
