
package Negocio;

import Entidades.Ambulancia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AmbulanciaSB implements AmbulanciaSBLocal {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public Ambulancia GetAmbulancia(long ambulanciaID) {
        Ambulancia ambulancia = (Ambulancia)em.createNativeQuery("SELECT * FROM AMBULANCIA WHERE AMBULANCIA_ID=" + ambulanciaID, Ambulancia.class).getSingleResult();
        return ambulancia;
    }

    
}
