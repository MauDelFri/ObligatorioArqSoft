/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByPersonaId", query = "SELECT p FROM Persona p WHERE p.personaId = :personaId"),
    @NamedQuery(name = "Persona.findByPersonaNombre", query = "SELECT p FROM Persona p WHERE p.personaNombre = :personaNombre"),
    @NamedQuery(name = "Persona.findByPersonaApellido", query = "SELECT p FROM Persona p WHERE p.personaApellido = :personaApellido"),
    @NamedQuery(name = "Persona.findByPersonaCedula", query = "SELECT p FROM Persona p WHERE p.personaCedula = :personaCedula"),
    @NamedQuery(name = "Persona.findByPersonaFechanac", query = "SELECT p FROM Persona p WHERE p.personaFechanac = :personaFechanac"),
    @NamedQuery(name = "Persona.findByPersonaGenero", query = "SELECT p FROM Persona p WHERE p.personaGenero = :personaGenero"),
    @NamedQuery(name = "Persona.findByPersonaPeso", query = "SELECT p FROM Persona p WHERE p.personaPeso = :personaPeso"),
    @NamedQuery(name = "Persona.findByPersonaAltura", query = "SELECT p FROM Persona p WHERE p.personaAltura = :personaAltura"),
    @NamedQuery(name = "Persona.findByPersonaImc", query = "SELECT p FROM Persona p WHERE p.personaImc = :personaImc")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONA_ID")
    private Long personaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "PERSONA_NOMBRE")
    private String personaNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "PERSONA_APELLIDO")
    private String personaApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "PERSONA_CEDULA")
    private String personaCedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONA_FECHANAC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date personaFechanac;
    @Size(max = 1)
    @Column(name = "PERSONA_GENERO")
    private String personaGenero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PERSONA_PESO")
    private BigDecimal personaPeso;
    @Column(name = "PERSONA_ALTURA")
    private BigDecimal personaAltura;
    @Column(name = "PERSONA_IMC")
    private BigDecimal personaImc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Personaantecedenteponderacion> personaantecedenteponderacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emergenciaPersonaid", fetch = FetchType.LAZY)
    private List<Emergencia> emergenciaList;

    public Persona() {
    }

    public Persona(Long personaId) {
        this.personaId = personaId;
    }

    public Persona(Long personaId, String personaNombre, String personaApellido, String personaCedula, Date personaFechanac) {
        this.personaId = personaId;
        this.personaNombre = personaNombre;
        this.personaApellido = personaApellido;
        this.personaCedula = personaCedula;
        this.personaFechanac = personaFechanac;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    public String getPersonaNombre() {
        return personaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    public String getPersonaApellido() {
        return personaApellido;
    }

    public void setPersonaApellido(String personaApellido) {
        this.personaApellido = personaApellido;
    }

    public String getPersonaCedula() {
        return personaCedula;
    }

    public void setPersonaCedula(String personaCedula) {
        this.personaCedula = personaCedula;
    }

    public Date getPersonaFechanac() {
        return personaFechanac;
    }

    public void setPersonaFechanac(Date personaFechanac) {
        this.personaFechanac = personaFechanac;
    }

    public String getPersonaGenero() {
        return personaGenero;
    }

    public void setPersonaGenero(String personaGenero) {
        this.personaGenero = personaGenero;
    }

    public BigDecimal getPersonaPeso() {
        return personaPeso;
    }

    public void setPersonaPeso(BigDecimal personaPeso) {
        this.personaPeso = personaPeso;
    }

    public BigDecimal getPersonaAltura() {
        return personaAltura;
    }

    public void setPersonaAltura(BigDecimal personaAltura) {
        this.personaAltura = personaAltura;
    }

    public BigDecimal getPersonaImc() {
        return personaImc;
    }

    public void setPersonaImc(BigDecimal personaImc) {
        this.personaImc = personaImc;
    }

    @XmlTransient
    public List<Personaantecedenteponderacion> getPersonaantecedenteponderacionList() {
        return personaantecedenteponderacionList;
    }

    public void setPersonaantecedenteponderacionList(List<Personaantecedenteponderacion> personaantecedenteponderacionList) {
        this.personaantecedenteponderacionList = personaantecedenteponderacionList;
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
        hash += (personaId != null ? personaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.personaId == null && other.personaId != null) || (this.personaId != null && !this.personaId.equals(other.personaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Persona[ personaId=" + personaId + " ]";
    }
    
}
