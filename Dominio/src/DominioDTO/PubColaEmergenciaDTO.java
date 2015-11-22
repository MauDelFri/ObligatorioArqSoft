/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

/**
 *
 * @author martinintroini
 */
public class PubColaEmergenciaDTO {
    private int pubColaEmergenciaID;
    private EmergenciaDTO emergencia;

    public int getPubColaEmergenciaID() {
        return pubColaEmergenciaID;
    }

    public void setPubColaEmergenciaID(int pubColaEmergenciaID) {
        this.pubColaEmergenciaID = pubColaEmergenciaID;
    }

    public EmergenciaDTO getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(EmergenciaDTO emergencia) {
        this.emergencia = emergencia;
    }
}
