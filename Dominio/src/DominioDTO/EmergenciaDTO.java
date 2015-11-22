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
public class EmergenciaDTO {
    private PersonaDTO persona;
    private AmbulanciaDTO ambulancia;
    
    private int emergenciaID;
    private Double calcperfil;
    private int urgenciaSolicitada;
    private String observaciones;
    
    private Date fechaSolicitada;
    private Date fechaResuelta;
    private int urgenciaResuelta;

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public AmbulanciaDTO getAmbulancia() {
        return ambulancia;
    }

    public void setAmbulancia(AmbulanciaDTO ambulancia) {
        this.ambulancia = ambulancia;
    }

    public int getEmergenciaID() {
        return emergenciaID;
    }

    public void setEmergenciaID(int emergenciaID) {
        this.emergenciaID = emergenciaID;
    }

    public Double getCalcperfil() {
        return calcperfil;
    }

    public void setCalcperfil(Double calcperfil) {
        this.calcperfil = calcperfil;
    }

    public int getUrgenciaSolicitada() {
        return urgenciaSolicitada;
    }

    public void setUrgenciaSolicitada(int urgenciaSolicitada) {
        this.urgenciaSolicitada = urgenciaSolicitada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaSolicitada() {
        return fechaSolicitada;
    }

    public void setFechaSolicitada(Date fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }

    public Date getFechaResuelta() {
        return fechaResuelta;
    }

    public void setFechaResuelta(Date fechaResuelta) {
        this.fechaResuelta = fechaResuelta;
    }

    public int getUrgenciaResuelta() {
        return urgenciaResuelta;
    }

    public void setUrgenciaResuelta(int urgenciaResuelta) {
        this.urgenciaResuelta = urgenciaResuelta;
    }
}
