
package Obligatorio.beans;

import Obligatorio.entidades.Emergencia;
import java.sql.Connection;
import javax.ejb.Local;

@Local
public interface AccesoDatosLocal {
    public Connection getConexion();

    public void setConexion(Connection conexion);
    
    public AccesoDatos Conectar();
    
    public void AltaEmergencia(Emergencia nuevaEmergencia);
}
