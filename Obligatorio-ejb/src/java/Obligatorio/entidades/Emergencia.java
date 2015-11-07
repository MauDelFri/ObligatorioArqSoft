package Obligatorio.entidades;

import java.util.Date;
import java.util.Set;

public class Emergencia {
    private int emergenciaID;
    private Persona persona;
    private Date fechaHoraSolicitada;
    private double calcPerfil;
    private int urgencia;
    private Ambulancia ambulancia;
    private Date fechaHoraReportado;
    private Date fechaHoraResuelta;
    private int urgenciaResuelta;
    private Set<JMS> colas;

    public Emergencia() {
    }

    public int getEmergenciaID() {
        return emergenciaID;
    }

    public void setEmergenciaID(int emergenciaID) {
        this.emergenciaID = emergenciaID;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Date getFechaHoraSolicitada() {
        return fechaHoraSolicitada;
    }

    public void setFechaHoraSolicitada(Date fechaHoraSolicitada) {
        this.fechaHoraSolicitada = fechaHoraSolicitada;
    }

    public double getCalcPerfil() {
        return calcPerfil;
    }

    public void setCalcPerfil(double calcPerfil) {
        this.calcPerfil = calcPerfil;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }

    public Ambulancia getAmbulancia() {
        return ambulancia;
    }

    public void setAmbulancia(Ambulancia ambulancia) {
        this.ambulancia = ambulancia;
    }

    public Date getFechaHoraReportado() {
        return fechaHoraReportado;
    }

    public void setFechaHoraReportado(Date fechaHoraReportado) {
        this.fechaHoraReportado = fechaHoraReportado;
    }

    public Date getFechaHoraResuelta() {
        return fechaHoraResuelta;
    }

    public void setFechaHoraResuelta(Date fechaHoraResuelta) {
        this.fechaHoraResuelta = fechaHoraResuelta;
    }

    public int getUrgenciaResuelta() {
        return urgenciaResuelta;
    }

    public void setUrgenciaResuelta(int urgenciaResuelta) {
        this.urgenciaResuelta = urgenciaResuelta;
    }

    public Set<JMS> getColas() {
        return colas;
    }

    public void setColas(Set<JMS> colas) {
        this.colas = colas;
    }
    
    public void AgregarCola(JMS nuevaCola){
        this.colas.add(nuevaCola);
    }
    
    public void EliminarCola(JMS cola){
        this.colas.remove(cola);
    }   
}
