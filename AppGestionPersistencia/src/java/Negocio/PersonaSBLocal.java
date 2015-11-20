
package Negocio;

import Entidades.Persona;
import javax.ejb.Local;

@Local
public interface PersonaSBLocal {
    public void Crear(Persona persona);
    public void Editar(Persona persona);
    public void Eliminar(Persona persona);
}
