
package Negocio;

import DominioDTO.EmergenciaDTO;
import Entidades.Emergencia;
import javax.ejb.Local;

@Local
public interface EmergenciaSBLocal {
    void Crear2(Emergencia db);
    void Crear(EmergenciaDTO emergencia);
    void Editar(EmergenciaDTO emergencia);
    void Eliminar(EmergenciaDTO emergencia);
    Emergencia Crear(Emergencia emergencia);
    void Editar(Emergencia emergencia);
    void Eliminar(Emergencia emergencia);
}
