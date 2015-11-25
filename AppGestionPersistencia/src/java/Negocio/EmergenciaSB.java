package Negocio;

import DominioDTO.*;
import Entidades.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmergenciaSB implements EmergenciaSBLocal {

    @EJB
    PersonaSBLocal personasBean;

    @EJB
    AmbulanciaSBLocal ambulanciasBean;

    @PersistenceContext
    EntityManager em;

    @Override
    public Emergencia Crear2(Emergencia db) {
        em.persist(db);
        return db;
    }

    @Override
    public EmergenciaDTO Crear(EmergenciaDTO emergenciaDTO) {
        Emergencia db = new Emergencia();

        Persona p = personasBean.GetPersonaDB(emergenciaDTO.getPersona().getId());
        db.setEmergenciaPersonaid(p);

        db.setEmergenciaCalcperfil(emergenciaDTO.getCalcperfil());
        db.setEmergenciaUrgenciasolicitada(emergenciaDTO.getUrgenciaResuelta());
        db.setEmergenciaObs(emergenciaDTO.getObservaciones());
        db.setEmergenciaFechasolicitada(emergenciaDTO.getFechaSolicitada());
        db.setEmergenciaFechahoraresuelta(emergenciaDTO.getFechaResuelta());
        db.setEmergenciaUrgenciaresuelta(emergenciaDTO.getUrgenciaResuelta());

        em.persist(db);
        emergenciaDTO.setEmergenciaID(db.getEmergenciaId().intValue());

        return emergenciaDTO;
    }

    @Override
    public void Editar(EmergenciaDTO emergenciaDTO) {
        Emergencia db = new Emergencia();
        db.setEmergenciaId((long) emergenciaDTO.getEmergenciaID());
        Persona p = personasBean.GetPersonaDB(emergenciaDTO.getPersona().getId());
        db.setEmergenciaPersonaid(p);
        Ambulancia a = ambulanciasBean.GetAmbulanciaDB(emergenciaDTO.getAmbulancia().getAmbulanciaID());
        db.setEmergenciaAmbulanciaid(a);

        db.setEmergenciaCalcperfil(emergenciaDTO.getCalcperfil());
        db.setEmergenciaUrgenciasolicitada(emergenciaDTO.getUrgenciaResuelta());
        db.setEmergenciaObs(emergenciaDTO.getObservaciones());
        db.setEmergenciaFechasolicitada(emergenciaDTO.getFechaSolicitada());
        db.setEmergenciaFechahoraresuelta(emergenciaDTO.getFechaResuelta());
        db.setEmergenciaUrgenciaresuelta(emergenciaDTO.getUrgenciaResuelta());
        em.merge(db);
    }

    @Override
    public void Eliminar(EmergenciaDTO emergencia) {
        em.remove(emergencia);
    }

    @Override
    public EmergenciaDTO GetEmergenciaDTO(long emergenciaID) {
        Emergencia db = this.GetEmergenciaDB(emergenciaID);

        EmergenciaDTO dto = new EmergenciaDTO();
        dto.setEmergenciaID(db.getEmergenciaId().intValue());
        dto.setCalcperfil(db.getEmergenciaCalcperfil());
        dto.setFechaSolicitada(db.getEmergenciaFechasolicitada());
        dto.setPersona(personasBean.GetPersonaDTO(db.getEmergenciaPersonaid().getPersonaId()));
        dto.setUrgenciaSolicitada(db.getEmergenciaUrgenciasolicitada());
        if (db.getEmergenciaAmbulanciaid() != null) {
            dto.setAmbulancia(ambulanciasBean.GetAmbulanciaDTO(db.getEmergenciaAmbulanciaid().getAmbulanciaId()));
        }
        
        return dto;
    }

    @Override
    public Emergencia GetEmergenciaDB(long emergenciaID) {
        Emergencia emergencia = (Emergencia) em.createNativeQuery("SELECT * FROM EMERGENCIA WHERE EMERGENCIA_ID=" + emergenciaID, Emergencia.class).getSingleResult();
        return emergencia;
    }
}
