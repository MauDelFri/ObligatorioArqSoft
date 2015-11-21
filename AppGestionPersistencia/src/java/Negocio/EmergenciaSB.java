
package Negocio;

import Entidades.Emergencia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmergenciaSB implements EmergenciaSBLocal {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public void Crear(Emergencia emergencia) {
        em.persist(emergencia);
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
