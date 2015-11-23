/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DominioDTO.AntecedenteDTO;
import Entidades.Antecedente;   
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author martinintroini
 */
@Stateless
public class AntecedenteSB implements AntecedenteSBLocal {

    @PersistenceContext
    EntityManager em;
       



    @Override
    public AntecedenteDTO getAntecedenteDTO(Long antecedenteID) {
        Antecedente db = this.getAntecedenteDB(antecedenteID);
        AntecedenteDTO dto = new AntecedenteDTO();
        
        dto.setAntecedenteID(db.getAntecedenteId());
        dto.setFactorRiesgoAlto(db.getAntecedenteFactorriesgoalto());
        dto.setFactorRiesgoBajo(db.getAntecedenteFactorriesgobajo());
        dto.setFactorRiesgoMedio(db.getAntecedenteFactorriesgomedio());
        dto.setNombre(db.getAntecedenteNombre());
        
        return dto;
    }

    @Override
    public Antecedente getAntecedenteDB(Long antecedenteID) {
        Antecedente db = (Antecedente) em.createNativeQuery("SELECT * FROM ANTECEDENTE WHERE ANTECEDENTE_ID=" + antecedenteID, Antecedente.class).getSingleResult();
        return db;
    }

  
}
