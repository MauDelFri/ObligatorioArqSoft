package Negocio;

import DominioDTO.AntecedenteDTO;
import Entidades.Antecedente;
import javax.ejb.Local;

@Local
public interface AntecedenteSBLocal {

    AntecedenteDTO getAntecedenteDTO(Long antecedenteID);

    Antecedente getAntecedenteDB(Long antecedenteID);

}
