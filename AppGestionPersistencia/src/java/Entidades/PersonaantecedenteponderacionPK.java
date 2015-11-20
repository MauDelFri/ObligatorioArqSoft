/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mauricio
 */
@Embeddable
public class PersonaantecedenteponderacionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAP_PERSONAID")
    private long papPersonaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAP_ANTECEDENTEID")
    private long papAntecedenteid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAP_FECHAVIGDESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date papFechavigdesde;

    public PersonaantecedenteponderacionPK() {
    }

    public PersonaantecedenteponderacionPK(long papPersonaid, long papAntecedenteid, Date papFechavigdesde) {
        this.papPersonaid = papPersonaid;
        this.papAntecedenteid = papAntecedenteid;
        this.papFechavigdesde = papFechavigdesde;
    }

    public long getPapPersonaid() {
        return papPersonaid;
    }

    public void setPapPersonaid(long papPersonaid) {
        this.papPersonaid = papPersonaid;
    }

    public long getPapAntecedenteid() {
        return papAntecedenteid;
    }

    public void setPapAntecedenteid(long papAntecedenteid) {
        this.papAntecedenteid = papAntecedenteid;
    }

    public Date getPapFechavigdesde() {
        return papFechavigdesde;
    }

    public void setPapFechavigdesde(Date papFechavigdesde) {
        this.papFechavigdesde = papFechavigdesde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) papPersonaid;
        hash += (int) papAntecedenteid;
        hash += (papFechavigdesde != null ? papFechavigdesde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaantecedenteponderacionPK)) {
            return false;
        }
        PersonaantecedenteponderacionPK other = (PersonaantecedenteponderacionPK) object;
        if (this.papPersonaid != other.papPersonaid) {
            return false;
        }
        if (this.papAntecedenteid != other.papAntecedenteid) {
            return false;
        }
        if ((this.papFechavigdesde == null && other.papFechavigdesde != null) || (this.papFechavigdesde != null && !this.papFechavigdesde.equals(other.papFechavigdesde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PersonaantecedenteponderacionPK[ papPersonaid=" + papPersonaid + ", papAntecedenteid=" + papAntecedenteid + ", papFechavigdesde=" + papFechavigdesde + " ]";
    }
    
}
