/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;


import com.entity.Inmueble;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vane
 */
@Stateless
public class InmuebleFacade extends AbstractFacade<Inmueble> implements InmuebleFacadeLocal {
    @PersistenceContext(unitName = "PSIG-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InmuebleFacade() {
        super(Inmueble.class);
    }
    
    @Override
    public boolean crearInmueble(Inmueble inm){
        em.persist(inm);
        return true;
     }
    
    @Override
    public boolean editarInmueble(Inmueble inm){
        em.merge(inm);
        return true;
    }
    
    @Override
    public List<Inmueble> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Inmueble.class));
        return getEntityManager().createQuery(cq).getResultList();                
    }
    
    @Override
    public Inmueble findInmueble(int gidinmueble){
        List<Inmueble> todosinm = findAll();                     
        
        for(int i=0;i< todosinm.size();i++){
            Inmueble inm = (Inmueble) todosinm.get(i);
            if(gidinmueble == inm.getGidInm()){
                //busco si tiene el mismo login y si es asi lo retorno
                return inm;
            } 
        }   
        return null;
    }
    
    
    
}
