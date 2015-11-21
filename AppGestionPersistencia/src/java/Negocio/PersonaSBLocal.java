
package Negocio;

import Entidades.Persona;
import javax.ejb.Local;

@Local
public interface PersonaSBLocal {
    Persona GetPersona(long personaID);
}
