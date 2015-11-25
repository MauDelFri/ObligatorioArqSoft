package Negocio;

import DominioDTO.EmergenciaDTO;
import Entidades.Colaemergencia;
import Entidades.Emergencia;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ColaEmergenciaSBLocal {

    Colaemergencia GetColaEmergeciaDB(long colaEmergenciaID);

    void AgregarEmergencia(EmergenciaDTO emergencia, long colaEmergenciaID);

    void RemoverEmergencia(EmergenciaDTO emergencia, long colaEmergenciaID);

    List<Emergencia> ObtenerEmergenciasSinAtender();
}
