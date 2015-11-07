package Obligatorio.entidades;

import java.util.Set;

public class JMS {
    private int jmsID;
    private String nombre;
    private String descripcion;
    private Set<Ambulancia> ambulancias;
    private Set<Emergencia> emergencias;

    public JMS() {
    }

    public Set<Ambulancia> getAmbulancias() {
        return ambulancias;
    }

    public void setAmbulancias(Set<Ambulancia> ambulancias) {
        this.ambulancias = ambulancias;
    }

    public Set<Emergencia> getEmergencias() {
        return emergencias;
    }

    public void setEmergencias(Set<Emergencia> emergencias) {
        this.emergencias = emergencias;
    }

    public int getJmsID() {
        return jmsID;
    }

    public void setJmsID(int jmsID) {
        this.jmsID = jmsID;
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
    
    public void AgregarAmbulancia(Ambulancia nuevaAmbulancia){
        this.ambulancias.add(nuevaAmbulancia);
    }
    
    public void EliminarAmbulancia(Ambulancia ambulancia){
        this.ambulancias.remove(ambulancia);
    }
    
    public void AgregarIncidencia(Emergencia nuevaIncidencia){
        this.emergencias.add(nuevaIncidencia);
    }
    
    public void EliminarIncidencia(Emergencia incidencia){
        this.emergencias.remove(incidencia);
    }
}
