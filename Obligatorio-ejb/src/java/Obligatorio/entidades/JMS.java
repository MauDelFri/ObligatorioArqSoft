package Obligatorio.entidades;

import java.util.Set;

public class JMS {
    private int jmsID;
    private String nombre;
    private String descripcion;
    private Set<Ambulancia> ambulancias;
    private Set<Incidencia> incidencias;

    public JMS() {
    }

    public Set<Ambulancia> getAmbulancias() {
        return ambulancias;
    }

    public void setAmbulancias(Set<Ambulancia> ambulancias) {
        this.ambulancias = ambulancias;
    }

    public Set<Incidencia> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(Set<Incidencia> incidencias) {
        this.incidencias = incidencias;
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
    
    public void AgregarIncidencia(Incidencia nuevaIncidencia){
        this.incidencias.add(nuevaIncidencia);
    }
    
    public void EliminarIncidencia(Incidencia incidencia){
        this.incidencias.remove(incidencia);
    }
}
