package DominioDTO;

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
