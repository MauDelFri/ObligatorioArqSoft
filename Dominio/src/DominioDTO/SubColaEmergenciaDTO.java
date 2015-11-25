package DominioDTO;

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
