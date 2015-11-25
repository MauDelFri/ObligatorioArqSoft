package DominioDTO;

import java.math.BigDecimal;
import java.util.Date;

public class EmergenciaDTO {

    private PersonaDTO persona;
    private AmbulanciaDTO ambulancia;

    private int emergenciaID;
    private BigDecimal calcperfil;
    private short urgenciaSolicitada;
    private String observaciones;

    private Date fechaSolicitada;
    private Date fechaResuelta;
    private short urgenciaResuelta;

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

    public BigDecimal getCalcperfil() {
        return calcperfil;
    }

    public void setCalcperfil(BigDecimal calcperfil) {
        this.calcperfil = calcperfil;
    }

    public short getUrgenciaSolicitada() {
        return urgenciaSolicitada;
    }

    public void setUrgenciaSolicitada(short urgenciaSolicitada) {
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

    public short getUrgenciaResuelta() {
        return urgenciaResuelta;
    }

    public void setUrgenciaResuelta(short urgenciaResuelta) {
        this.urgenciaResuelta = urgenciaResuelta;
    }

}
