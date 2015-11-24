
package Negocio;

import DominioDTO.EmergenciaDTO;
import JMS.ProductorMensajes;
import java.math.BigDecimal;
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
        double calculo = personaSB.CalculoSeveridad(emergencia.getPersona());
        emergencia.setCalcperfil(BigDecimal.valueOf(calculo));
        emergencia = emergenciaSB.Crear(emergencia);
        
        colaEmergenciaSB.AgregarEmergencia(emergencia, emergencia.getUrgenciaSolicitada());
        
        ProductorMensajes.ProducirMensaje("Emergencia " + emergencia.getEmergenciaID(), "jms/Topic" + emergencia.getUrgenciaSolicitada());
        return emergencia;
    }
}
