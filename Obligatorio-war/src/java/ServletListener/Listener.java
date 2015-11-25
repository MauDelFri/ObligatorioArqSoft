/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletListener;

import Negocio.AuditoriaSBLocal;
import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author martinintroini
 */
public class Listener implements ServletContextListener {
//ServletListener.Listener

    @EJB
    AuditoriaSBLocal auditoriaBean;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Long l = new Long("999");
        auditoriaBean.Log(this, l, "contextInitialized","Inicio del Servidor", true);
        try {
            ServerStateListener ssl = new ServerStateListener(auditoriaBean);
            new Thread(ssl).start();
        } catch (Exception e) {
            System.err.println("entro al error");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Long l = new Long("999");
        auditoriaBean.Log(this, l, "contextDestroyed", "Fin del Servidor", true);
        ServerStateListener.ejecutando = false;
    }

}
