package Obligatorio.entidades;

import java.util.Set;

public class Ambulancia {
    private int ambulanciaID;
    private String nombre;
    private String descripcion;
    private Set<JMS> colas;

    public Ambulancia() {
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
