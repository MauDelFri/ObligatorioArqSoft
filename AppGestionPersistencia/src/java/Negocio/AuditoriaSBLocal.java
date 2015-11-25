package Negocio;

import DominioDTO.DatoTableroDTO;
import java.util.ArrayList;
import javax.ejb.Local;

@Local
public interface AuditoriaSBLocal {

    void Log(Object claseOrigen, Long usuarioID, String funcionalidad, String obs, Boolean resultado);

    void logArchivo(Object claseOrigen, Long usuarioID, String funcionalidad, String obs, Boolean resultado);

    ArrayList<DatoTableroDTO> ConsultaTablero();
}
