/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author Mauricio
 */
@Entity
@Table(name = "AMBULANCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ambulancia.findAll", query = "SELECT a FROM Ambulancia a"),
    @NamedQuery(name = "Ambulancia.findByAmbulanciaId", query = "SELECT a FROM Ambulancia a WHERE a.ambulanciaId = :ambulanciaId"),
    @NamedQuery(name = "Ambulancia.findByAmbulanciaNombre", query = "SELECT a FROM Ambulancia a WHERE a.ambulanciaNombre = :ambulanciaNombre"),
    @NamedQuery(name = "Ambulancia.findByAmbulanciaDisponible", query = "SELECT a FROM Ambulancia a WHERE a.ambulanciaDisponible = :ambulanciaDisponible")})
public class Ambulancia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMBULANCIA_ID")
    private Long ambulanciaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "AMBULANCIA_NOMBRE")
    private String ambulanciaNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMBULANCIA_DISPONIBLE")
    private short ambulanciaDisponible;
    @JoinTable(name = "SUBSCOLAEMERGENCIA", joinColumns = {
        @JoinColumn(name = "SUBSCE_AMBULANCIA_ID", referencedColumnName = "AMBULANCIA_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SUBSCE_COLAEMERGENCIA_ID", referencedColumnName = "COLAEMERGENCIA_ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Colaemergencia> colaemergenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emergenciaAmbulanciaid", fetch = FetchType.LAZY)
    private List<Emergencia> emergenciaList;

    public Ambulancia() {
    }

    public Ambulancia(Long ambulanciaId) {
        this.ambulanciaId = ambulanciaId;
    }

    public Ambulancia(Long ambulanciaId, String ambulanciaNombre, short ambulanciaDisponible) {
        this.ambulanciaId = ambulanciaId;
        this.ambulanciaNombre = ambulanciaNombre;
        this.ambulanciaDisponible = ambulanciaDisponible;
    }

    public Long getAmbulanciaId() {
        return ambulanciaId;
    }

    public void setAmbulanciaId(Long ambulanciaId) {
        this.ambulanciaId = ambulanciaId;
    }

    public String getAmbulanciaNombre() {
        return ambulanciaNombre;
    }

    public void setAmbulanciaNombre(String ambulanciaNombre) {
        this.ambulanciaNombre = ambulanciaNombre;
    }

    public short getAmbulanciaDisponible() {
        return ambulanciaDisponible;
    }

    public void setAmbulanciaDisponible(short ambulanciaDisponible) {
        this.ambulanciaDisponible = ambulanciaDisponible;
    }

    @XmlTransient
    public List<Colaemergencia> getColaemergenciaList() {
        return colaemergenciaList;
    }

    public void setColaemergenciaList(List<Colaemergencia> colaemergenciaList) {
        this.colaemergenciaList = colaemergenciaList;
    }

    @XmlTransient
    public List<Emergencia> getEmergenciaList() {
        return emergenciaList;
    }

    public void setEmergenciaList(List<Emergencia> emergenciaList) {
        this.emergenciaList = emergenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ambulanciaId != null ? ambulanciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ambulancia)) {
            return false;
        }
        Ambulancia other = (Ambulancia) object;
        if ((this.ambulanciaId == null && other.ambulanciaId != null) || (this.ambulanciaId != null && !this.ambulanciaId.equals(other.ambulanciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ambulancia[ ambulanciaId=" + ambulanciaId + " ]";
    }
    
}
