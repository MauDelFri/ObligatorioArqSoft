
package Negocio;

import DominioDTO.EmergenciaDTO;
import Entidades.Colaemergencia;
import Entidades.Emergencia;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ColaEmergenciaSB implements ColaEmergenciaSBLocal {

    @PersistenceContext
    EntityManager em;
    
    @EJB
    EmergenciaSBLocal emergenciaSB;

    @Override
    public Colaemergencia GetColaEmergeciaDB(long colaEmergenciaID) {
        Colaemergencia cola = (Colaemergencia)em.createNativeQuery("SELECT * FROM COLAEMERGENCIA WHERE COLAEMERGENCIA_ID=" + colaEmergenciaID, Colaemergencia.class).getSingleResult();
        return cola;
    }  
    
    @Override
    public void AgregarEmergencia(EmergenciaDTO emergenciaDTO, long colaEmergenciaID) {
        Emergencia emergencia = emergenciaSB.GetEmergenciaDB(emergenciaDTO.getEmergenciaID());
        Colaemergencia cola = GetColaEmergeciaDB(colaEmergenciaID);
        cola.getEmergenciaList().add(emergencia);
        em.merge(cola);
    }

    @Override
    public void RemoverEmergencia(EmergenciaDTO emergenciaDTO, long colaEmergenciaID) {
        Emergencia emergencia = emergenciaSB.GetEmergenciaDB(emergenciaDTO.getEmergenciaID());
        Colaemergencia cola = GetColaEmergeciaDB(colaEmergenciaID);
        cola.getEmergenciaList().remove(emergencia);
        em.merge(cola);
    }
}
