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
public class SubColaEmergenciaDTO {
    private int subColaEmergenciaID;
    private AmbulanciaDTO ambulancia;

    public int getSubColaEmergenciaID() {
        return subColaEmergenciaID;
    }

    public void setSubColaEmergenciaID(int subColaEmergenciaID) {
        this.subColaEmergenciaID = subColaEmergenciaID;
    }

    public AmbulanciaDTO getAmbulancia() {
        return ambulancia;
    }

    public void setAmbulancia(AmbulanciaDTO ambulancia) {
        this.ambulancia = ambulancia;
    }
}
