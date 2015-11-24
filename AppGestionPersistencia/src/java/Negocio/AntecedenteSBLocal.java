/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DominioDTO.AntecedenteDTO;
import Entidades.Antecedente;
import javax.ejb.Local;

/**
 *
 * @author martinintroini
 */
@Local
public interface AntecedenteSBLocal {


    AntecedenteDTO getAntecedenteDTO(Long antecedenteID);

    Antecedente getAntecedenteDB(Long antecedenteID);

}
