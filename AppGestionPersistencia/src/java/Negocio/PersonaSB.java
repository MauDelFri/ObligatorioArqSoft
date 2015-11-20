
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
    public void Crear(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void Editar(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void Eliminar(Persona persona) {
        em.remove(persona); //To change body of generated methods, choose Tools | Templates.
    }
    
}
