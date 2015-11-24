
package Negocio;

import DominioDTO.EmergenciaDTO;
import Entidades.Colaemergencia;
import javax.ejb.Local;

@Local
public interface ColaEmergenciaSBLocal {
    
    Colaemergencia GetColaEmergeciaDB(long colaEmergenciaID);
    void AgregarEmergencia(EmergenciaDTO emergencia, long colaEmergenciaID);
    void RemoverEmergencia(EmergenciaDTO emergencia, long colaEmergenciaID);
}
