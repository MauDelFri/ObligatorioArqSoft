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
public class AmbulanciaDTO {

    public int getAmbulanciaID() {
        return ambulanciaID;
    }

    public void setAmbulanciaID(int ambulanciaID) {
        this.ambulanciaID = ambulanciaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
    private int ambulanciaID;
    private String nombre;
    private Boolean disponible;
}
