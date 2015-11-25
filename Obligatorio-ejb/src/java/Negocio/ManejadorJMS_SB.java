package Negocio;

import DominioDTO.EmergenciaDTO;
import JMS.ProductorMensajes;
import java.math.RoundingMode;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ManejadorJMS_SB implements ManejadorJMS_SBLocal {

    @EJB
    PersonaSBLocal personaSB;

    @EJB
    EmergenciaSBLocal emergenciaSB;

    @EJB
    ColaEmergenciaSBLocal colaEmergenciaSB;

    @Override
    public EmergenciaDTO ProcesarEmergencia(EmergenciaDTO emergencia) {
        emergencia = emergenciaSB.Crear(emergencia);
        colaEmergenciaSB.AgregarEmergencia(emergencia, emergencia.getUrgenciaSolicitada());

        ProductorMensajes.ProducirMensaje("Emergencia " + emergencia.getEmergenciaID(), "jms/Topic" + emergencia.getCalcperfil().setScale(0, RoundingMode.CEILING).intValue());
        return emergencia;
    }
}
