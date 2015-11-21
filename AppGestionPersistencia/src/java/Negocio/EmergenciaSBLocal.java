
package Negocio;

import Entidades.Emergencia;
import javax.ejb.Local;

@Local
public interface EmergenciaSBLocal {
    void Crear(Emergencia emergencia);
    void Editar(Emergencia emergencia);
    void Eliminar(Emergencia emergencia);
}
