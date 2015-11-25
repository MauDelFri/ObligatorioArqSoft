package Negocio;

import DominioDTO.PersonaDTO;
import Entidades.Persona;
import java.math.BigDecimal;
import javax.ejb.Local;

@Local
public interface PersonaSBLocal {

    BigDecimal GetPonderacion(PersonaDTO persona);

    Persona GetPersonaDB(long personaID);

    PersonaDTO GetPersonaDTO(long personaID);

}
