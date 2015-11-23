
package Negocio;

import Entidades.Emergencia;
import javax.ejb.Local;

@Local
public interface EmergenciaSBLocal {
    Emergencia Crear(Emergencia emergencia);
    void Editar(Emergencia emergencia);
    void Eliminar(Emergencia emergencia);
}
