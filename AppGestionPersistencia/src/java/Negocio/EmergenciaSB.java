
package Negocio;

import Entidades.Emergencia;
import java.util.Iterator;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Stateless
public class EmergenciaSB implements EmergenciaSBLocal {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public Emergencia Crear(Emergencia emergencia) {
        try{
            em.persist(emergencia);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return emergencia;
    }

    @Override
    public void Editar(Emergencia emergencia) {
        em.merge(emergencia);
    }

    @Override
    public void Eliminar(Emergencia emergencia) {
        em.remove(emergencia);
    }
}
