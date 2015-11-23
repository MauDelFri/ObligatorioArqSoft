
package Negocio;

import Entidades.Emergencia;
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
    public void ProcesarEmergencia(Emergencia emergencia) {
        double calculo = personaSB.CalculoSeveridad(emergencia.getEmergenciaPersonaid());
        emergencia.setEmergenciaCalcperfil(BigDecimal.valueOf(calculo));
        emergencia = emergenciaSB.Crear(emergencia);
        
        ProductorMensajes.ProducirMensaje("Emergencia " + emergencia.getEmergenciaId(), "jms/Topic" + emergencia.getEmergenciaUrgenciasolicitada());
    }
}
