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

    
    private Long ambulanciaID;
    private String nombre;
    private short disponible;

    public Long getAmbulanciaID() {
        return ambulanciaID;
    }

    public void setAmbulanciaID(Long ambulanciaID) {
        this.ambulanciaID = ambulanciaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getDisponible() {
        return disponible;
    }

    public void setDisponible(short disponible) {
        this.disponible = disponible;
    }

  
}
