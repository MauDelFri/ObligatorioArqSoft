package ServletListener;

import Entidades.Emergencia;
import JMS.ProductorMensajes;
import Negocio.AuditoriaSBLocal;
import Negocio.ColaEmergenciaSBLocal;
import java.math.RoundingMode;
import java.util.List;
import javax.ejb.EJB;

public class EmergenciasStateListener implements Runnable {

    public static boolean ejecutando = false;

    @EJB
    private static AuditoriaSBLocal aSessionBean;

    @EJB
    private static ColaEmergenciaSBLocal ColaEmergenciaSB;

    EmergenciasStateListener(AuditoriaSBLocal x, ColaEmergenciaSBLocal colaSB) {
        aSessionBean = x;
        ColaEmergenciaSB = colaSB;
    }

    @Override
    public void run() {
        Long l = new Long("999");
        this.ejecutando = true;
        while (ejecutando) {
            try {
                Thread.sleep(new Long("5000"));
                try {
                    List<Emergencia> emergencias = ColaEmergenciaSB.ObtenerEmergenciasSinAtender();
                    for (Emergencia emergencia : emergencias) {
                        ProductorMensajes.ProducirMensaje("Emergencia " + emergencia.getEmergenciaId(), "jms/Topic"
                                + emergencia.getEmergenciaCalcperfil().setScale(0, RoundingMode.CEILING).intValue());

                        aSessionBean.Log(this, l, "run", "Producir nuevamente emergencias no atendidas", true);
                        System.out.println("Producir mensaje para emergencia " + emergencia.getEmergenciaId());
                    }
                } catch (Exception e) {
                    System.err.println("entro al exception e");
                    try {
                        //logueo exception
                        aSessionBean.logArchivo(this, l, "run", e.getMessage(), false);
                    } catch (Exception ee) {
                        System.err.println("entro a exception en exception e");
                    }
                }
            } catch (Exception ex) {
                System.err.println("entro al exception ex");
                // ejecutando = false;
            }
        }
    }
}
