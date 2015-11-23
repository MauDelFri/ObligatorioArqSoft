package Negocio;

import DominioDTO.PersonaDTO;
import Entidades.Persona;
import javax.ejb.Local;

@Local
public interface PersonaSBLocal {
    Persona GetPersona(long personaID);
    
    int CalculoSeveridad(Persona persona);

    Persona GetPersonaDB(long personaID);
    PersonaDTO GetPersonaDTO(long personaID);

}
