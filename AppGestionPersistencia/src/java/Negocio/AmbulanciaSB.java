
package Negocio;

import DominioDTO.AmbulanciaDTO;
import Entidades.Ambulancia;
import Entidades.Colaemergencia;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AmbulanciaSB implements AmbulanciaSBLocal {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public AmbulanciaDTO GetAmbulanciaDTO(long ambulanciaID) {
        Ambulancia db = this.GetAmbulanciaDB(ambulanciaID);
        
        AmbulanciaDTO dto = new AmbulanciaDTO();
        dto.setAmbulanciaID(db.getAmbulanciaId());
        dto.setDisponible(db.getAmbulanciaDisponible());
        dto.setNombre(db.getAmbulanciaNombre());
        
        return dto;
    }
    
    
    @Override
    public Ambulancia GetAmbulanciaDB(long ambulanciaID) {
        Ambulancia ambulancia = (Ambulancia)em.createNativeQuery("SELECT * FROM AMBULANCIA WHERE AMBULANCIA_ID=" + ambulanciaID, Ambulancia.class).getSingleResult();
        return ambulancia;
    }

    @Override
    public int[] GetColasAmbulancia(long ambulanciaID) {
        Ambulancia ambulancia = GetAmbulanciaDB(ambulanciaID);
        Iterator colasIterator = ambulancia.getColaemergenciaList().iterator();
        
        int pos = 0;
        int[] colas = new int[ambulancia.getColaemergenciaList().size()];
        while(colasIterator.hasNext()){
            colas[pos] = ((Colaemergencia)colasIterator.next()).getColaemergenciaId().intValue();
            pos ++;
        }
        return colas;
    }

    
}
