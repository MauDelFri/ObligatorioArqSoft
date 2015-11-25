package Negocio;

import javax.ejb.Local;

@Local
public interface PonderacionSBLocal {

    void PonderacionEdad(Long personaID);

    void PonderacionIMC(Long personaID);
}
