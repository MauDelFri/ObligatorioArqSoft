package DominioDTO;

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
