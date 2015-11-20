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
@Table(name = "PONDERACIONIMC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ponderacionimc.findAll", query = "SELECT p FROM Ponderacionimc p"),
    @NamedQuery(name = "Ponderacionimc.findByPondimcId", query = "SELECT p FROM Ponderacionimc p WHERE p.pondimcId = :pondimcId"),
    @NamedQuery(name = "Ponderacionimc.findByPondimcImcdesde", query = "SELECT p FROM Ponderacionimc p WHERE p.pondimcImcdesde = :pondimcImcdesde"),
    @NamedQuery(name = "Ponderacionimc.findByPondimcImchasta", query = "SELECT p FROM Ponderacionimc p WHERE p.pondimcImchasta = :pondimcImchasta"),
    @NamedQuery(name = "Ponderacionimc.findByPondimcPonderacion", query = "SELECT p FROM Ponderacionimc p WHERE p.pondimcPonderacion = :pondimcPonderacion")})
public class Ponderacionimc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PONDIMC_ID")
    private Long pondimcId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PONDIMC_IMCDESDE")
    private BigDecimal pondimcImcdesde;
    @Column(name = "PONDIMC_IMCHASTA")
    private BigDecimal pondimcImchasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PONDIMC_PONDERACION")
    private BigDecimal pondimcPonderacion;
    @JoinColumn(name = "PONDIMC_ANTECEDENTE_ID", referencedColumnName = "ANTECEDENTE_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Antecedente pondimcAntecedenteId;

    public Ponderacionimc() {
    }

    public Ponderacionimc(Long pondimcId) {
        this.pondimcId = pondimcId;
    }

    public Ponderacionimc(Long pondimcId, BigDecimal pondimcImcdesde, BigDecimal pondimcPonderacion) {
        this.pondimcId = pondimcId;
        this.pondimcImcdesde = pondimcImcdesde;
        this.pondimcPonderacion = pondimcPonderacion;
    }

    public Long getPondimcId() {
        return pondimcId;
    }

    public void setPondimcId(Long pondimcId) {
        this.pondimcId = pondimcId;
    }

    public BigDecimal getPondimcImcdesde() {
        return pondimcImcdesde;
    }

    public void setPondimcImcdesde(BigDecimal pondimcImcdesde) {
        this.pondimcImcdesde = pondimcImcdesde;
    }

    public BigDecimal getPondimcImchasta() {
        return pondimcImchasta;
    }

    public void setPondimcImchasta(BigDecimal pondimcImchasta) {
        this.pondimcImchasta = pondimcImchasta;
    }

    public BigDecimal getPondimcPonderacion() {
        return pondimcPonderacion;
    }

    public void setPondimcPonderacion(BigDecimal pondimcPonderacion) {
        this.pondimcPonderacion = pondimcPonderacion;
    }

    public Antecedente getPondimcAntecedenteId() {
        return pondimcAntecedenteId;
    }

    public void setPondimcAntecedenteId(Antecedente pondimcAntecedenteId) {
        this.pondimcAntecedenteId = pondimcAntecedenteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pondimcId != null ? pondimcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ponderacionimc)) {
            return false;
        }
        Ponderacionimc other = (Ponderacionimc) object;
        if ((this.pondimcId == null && other.pondimcId != null) || (this.pondimcId != null && !this.pondimcId.equals(other.pondimcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ponderacionimc[ pondimcId=" + pondimcId + " ]";
    }
    
}
