
package Negocio;

import Entidades.Persona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonaSB implements PersonaSBLocal {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public Persona GetPersona(long personaID) {
        Persona persona = (Persona)em.createNativeQuery("SELECT * FROM PERSONA WHERE PERSONA_ID=" + personaID, Persona.class).getSingleResult();
        return persona;
    }

    @Override
    public int CalculoSeveridad(Persona persona) {
        return 1;
    }

    
}
