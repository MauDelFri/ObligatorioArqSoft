/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DominioDTO.DatoTableroDTO;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author martinintroini
 */
@Local
public interface AuditoriaSBLocal {

    void Log(Object claseOrigen, Long usuarioID, String funcionalidad, String obs, Boolean resultado);

    void logArchivo(Object claseOrigen, Long usuarioID, String funcionalidad, String obs, Boolean resultado);

    ArrayList<DatoTableroDTO> ConsultaTablero();
}
