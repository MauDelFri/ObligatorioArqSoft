package Obligatorio.entidades;

import java.util.Date;

public class PersonaAntecedentePonderacion {
    private Persona persona;
    private Antecedente antecedente;
    private double calcAnt;
    private Date fechaVigDesde;
    private Date fechaVigHasta;

    public PersonaAntecedentePonderacion() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Antecedente getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(Antecedente antecedente) {
        this.antecedente = antecedente;
    }

    public double getCalcAnt() {
        return calcAnt;
    }

    public void setCalcAnt(double calcAnt) {
        this.calcAnt = calcAnt;
    }

    public Date getFechaVigDesde() {
        return fechaVigDesde;
    }

    public void setFechaVigDesde(Date fechaVigDesde) {
        this.fechaVigDesde = fechaVigDesde;
    }

    public Date getFechaVigHasta() {
        return fechaVigHasta;
    }

    public void setFechaVigHasta(Date fechaVigHasta) {
        this.fechaVigHasta = fechaVigHasta;
    }
    
    
}
