package Negocio;

import DominioDTO.PersonaDTO;
import Entidades.Persona;
import javax.ejb.Local;

@Local
public interface PersonaSBLocal {
    
    int CalculoSeveridad(PersonaDTO persona);
    Persona GetPersonaDB(long personaID);
    PersonaDTO GetPersonaDTO(long personaID);

}
