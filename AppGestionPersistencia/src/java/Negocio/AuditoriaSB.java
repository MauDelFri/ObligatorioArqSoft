/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidades.Auditoria;
import javax.ejb.Stateless;
import java.net.URL;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        logArchivo(claseOrigen, usuarioID, funcionalidad);
        logBBDD(claseOrigen, usuarioID, funcionalidad, obs, resultado);
        
    }

    private void logArchivo(Object claseOrigen, Long usuarioID, String funcionalidad) {
        Logger logger2 = Logger.getLogger(claseOrigen.getClass());
        URL url = AuditoriaSB.class.getResource("Log4j.properties");
        PropertyConfigurator.configure(url);
        logger2.info("Usuario: " + usuarioID +" Funcoinalidad: "+claseOrigen.getClass()+"."+funcionalidad);
    }

    private void logBBDD(Object claseOrigen, Long usuarioID, String funcionalidad, String obs, Boolean resultado) {
        
        Auditoria a = new Auditoria();
        a.setAuditoriaFecha(new Date());
        a.setAuditoriaFuncionalidad(claseOrigen.getClass()+"."+funcionalidad);
        a.setAuditoriaObservaciones(obs);
        if(resultado)
            a.setAuditoriaResultado("T");
        a.setAuditoriaUsuario(usuarioID);
        em.persist(a);
        
        
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
