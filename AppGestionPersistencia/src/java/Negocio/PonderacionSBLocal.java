/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import javax.ejb.Local;

/**
 *
 * @author martinintroini
 */
@Local
public interface PonderacionSBLocal {
    void PonderacionEdad(Long personaID);
    void PonderacionIMC(Long personaID);
}