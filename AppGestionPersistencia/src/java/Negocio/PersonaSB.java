package Negocio;

import DominioDTO.PersonaDTO;
import Entidades.Persona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonaSB implements PersonaSBLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public Persona GetPersonaDB(long personaID) {
        Persona persona = (Persona) em.createNativeQuery("SELECT * FROM PERSONA WHERE PERSONA_ID=" + personaID, Persona.class).getSingleResult();
        return persona;
    }
    @Override
    public PersonaDTO GetPersonaDTO(long personaID) {
        Persona db = (Persona) em.createNativeQuery("SELECT * FROM PERSONA WHERE PERSONA_ID=" + personaID, Persona.class).getSingleResult();

        PersonaDTO dto = new PersonaDTO();
        dto.setId(db.getPersonaId());
        dto.setNombre(db.getPersonaNombre());
        dto.setApellido(db.getPersonaApellido());
        dto.setCedula(db.getPersonaCedula());
        dto.setFechaNacimiento(db.getPersonaFechanac());
        dto.setGenero(db.getPersonaGenero());
        dto.setPeso(db.getPersonaPeso());
        dto.setAltura(db.getPersonaAltura());
        dto.setIMC(db.getPersonaImc());
        
        return dto;

    }

    @Override
    public int CalculoSeveridad(PersonaDTO persona) {
        return 1;
    }

    
}
