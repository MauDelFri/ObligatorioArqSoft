
package Obligatorio.beans;

import Obligatorio.entidades.Ambulancia;
import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class BaseDatos implements BaseDatosLocal {

    private List<Ambulancia> ambulancias;
}
