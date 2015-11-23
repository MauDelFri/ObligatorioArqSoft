package Negocio;

import DominioDTO.*;
import Entidades.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Stateless
public class EmergenciaSB implements EmergenciaSBLocal {

    @EJB
    PersonaSBLocal personasBean;

    @EJB
    AmbulanciaSBLocal ambulanciasBean;

    @PersistenceContext
    EntityManager em;

    
    @Override
    public void Crear2(Emergencia db) {
        em.persist(db);
    }
    
    @Override
    public void Crear(EmergenciaDTO emergenciaDTO) {
        Emergencia db = new Emergencia();

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
        
        em.persist(db);
    }
//
//    @Override
//    public void Crear(Emergencia emergencia) {
//        em.persist(emergencia);
//    }

    @Override
    public void Editar(EmergenciaDTO emergencia) {
        em.merge(emergencia);
    }

    @Override
    public void Eliminar(EmergenciaDTO emergencia) {
        em.remove(emergencia);
    }
}
