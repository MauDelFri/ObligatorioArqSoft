package Negocio;

import DominioDTO.PersonaAntecedentePonderacionDTO;
import java.util.ArrayList;
import javax.ejb.Local;

@Local
public interface PersonaAntecedentePonderacionSBLocal {

    ArrayList<PersonaAntecedentePonderacionDTO> getPonderacionesPersona(Long personaID);
}
