/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DominioDTO.PersonaAntecedentePonderacionDTO;
import Entidades.Personaantecedenteponderacion;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author martinintroini
 */
@Stateless
public class PersonaAntecedentePonderacionSB implements PersonaAntecedentePonderacionSBLocal {

    @PersistenceContext
    EntityManager em;

    @EJB
    AntecedenteSBLocal antecedentesBean;

    @EJB
    PersonaSBLocal personasBean;

    @Override
    public ArrayList<PersonaAntecedentePonderacionDTO> getPonderacionesPersona(Long personaID) {
        ArrayList<PersonaAntecedentePonderacionDTO> paps = new ArrayList<PersonaAntecedentePonderacionDTO>();
        List pap = em.createNativeQuery("SELECT * FROM Personaantecedenteponderacion WHERE PAP_PERSONAID=" + personaID, Personaantecedenteponderacion.class).getResultList();

        Iterator d = pap.iterator();
        while (d.hasNext()) {
            Personaantecedenteponderacion actual = (Personaantecedenteponderacion) d.next();
            Date hoy = new Date();
            Date hasta = actual.getPapFechavighasta();
            Date desde = actual.getPersonaantecedenteponderacionPK().getPapFechavigdesde();

            if (hasta == null && desde.before(hoy)) {
                PersonaAntecedentePonderacionDTO dto = new PersonaAntecedentePonderacionDTO();
                dto.setPersona(personasBean.GetPersonaDTO(actual.getPersona().getPersonaId()));
                dto.setAntecedente(antecedentesBean.getAntecedenteDTO(actual.getAntecedente().getAntecedenteId()));
                dto.setCalcant(actual.getPapCalcant());
                dto.setFechaVigDesde(desde);
                dto.setFechaVigHasta(hasta);
                paps.add(dto);
            }

        }

        return paps;
    }
}
