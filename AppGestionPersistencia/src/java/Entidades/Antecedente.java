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
@Table(name = "ANTECEDENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antecedente.findAll", query = "SELECT a FROM Antecedente a"),
    @NamedQuery(name = "Antecedente.findByAntecedenteId", query = "SELECT a FROM Antecedente a WHERE a.antecedenteId = :antecedenteId"),
    @NamedQuery(name = "Antecedente.findByAntecedenteNombre", query = "SELECT a FROM Antecedente a WHERE a.antecedenteNombre = :antecedenteNombre"),
    @NamedQuery(name = "Antecedente.findByAntecedenteFactorriesgoalto", query = "SELECT a FROM Antecedente a WHERE a.antecedenteFactorriesgoalto = :antecedenteFactorriesgoalto"),
    @NamedQuery(name = "Antecedente.findByAntecedenteFactorriesgomedio", query = "SELECT a FROM Antecedente a WHERE a.antecedenteFactorriesgomedio = :antecedenteFactorriesgomedio"),
    @NamedQuery(name = "Antecedente.findByAntecedenteFactorriesgobajo", query = "SELECT a FROM Antecedente a WHERE a.antecedenteFactorriesgobajo = :antecedenteFactorriesgobajo")})
public class Antecedente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANTECEDENTE_ID")
    private Long antecedenteId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ANTECEDENTE_NOMBRE")
    private String antecedenteNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANTECEDENTE_FACTORRIESGOALTO")
    private short antecedenteFactorriesgoalto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANTECEDENTE_FACTORRIESGOMEDIO")
    private short antecedenteFactorriesgomedio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANTECEDENTE_FACTORRIESGOBAJO")
    private short antecedenteFactorriesgobajo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "antecedente", fetch = FetchType.LAZY)
    private List<Personaantecedenteponderacion> personaantecedenteponderacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pondimcAntecedenteId", fetch = FetchType.LAZY)
    private List<Ponderacionimc> ponderacionimcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pondedadAntecedenteId", fetch = FetchType.LAZY)
    private List<Ponderacionedad> ponderacionedadList;

    public Antecedente() {
    }

    public Antecedente(Long antecedenteId) {
        this.antecedenteId = antecedenteId;
    }

    public Antecedente(Long antecedenteId, String antecedenteNombre, short antecedenteFactorriesgoalto, short antecedenteFactorriesgomedio, short antecedenteFactorriesgobajo) {
        this.antecedenteId = antecedenteId;
        this.antecedenteNombre = antecedenteNombre;
        this.antecedenteFactorriesgoalto = antecedenteFactorriesgoalto;
        this.antecedenteFactorriesgomedio = antecedenteFactorriesgomedio;
        this.antecedenteFactorriesgobajo = antecedenteFactorriesgobajo;
    }

    public Long getAntecedenteId() {
        return antecedenteId;
    }

    public void setAntecedenteId(Long antecedenteId) {
        this.antecedenteId = antecedenteId;
    }

    public String getAntecedenteNombre() {
        return antecedenteNombre;
    }

    public void setAntecedenteNombre(String antecedenteNombre) {
        this.antecedenteNombre = antecedenteNombre;
    }

    public short getAntecedenteFactorriesgoalto() {
        return antecedenteFactorriesgoalto;
    }

    public void setAntecedenteFactorriesgoalto(short antecedenteFactorriesgoalto) {
        this.antecedenteFactorriesgoalto = antecedenteFactorriesgoalto;
    }

    public short getAntecedenteFactorriesgomedio() {
        return antecedenteFactorriesgomedio;
    }

    public void setAntecedenteFactorriesgomedio(short antecedenteFactorriesgomedio) {
        this.antecedenteFactorriesgomedio = antecedenteFactorriesgomedio;
    }

    public short getAntecedenteFactorriesgobajo() {
        return antecedenteFactorriesgobajo;
    }

    public void setAntecedenteFactorriesgobajo(short antecedenteFactorriesgobajo) {
        this.antecedenteFactorriesgobajo = antecedenteFactorriesgobajo;
    }

    @XmlTransient
    public List<Personaantecedenteponderacion> getPersonaantecedenteponderacionList() {
        return personaantecedenteponderacionList;
    }

    public void setPersonaantecedenteponderacionList(List<Personaantecedenteponderacion> personaantecedenteponderacionList) {
        this.personaantecedenteponderacionList = personaantecedenteponderacionList;
    }

    @XmlTransient
    public List<Ponderacionimc> getPonderacionimcList() {
        return ponderacionimcList;
    }

    public void setPonderacionimcList(List<Ponderacionimc> ponderacionimcList) {
        this.ponderacionimcList = ponderacionimcList;
    }

    @XmlTransient
    public List<Ponderacionedad> getPonderacionedadList() {
        return ponderacionedadList;
    }

    public void setPonderacionedadList(List<Ponderacionedad> ponderacionedadList) {
        this.ponderacionedadList = ponderacionedadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (antecedenteId != null ? antecedenteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antecedente)) {
            return false;
        }
        Antecedente other = (Antecedente) object;
        if ((this.antecedenteId == null && other.antecedenteId != null) || (this.antecedenteId != null && !this.antecedenteId.equals(other.antecedenteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Antecedente[ antecedenteId=" + antecedenteId + " ]";
    }
    
}
