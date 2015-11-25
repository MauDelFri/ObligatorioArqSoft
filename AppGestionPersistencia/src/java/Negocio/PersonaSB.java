package Negocio;

import DominioDTO.PersonaAntecedentePonderacionDTO;
import DominioDTO.PersonaDTO;
import Entidades.*;
import java.math.BigDecimal;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonaSB implements PersonaSBLocal {

    @PersistenceContext
    EntityManager em;

    @EJB
    PersonaAntecedentePonderacionSBLocal papsBean;

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
    public BigDecimal GetPonderacion(PersonaDTO persona) {
        Iterator it = papsBean.getPonderacionesPersona(persona.getId()).iterator();
        BigDecimal pond = BigDecimal.ZERO;
        BigDecimal dato;
        while (it.hasNext()) {
            PersonaAntecedentePonderacionDTO acutal = (PersonaAntecedentePonderacionDTO) it.next();
            dato = acutal.getCalcant();
            if (pond.compareTo(acutal.getCalcant()) == -1) {
                pond = acutal.getCalcant();
            }
        }

        return pond;
    }

}
