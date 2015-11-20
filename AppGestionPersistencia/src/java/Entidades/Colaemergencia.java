/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "COLAEMERGENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colaemergencia.findAll", query = "SELECT c FROM Colaemergencia c"),
    @NamedQuery(name = "Colaemergencia.findByColaemergenciaId", query = "SELECT c FROM Colaemergencia c WHERE c.colaemergenciaId = :colaemergenciaId"),
    @NamedQuery(name = "Colaemergencia.findByColaemergenciaDescripcion", query = "SELECT c FROM Colaemergencia c WHERE c.colaemergenciaDescripcion = :colaemergenciaDescripcion")})
public class Colaemergencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COLAEMERGENCIA_ID")
    private Long colaemergenciaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "COLAEMERGENCIA_DESCRIPCION")
    private String colaemergenciaDescripcion;
    @ManyToMany(mappedBy = "colaemergenciaList", fetch = FetchType.LAZY)
    private List<Ambulancia> ambulanciaList;
    @JoinTable(name = "PUBSCOLAEMERGENCIA", joinColumns = {
        @JoinColumn(name = "PUBSCE_COLAEMERGENCIA_ID", referencedColumnName = "COLAEMERGENCIA_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PUBSCE_EMERGENCIA_ID", referencedColumnName = "EMERGENCIA_ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Emergencia> emergenciaList;

    public Colaemergencia() {
    }

    public Colaemergencia(Long colaemergenciaId) {
        this.colaemergenciaId = colaemergenciaId;
    }

    public Colaemergencia(Long colaemergenciaId, String colaemergenciaDescripcion) {
        this.colaemergenciaId = colaemergenciaId;
        this.colaemergenciaDescripcion = colaemergenciaDescripcion;
    }

    public Long getColaemergenciaId() {
        return colaemergenciaId;
    }

    public void setColaemergenciaId(Long colaemergenciaId) {
        this.colaemergenciaId = colaemergenciaId;
    }

    public String getColaemergenciaDescripcion() {
        return colaemergenciaDescripcion;
    }

    public void setColaemergenciaDescripcion(String colaemergenciaDescripcion) {
        this.colaemergenciaDescripcion = colaemergenciaDescripcion;
    }

    @XmlTransient
    public List<Ambulancia> getAmbulanciaList() {
        return ambulanciaList;
    }

    public void setAmbulanciaList(List<Ambulancia> ambulanciaList) {
        this.ambulanciaList = ambulanciaList;
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
        hash += (colaemergenciaId != null ? colaemergenciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colaemergencia)) {
            return false;
        }
        Colaemergencia other = (Colaemergencia) object;
        if ((this.colaemergenciaId == null && other.colaemergenciaId != null) || (this.colaemergenciaId != null && !this.colaemergenciaId.equals(other.colaemergenciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Colaemergencia[ colaemergenciaId=" + colaemergenciaId + " ]";
    }
    
}
