package Obligatorio.entidades;

import java.util.Date;

public class Auditoria {
    private int auditoriaID;
    private String usuario;
    private String observacion;
    private String funcionalidad;
    private Date fecha;

    public Auditoria() {
    }

    public int getAuditoriaID() {
        return auditoriaID;
    }

    public void setAuditoriaID(int auditoriaID) {
        this.auditoriaID = auditoriaID;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
