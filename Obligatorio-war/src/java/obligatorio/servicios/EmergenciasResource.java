package obligatorio.servicios;

import DominioDTO.AmbulanciaDTO;
import DominioDTO.EmergenciaDTO;
import DominioDTO.PersonaDTO;
import Negocio.AmbulanciaSBLocal;
import Negocio.AuditoriaSBLocal;
import Negocio.EmergenciaSBLocal;
import Negocio.ManejadorJMS_SBLocal;
import Negocio.PersonaSBLocal;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("emergencias")
@RequestScoped
public class EmergenciasResource {

    @Context
    private UriInfo context;

    @EJB
    PersonaSBLocal personasBean;

    @EJB
    AmbulanciaSBLocal ambulanciasBean;

    @EJB
    ManejadorJMS_SBLocal manejadorJMSBean;

    @EJB
    AuditoriaSBLocal auditoriasBean;
    
    @EJB
    EmergenciaSBLocal emergenciasBean;
    
    public EmergenciasResource() {
    }

    @POST
    @Path("/nuevaEmergencia")
    @Consumes("application/x-www-form-urlencoded")
    public Response NuevaEmergencia(@FormParam("idPersona") long personaID,
                                    @FormParam("urgenciaSolicitada") long urgenciaSolicitada) {
        
        
       
        
        
        auditoriasBean.Log(this,personaID, "NuevaEmergencia", "Comienza Transaccion", true);
        
        
        PersonaDTO persona = personasBean.GetPersonaDTO(personaID);

        EmergenciaDTO emergencia = new EmergenciaDTO();
        emergencia.setPersona(persona);
        emergencia.setFechaSolicitada(new Date());
        emergencia.setUrgenciaSolicitada(Short.parseShort("1"));
        emergencia.setCalcperfil(personasBean.GetPonderacion(persona));

        manejadorJMSBean.ProcesarEmergencia(emergencia);
        auditoriasBean.Log(this,personaID, "NuevaEmergencia", "Fin Transaccion", true);

        Date comienzo = new Date();
        Date current = new Date();
        AmbulanciaDTO ambulanciaDTO = null;
        long seconds = (current.getTime()-comienzo.getTime())/1000;
        while(ambulanciaDTO == null && seconds <= 10){
            ambulanciaDTO = emergenciasBean.GetEmergenciaDTO(emergencia.getEmergenciaID()).getAmbulancia();
            current = new Date();
            seconds = (current.getTime()-comienzo.getTime())/1000;
        }
        Gson gson = new Gson();
        if(seconds >= 10){
            return Response.accepted(gson.toJson("Ninguna ambulancia ha atendido")).build();
        }
        return Response.ok(gson.toJson(ambulanciaDTO.getAmbulanciaID())).build();
    }
}
