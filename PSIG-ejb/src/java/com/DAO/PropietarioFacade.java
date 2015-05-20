/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.entity.Propietario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author vane
 */
@Stateless
public class PropietarioFacade extends AbstractFacade<Propietario> implements PropietarioFacadeLocal {
    @PersistenceContext(unitName = "PSIG-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PropietarioFacade() {
        super(Propietario.class);
    }
    
    @Override
    public boolean crearPropietario(Propietario prop){
        Propietario pro = new Propietario(prop.getNombre(),prop.getApellido(), prop.getTelefono(), prop.getEmail(), prop.getCi());
        em.persist(pro);
        return true;
     }
    
    @Override
    public boolean editarPropietario(Propietario prop){
        em.merge(prop);
        return true;
    }
    
    @Override
    public List<Propietario> findAll() {
        javax.persistence.criteria.CriteriaQuery query = getEntityManager().getCriteriaBuilder().createQuery();
        query.select(query.from(Propietario.class));
        return getEntityManager().createQuery(query).getResultList();                
    }
    
    public Propietario findPropietario(int ci){
        List<Propietario> allprop = findAll();                     
        
        for(int i=0;i< allprop.size()-1;i++){
            Propietario prop = (Propietario) allprop.get(i);
            if(ci == prop.getCi()){
                //busco si tiene el mismo login y si es asi lo retorno
                return prop;
            } 
        }   
        return null;
    }
    


}
