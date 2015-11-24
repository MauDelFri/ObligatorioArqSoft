/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @author martinintroini
 */
public class PersonaAntecedentePonderacionDTO {

    private PersonaDTO persona;
    private AntecedenteDTO antecedente;
    private BigDecimal calcant;
    private Date fechaVigDesde;
    private Date fechaVigHasta;

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public AntecedenteDTO getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(AntecedenteDTO antecedente) {
        this.antecedente = antecedente;
    }

    public BigDecimal getCalcant() {
        return calcant;
    }

    public void setCalcant(BigDecimal calcant) {
        this.calcant = calcant;
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
