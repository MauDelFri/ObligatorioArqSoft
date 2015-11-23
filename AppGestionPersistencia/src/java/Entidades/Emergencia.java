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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "EMERGENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emergencia.findAll", query = "SELECT e FROM Emergencia e"),
    @NamedQuery(name = "Emergencia.findByEmergenciaId", query = "SELECT e FROM Emergencia e WHERE e.emergenciaId = :emergenciaId"),
    @NamedQuery(name = "Emergencia.findByEmergenciaFechasolicitada", query = "SELECT e FROM Emergencia e WHERE e.emergenciaFechasolicitada = :emergenciaFechasolicitada"),
    @NamedQuery(name = "Emergencia.findByEmergenciaCalcperfil", query = "SELECT e FROM Emergencia e WHERE e.emergenciaCalcperfil = :emergenciaCalcperfil"),
    @NamedQuery(name = "Emergencia.findByEmergenciaUrgenciasolicitada", query = "SELECT e FROM Emergencia e WHERE e.emergenciaUrgenciasolicitada = :emergenciaUrgenciasolicitada"),
    @NamedQuery(name = "Emergencia.findByEmergenciaObs", query = "SELECT e FROM Emergencia e WHERE e.emergenciaObs = :emergenciaObs"),
    @NamedQuery(name = "Emergencia.findByEmergenciaFechahoraresuelta", query = "SELECT e FROM Emergencia e WHERE e.emergenciaFechahoraresuelta = :emergenciaFechahoraresuelta"),
    @NamedQuery(name = "Emergencia.findByEmergenciaUrgenciaresuelta", query = "SELECT e FROM Emergencia e WHERE e.emergenciaUrgenciaresuelta = :emergenciaUrgenciaresuelta")})
public class Emergencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMERGENCIA_ID")
    @SequenceGenerator(name="SEQ_GEN", sequenceName="SEQ_EMERGENCIA", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
    private Long emergenciaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMERGENCIA_FECHASOLICITADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emergenciaFechasolicitada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMERGENCIA_CALCPERFIL")
    private BigDecimal emergenciaCalcperfil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMERGENCIA_URGENCIASOLICITADA")
    private short emergenciaUrgenciasolicitada;
    @Size(max = 400)
    @Column(name = "EMERGENCIA_OBS")
    private String emergenciaObs;
    @Column(name = "EMERGENCIA_FECHAHORARESUELTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emergenciaFechahoraresuelta;
    @Column(name = "EMERGENCIA_URGENCIARESUELTA")
    private Short emergenciaUrgenciaresuelta;
    @ManyToMany(mappedBy = "emergenciaList", fetch = FetchType.LAZY)
    private List<Colaemergencia> colaemergenciaList;
    @JoinColumn(name = "EMERGENCIA_AMBULANCIAID", referencedColumnName = "AMBULANCIA_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ambulancia emergenciaAmbulanciaid;
    @JoinColumn(name = "EMERGENCIA_PERSONAID", referencedColumnName = "PERSONA_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona emergenciaPersonaid;

    public Emergencia() {
    }

    public Emergencia(Long emergenciaId) {
        this.emergenciaId = emergenciaId;
    }

    public Emergencia(Long emergenciaId, Date emergenciaFechasolicitada, BigDecimal emergenciaCalcperfil, short emergenciaUrgenciasolicitada) {
        this.emergenciaId = emergenciaId;
        this.emergenciaFechasolicitada = emergenciaFechasolicitada;
        this.emergenciaCalcperfil = emergenciaCalcperfil;
        this.emergenciaUrgenciasolicitada = emergenciaUrgenciasolicitada;
    }

    public Long getEmergenciaId() {
        return emergenciaId;
    }

    public void setEmergenciaId(Long emergenciaId) {
        this.emergenciaId = emergenciaId;
    }

    public Date getEmergenciaFechasolicitada() {
        return emergenciaFechasolicitada;
    }

    public void setEmergenciaFechasolicitada(Date emergenciaFechasolicitada) {
        this.emergenciaFechasolicitada = emergenciaFechasolicitada;
    }

    public BigDecimal getEmergenciaCalcperfil() {
        return emergenciaCalcperfil;
    }

    public void setEmergenciaCalcperfil(BigDecimal emergenciaCalcperfil) {
        this.emergenciaCalcperfil = emergenciaCalcperfil;
    }

    public short getEmergenciaUrgenciasolicitada() {
        return emergenciaUrgenciasolicitada;
    }

    public void setEmergenciaUrgenciasolicitada(short emergenciaUrgenciasolicitada) {
        this.emergenciaUrgenciasolicitada = emergenciaUrgenciasolicitada;
    }

    public String getEmergenciaObs() {
        return emergenciaObs;
    }

    public void setEmergenciaObs(String emergenciaObs) {
        this.emergenciaObs = emergenciaObs;
    }

    public Date getEmergenciaFechahoraresuelta() {
        return emergenciaFechahoraresuelta;
    }

    public void setEmergenciaFechahoraresuelta(Date emergenciaFechahoraresuelta) {
        this.emergenciaFechahoraresuelta = emergenciaFechahoraresuelta;
    }

    public Short getEmergenciaUrgenciaresuelta() {
        return emergenciaUrgenciaresuelta;
    }

    public void setEmergenciaUrgenciaresuelta(Short emergenciaUrgenciaresuelta) {
        this.emergenciaUrgenciaresuelta = emergenciaUrgenciaresuelta;
    }

    @XmlTransient
    public List<Colaemergencia> getColaemergenciaList() {
        return colaemergenciaList;
    }

    public void setColaemergenciaList(List<Colaemergencia> colaemergenciaList) {
        this.colaemergenciaList = colaemergenciaList;
    }

    public Ambulancia getEmergenciaAmbulanciaid() {
        return emergenciaAmbulanciaid;
    }

    public void setEmergenciaAmbulanciaid(Ambulancia emergenciaAmbulanciaid) {
        this.emergenciaAmbulanciaid = emergenciaAmbulanciaid;
    }

    public Persona getEmergenciaPersonaid() {
        return emergenciaPersonaid;
    }

    public void setEmergenciaPersonaid(Persona emergenciaPersonaid) {
        this.emergenciaPersonaid = emergenciaPersonaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emergenciaId != null ? emergenciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emergencia)) {
            return false;
        }
        Emergencia other = (Emergencia) object;
        if ((this.emergenciaId == null && other.emergenciaId != null) || (this.emergenciaId != null && !this.emergenciaId.equals(other.emergenciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Emergencia[ emergenciaId=" + emergenciaId + " ]";
    }
    
}
