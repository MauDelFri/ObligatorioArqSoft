
package Negocio;

import DominioDTO.EmergenciaDTO;
import Entidades.Emergencia;
import javax.ejb.Local;

@Local
public interface EmergenciaSBLocal {
    Emergencia Crear2(Emergencia db);
    EmergenciaDTO Crear(EmergenciaDTO emergencia);
    void Editar(EmergenciaDTO emergencia);
    void Eliminar(EmergenciaDTO emergencia);
    EmergenciaDTO GetEmergenciaDTO(long emergenciaID);
    Emergencia GetEmergenciaDB(long emergenciaID);
}
