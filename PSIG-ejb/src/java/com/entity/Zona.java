package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vane
 */
@Entity
@Table(name = "zona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zona.findAll", query = "SELECT z FROM Zona z"),
    @NamedQuery(name = "Zona.findByGidzona", query = "SELECT z FROM Zona z WHERE z.gidzona = :gidzona"),
    @NamedQuery(name = "Zona.findByNombre", query = "SELECT z FROM Zona z WHERE z.nombre_zona = :nombre")})
public class Zona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "gidzona")
    private Integer gidzona;
    @Size(max = 50)
    @Column(name = "nombre_zona")
    private String nombre_zona;
    @Size(max = 250)
    @Column(name = "descripcion_zona")
    private String descripcion_zona;
    
    @Size(max = 1)
    @Column(name = "demanada")
    private String demanda;
    
    
    @OneToMany(mappedBy = "gidzona")
    private Collection<Demanda> demandaCollection;
    @OneToMany(mappedBy = "gidzona")
    private Collection<Inmueble> inmuebleCollection;

    public Zona() {
    }

    // gid zona
    public Zona(Integer gidzona) {
        this.gidzona = gidzona;
    }

    public Integer getGidzona() {
        return gidzona;
    }

    public void setGidzona(Integer gidzona) {
        this.gidzona = gidzona;
    }

    // nombre_Zona
    public String getNombre_Zona() {
        return nombre_zona;
    }

    public void setNombre_Zona(String nombre) {
        this.nombre_zona = nombre;
    }
    
    // descripcion
    public String getDescripcion_Zona() {
        return nombre_zona;
    }

    public void setDescripcion_Zona(String nombre) {
        this.descripcion_zona = nombre;
    }

    // descripcion
    public String getDemanda() {
        return demanda;
    }

    public void setDemanda(String demanda) {
        this.demanda = demanda;
    }
    
    /*@XmlTransient
    public Collection<Demanda> getDemandaCollection() {
        return demandaCollection;
    }

    public void setDemandaCollection(Collection<Demanda> demandaCollection) {
        this.demandaCollection = demandaCollection;
    }*/

    /*@XmlTransient
    public Collection<Inmueble> getInmuebleCollection() {
        return inmuebleCollection;
    }

    public void setInmuebleCollection(Collection<Inmueble> inmuebleCollection) {
        this.inmuebleCollection = inmuebleCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gidzona != null ? gidzona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zona)) {
            return false;
        }
        Zona other = (Zona) object;
        if ((this.gidzona == null && other.gidzona != null) || (this.gidzona != null && !this.gidzona.equals(other.gidzona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Zona[ gidzona=" + gidzona + " ]";
    }
    
}
