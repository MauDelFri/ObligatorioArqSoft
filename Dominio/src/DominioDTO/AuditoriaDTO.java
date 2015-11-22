/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

import java.sql.Date;

/**
 *
 * @author martinintroini
 */
public class AuditoriaDTO {
    private int auditoriaID;
    private int UsuarioID;
    private String funcionalidad;
    private Date fecha;
    private String observaciones;
    private String resultado;

    public int getAuditoriaID() {
        return auditoriaID;
    }

    public void setAuditoriaID(int auditoriaID) {
        this.auditoriaID = auditoriaID;
    }

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
