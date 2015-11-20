/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "PONDERACIONEDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ponderacionedad.findAll", query = "SELECT p FROM Ponderacionedad p"),
    @NamedQuery(name = "Ponderacionedad.findByPondedadId", query = "SELECT p FROM Ponderacionedad p WHERE p.pondedadId = :pondedadId"),
    @NamedQuery(name = "Ponderacionedad.findByPondedadEdaddesde", query = "SELECT p FROM Ponderacionedad p WHERE p.pondedadEdaddesde = :pondedadEdaddesde"),
    @NamedQuery(name = "Ponderacionedad.findByPondedadEdadhasta", query = "SELECT p FROM Ponderacionedad p WHERE p.pondedadEdadhasta = :pondedadEdadhasta"),
    @NamedQuery(name = "Ponderacionedad.findByPondedadPonderacion", query = "SELECT p FROM Ponderacionedad p WHERE p.pondedadPonderacion = :pondedadPonderacion")})
public class Ponderacionedad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PONDEDAD_ID")
    private Long pondedadId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PONDEDAD_EDADDESDE")
    private short pondedadEdaddesde;
    @Column(name = "PONDEDAD_EDADHASTA")
    private Short pondedadEdadhasta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PONDEDAD_PONDERACION")
    private BigDecimal pondedadPonderacion;
    @JoinColumn(name = "PONDEDAD_ANTECEDENTE_ID", referencedColumnName = "ANTECEDENTE_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Antecedente pondedadAntecedenteId;

    public Ponderacionedad() {
    }

    public Ponderacionedad(Long pondedadId) {
        this.pondedadId = pondedadId;
    }

    public Ponderacionedad(Long pondedadId, short pondedadEdaddesde, BigDecimal pondedadPonderacion) {
        this.pondedadId = pondedadId;
        this.pondedadEdaddesde = pondedadEdaddesde;
        this.pondedadPonderacion = pondedadPonderacion;
    }

    public Long getPondedadId() {
        return pondedadId;
    }

    public void setPondedadId(Long pondedadId) {
        this.pondedadId = pondedadId;
    }

    public short getPondedadEdaddesde() {
        return pondedadEdaddesde;
    }

    public void setPondedadEdaddesde(short pondedadEdaddesde) {
        this.pondedadEdaddesde = pondedadEdaddesde;
    }

    public Short getPondedadEdadhasta() {
        return pondedadEdadhasta;
    }

    public void setPondedadEdadhasta(Short pondedadEdadhasta) {
        this.pondedadEdadhasta = pondedadEdadhasta;
    }

    public BigDecimal getPondedadPonderacion() {
        return pondedadPonderacion;
    }

    public void setPondedadPonderacion(BigDecimal pondedadPonderacion) {
        this.pondedadPonderacion = pondedadPonderacion;
    }

    public Antecedente getPondedadAntecedenteId() {
        return pondedadAntecedenteId;
    }

    public void setPondedadAntecedenteId(Antecedente pondedadAntecedenteId) {
        this.pondedadAntecedenteId = pondedadAntecedenteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pondedadId != null ? pondedadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ponderacionedad)) {
            return false;
        }
        Ponderacionedad other = (Ponderacionedad) object;
        if ((this.pondedadId == null && other.pondedadId != null) || (this.pondedadId != null && !this.pondedadId.equals(other.pondedadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ponderacionedad[ pondedadId=" + pondedadId + " ]";
    }
    
}
