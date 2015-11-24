package Negocio;

import DominioDTO.EmergenciaDTO;
import javax.ejb.Local;

@Local
public interface ManejadorJMS_SBLocal {
    EmergenciaDTO ProcesarEmergencia(EmergenciaDTO emergencia);
}
