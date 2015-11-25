package ServletListener;

import Negocio.AuditoriaSBLocal;
import Negocio.ColaEmergenciaSBLocal;
import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener {

    @EJB
    AuditoriaSBLocal auditoriaBean;

    @EJB
    ColaEmergenciaSBLocal colaEmergenciaSB;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Long l = new Long("999");
        auditoriaBean.Log(this, l, "contextInitialized", "Inicio del Servidor", true);
        try {
            ServerStateListener ssl = new ServerStateListener(auditoriaBean);
            EmergenciasStateListener esl = new EmergenciasStateListener(auditoriaBean, colaEmergenciaSB);
            new Thread(ssl).start();
            new Thread(esl).start();
        } catch (Exception e) {
            System.err.println("entro al error");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Long l = new Long("999");
        auditoriaBean.Log(this, l, "contextDestroyed", "Fin del Servidor", true);
        ServerStateListener.ejecutando = false;
        EmergenciasStateListener.ejecutando = false;
    }

}
