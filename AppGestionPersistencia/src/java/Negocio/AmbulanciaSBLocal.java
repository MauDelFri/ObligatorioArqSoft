
package Negocio;

import Entidades.Ambulancia;
import javax.ejb.Local;

@Local
public interface AmbulanciaSBLocal {
    Ambulancia GetAmbulancia(long AmbulanciaID);
}
