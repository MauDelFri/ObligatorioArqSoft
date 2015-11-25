/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DominioDTO.DatoTableroDTO;
import Entidades.Auditoria;
import javax.ejb.Stateless;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author martinintroini
 */
@Stateless
public class AuditoriaSB implements AuditoriaSBLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public void Log(Object claseOrigen, Long usuarioID, String funcionalidad, String obs, Boolean resultado) {
        logArchivo(claseOrigen, usuarioID, funcionalidad, obs, resultado);
        logBBDD(claseOrigen, usuarioID, funcionalidad, obs, resultado);

    }

    @Override
    public void logArchivo(Object claseOrigen, Long usuarioID, String funcionalidad, String obs, Boolean resultado) {
        Logger logger2 = Logger.getLogger(claseOrigen.getClass());
        URL url = AuditoriaSB.class.getResource("Log4j.properties");
        PropertyConfigurator.configure(url);
        if (resultado) {
            logger2.info("Usuario: " + usuarioID + " Funcoinalidad OK: " + claseOrigen.getClass() + "." + funcionalidad);
        } else {
            logger2.info("Usuario: " + usuarioID + " Funcoinalidad ERROR: " + claseOrigen.getClass() + "." + funcionalidad);
        }
    }

    private void logBBDD(Object claseOrigen, Long usuarioID, String funcionalidad, String obs, Boolean resultado) {

        try {
            Auditoria a = new Auditoria();
            a.setAuditoriaFecha(new Date());
            a.setAuditoriaFuncionalidad(claseOrigen.getClass() + "." + funcionalidad);
            a.setAuditoriaObservaciones(obs);
            if (resultado) {
                a.setAuditoriaResultado("T");
            }
            a.setAuditoriaUsuario(usuarioID);
            em.persist(a);
        } catch (Exception e) {
            System.out.println("no pudo log en bd");
            logArchivo(claseOrigen, usuarioID, funcionalidad, e.getMessage(), false);
        }

    }

    @Override
    public ArrayList<DatoTableroDTO> ConsultaTablero() {

        String totalDeEmergencias = "Select count(*) from emergencia";
        String emergenciasAsignadasNoResueltas = "Select count(*) from emergencia em where em.emergencia_ambulanciaid is not null and em.emergencia_urgenciaresuelta is null";
        String emergenciasResueltas = "Select count(*) from emergencia em where em.emergencia_fechahoraresuelta is not null";
        String emergenciasSinAsignarSinResolver = "Select count(*) from emergencia em where em.emergencia_ambulanciaid is null";

        Query q1 = em.createNativeQuery(totalDeEmergencias);
        Query q2 = em.createNativeQuery(emergenciasAsignadasNoResueltas);
        Query q3 = em.createNativeQuery(emergenciasResueltas);
        Query q4 = em.createNativeQuery(emergenciasSinAsignarSinResolver);

        String resTotalDeEmergencias = q1.getResultList().get(0).toString();
        String resEmergenciasAsignadasNoResueltas = q2.getResultList().get(0).toString();
        String resEmergenciasResueltas = q3.getResultList().get(0).toString();
        String resEmergenciasSinAsignarSinResolver = q4.getResultList().get(0).toString();

        ArrayList<DatoTableroDTO> listaRet = new ArrayList<DatoTableroDTO>();
        listaRet.add(new DatoTableroDTO("TotalDeEmergencias", resTotalDeEmergencias));
        listaRet.add(new DatoTableroDTO("EmergenciasAsignadasNoResueltas", resEmergenciasAsignadasNoResueltas));
        listaRet.add(new DatoTableroDTO("EmergenciasResueltas", resEmergenciasResueltas));
        listaRet.add(new DatoTableroDTO(emergenciasSinAsignarSinResolver, resEmergenciasSinAsignarSinResolver));

        return listaRet;
    }

}
/*
 static Logger logger = Logger.getLogger(Pruebalog2.class);
    
 public static void main(String[] args) {
 // TODO code application logic here
 URL url = Pruebalog2.class.getResource("Log4j.properties");
 PropertyConfigurator.configure(url);
 logger.info("Entrando a la Aplicacion");
 System.out.println("Mensaje por Consola");
 logger.info("Saliendo de la Aplicacion");
 }
 */
