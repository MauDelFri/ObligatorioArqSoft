package Negocio;

import DominioDTO.AmbulanciaDTO;
import Entidades.Ambulancia;
import javax.ejb.Local;

@Local
public interface AmbulanciaSBLocal {

    AmbulanciaDTO GetAmbulanciaDTO(long ambulanciaID);

    Ambulancia GetAmbulanciaDB(long ambulanciaID);

    int[] GetColasAmbulancia(long ambulanciaID);
}
