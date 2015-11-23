
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
}
