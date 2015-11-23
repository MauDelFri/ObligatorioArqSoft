
package Negocio;

import DominioDTO.AmbulanciaDTO;
import Entidades.Ambulancia;
import javax.ejb.Local;

@Local
public interface AmbulanciaSBLocal {
    AmbulanciaDTO GetAmbulanciaDTO(long AmbulanciaID);
    Ambulancia GetAmbulanciaDB(long AmbulanciaID);

}
