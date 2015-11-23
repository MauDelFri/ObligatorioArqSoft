
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
    
    @Override
    public void ProcesarEmergencia(EmergenciaDTO emergencia) {
        
//        double calculo = personaSB.CalculoSeveridad(emergencia.getPersona());
//        emergencia.setCalcperfil(BigDecimal.valueOf(calculo));
        emergencia = emergenciaSB.Crear(emergencia);
        
        ProductorMensajes.ProducirMensaje("Emergencia " + emergencia.getEmergenciaID(), "jms/Topic" + emergencia.getUrgenciaSolicitada());
    }
}
