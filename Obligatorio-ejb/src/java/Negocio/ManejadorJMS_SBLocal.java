package Negocio;

import Entidades.Emergencia;
import javax.ejb.Local;

@Local
public interface ManejadorJMS_SBLocal {
    void ProcesarEmergencia(Emergencia emergencia);
}
