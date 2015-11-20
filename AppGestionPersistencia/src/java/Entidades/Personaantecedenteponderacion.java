/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "PERSONAANTECEDENTEPONDERACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personaantecedenteponderacion.findAll", query = "SELECT p FROM Personaantecedenteponderacion p"),
    @NamedQuery(name = "Personaantecedenteponderacion.findByPapPersonaid", query = "SELECT p FROM Personaantecedenteponderacion p WHERE p.personaantecedenteponderacionPK.papPersonaid = :papPersonaid"),
    @NamedQuery(name = "Personaantecedenteponderacion.findByPapAntecedenteid", query = "SELECT p FROM Personaantecedenteponderacion p WHERE p.personaantecedenteponderacionPK.papAntecedenteid = :papAntecedenteid"),
    @NamedQuery(name = "Personaantecedenteponderacion.findByPapCalcant", query = "SELECT p FROM Personaantecedenteponderacion p WHERE p.papCalcant = :papCalcant"),
    @NamedQuery(name = "Personaantecedenteponderacion.findByPapFechavigdesde", query = "SELECT p FROM Personaantecedenteponderacion p WHERE p.personaantecedenteponderacionPK.papFechavigdesde = :papFechavigdesde"),
    @NamedQuery(name = "Personaantecedenteponderacion.findByPapFechavighasta", query = "SELECT p FROM Personaantecedenteponderacion p WHERE p.papFechavighasta = :papFechavighasta")})
public class Personaantecedenteponderacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonaantecedenteponderacionPK personaantecedenteponderacionPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PAP_CALCANT")
    private BigDecimal papCalcant;
    @Column(name = "PAP_FECHAVIGHASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date papFechavighasta;
    @JoinColumn(name = "PAP_ANTECEDENTEID", referencedColumnName = "ANTECEDENTE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Antecedente antecedente;
    @JoinColumn(name = "PAP_PERSONAID", referencedColumnName = "PERSONA_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona persona;

    public Personaantecedenteponderacion() {
    }

    public Personaantecedenteponderacion(PersonaantecedenteponderacionPK personaantecedenteponderacionPK) {
        this.personaantecedenteponderacionPK = personaantecedenteponderacionPK;
    }

    public Personaantecedenteponderacion(long papPersonaid, long papAntecedenteid, Date papFechavigdesde) {
        this.personaantecedenteponderacionPK = new PersonaantecedenteponderacionPK(papPersonaid, papAntecedenteid, papFechavigdesde);
    }

    public PersonaantecedenteponderacionPK getPersonaantecedenteponderacionPK() {
        return personaantecedenteponderacionPK;
    }

    public void setPersonaantecedenteponderacionPK(PersonaantecedenteponderacionPK personaantecedenteponderacionPK) {
        this.personaantecedenteponderacionPK = personaantecedenteponderacionPK;
    }

    public BigDecimal getPapCalcant() {
        return papCalcant;
    }

    public void setPapCalcant(BigDecimal papCalcant) {
        this.papCalcant = papCalcant;
    }

    public Date getPapFechavighasta() {
        return papFechavighasta;
    }

    public void setPapFechavighasta(Date papFechavighasta) {
        this.papFechavighasta = papFechavighasta;
    }

    public Antecedente getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(Antecedente antecedente) {
        this.antecedente = antecedente;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaantecedenteponderacionPK != null ? personaantecedenteponderacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personaantecedenteponderacion)) {
            return false;
        }
        Personaantecedenteponderacion other = (Personaantecedenteponderacion) object;
        if ((this.personaantecedenteponderacionPK == null && other.personaantecedenteponderacionPK != null) || (this.personaantecedenteponderacionPK != null && !this.personaantecedenteponderacionPK.equals(other.personaantecedenteponderacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Personaantecedenteponderacion[ personaantecedenteponderacionPK=" + personaantecedenteponderacionPK + " ]";
    }
    
}
