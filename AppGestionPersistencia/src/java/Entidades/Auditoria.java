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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "AUDITORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a"),
    @NamedQuery(name = "Auditoria.findByAuditoriaId", query = "SELECT a FROM Auditoria a WHERE a.auditoriaId = :auditoriaId"),
    @NamedQuery(name = "Auditoria.findByAuditoriaUsuario", query = "SELECT a FROM Auditoria a WHERE a.auditoriaUsuario = :auditoriaUsuario"),
    @NamedQuery(name = "Auditoria.findByAuditoriaFuncionalidad", query = "SELECT a FROM Auditoria a WHERE a.auditoriaFuncionalidad = :auditoriaFuncionalidad"),
    @NamedQuery(name = "Auditoria.findByAuditoriaFecha", query = "SELECT a FROM Auditoria a WHERE a.auditoriaFecha = :auditoriaFecha"),
    @NamedQuery(name = "Auditoria.findByAuditoriaObservaciones", query = "SELECT a FROM Auditoria a WHERE a.auditoriaObservaciones = :auditoriaObservaciones"),
    @NamedQuery(name = "Auditoria.findByAuditoriaResultado", query = "SELECT a FROM Auditoria a WHERE a.auditoriaResultado = :auditoriaResultado")})
public class Auditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUDITORIA_ID")
    private Long auditoriaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUDITORIA_USUARIO")
    private long auditoriaUsuario;
    @Size(max = 200)
    @Column(name = "AUDITORIA_FUNCIONALIDAD")
    private String auditoriaFuncionalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUDITORIA_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auditoriaFecha;
    @Size(max = 400)
    @Column(name = "AUDITORIA_OBSERVACIONES")
    private String auditoriaObservaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "AUDITORIA_RESULTADO")
    private String auditoriaResultado;

    public Auditoria() {
    }

    public Auditoria(Long auditoriaId) {
        this.auditoriaId = auditoriaId;
    }

    public Auditoria(Long auditoriaId, long auditoriaUsuario, Date auditoriaFecha, String auditoriaResultado) {
        this.auditoriaId = auditoriaId;
        this.auditoriaUsuario = auditoriaUsuario;
        this.auditoriaFecha = auditoriaFecha;
        this.auditoriaResultado = auditoriaResultado;
    }

    public Long getAuditoriaId() {
        return auditoriaId;
    }

    public void setAuditoriaId(Long auditoriaId) {
        this.auditoriaId = auditoriaId;
    }

    public long getAuditoriaUsuario() {
        return auditoriaUsuario;
    }

    public void setAuditoriaUsuario(long auditoriaUsuario) {
        this.auditoriaUsuario = auditoriaUsuario;
    }

    public String getAuditoriaFuncionalidad() {
        return auditoriaFuncionalidad;
    }

    public void setAuditoriaFuncionalidad(String auditoriaFuncionalidad) {
        this.auditoriaFuncionalidad = auditoriaFuncionalidad;
    }

    public Date getAuditoriaFecha() {
        return auditoriaFecha;
    }

    public void setAuditoriaFecha(Date auditoriaFecha) {
        this.auditoriaFecha = auditoriaFecha;
    }

    public String getAuditoriaObservaciones() {
        return auditoriaObservaciones;
    }

    public void setAuditoriaObservaciones(String auditoriaObservaciones) {
        this.auditoriaObservaciones = auditoriaObservaciones;
    }

    public String getAuditoriaResultado() {
        return auditoriaResultado;
    }

    public void setAuditoriaResultado(String auditoriaResultado) {
        this.auditoriaResultado = auditoriaResultado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auditoriaId != null ? auditoriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.auditoriaId == null && other.auditoriaId != null) || (this.auditoriaId != null && !this.auditoriaId.equals(other.auditoriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Auditoria[ auditoriaId=" + auditoriaId + " ]";
    }
    
}
