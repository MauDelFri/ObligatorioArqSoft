package obligatorio.servicios;

import DominioDTO.AmbulanciaDTO;
import DominioDTO.EmergenciaDTO;
import DominioDTO.PersonaDTO;
import Negocio.AmbulanciaSBLocal;
import Negocio.EmergenciaSBLocal;
import Negocio.ManejadorJMS_SBLocal;
import Negocio.PersonaSBLocal;
import java.math.BigDecimal;
import java.util.Date;
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
    
    public EmergenciasResource() {
    }

    @GET
    @Produces("application/xml")
    public String getXML() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @POST
    @Path("/nuevaEmergencia")
    @Consumes("application/x-www-form-urlencoded")
    public void NuevaEmergencia(@FormParam("idPersona") long personaID) {
        PersonaDTO persona = personasBean.GetPersonaDTO(personaID);

        //TODO: hacer el algoritmo que levante que ambulancia se le va a asignar
        AmbulanciaDTO ambulancia = ambulanciasBean.GetAmbulanciaDTO(1);

        EmergenciaDTO emergencia = new EmergenciaDTO();
        emergencia.setPersona(persona);
        emergencia.setAmbulancia(ambulancia);

        emergencia.setFechaSolicitada(new Date());

        //TODO: calculo del perfil de la persona
        emergencia.setCalcperfil(BigDecimal.ONE);

        emergencia.setUrgenciaSolicitada(Short.parseShort("1"));

        emergenciasBean.Crear(emergencia);

        


    public void NuevaEmergencia(@FormParam("idPersona") long personaID,
                                @FormParam("severidad") short severidad) {
        
        Persona persona = personasBean.GetPersona(personaID);
        Ambulancia ambulancia = ambulanciasBean.GetAmbulancia(1);
        
        Emergencia emergencia = new Emergencia();
        emergencia.setEmergenciaPersonaid(persona);
        emergencia.setEmergenciaFechasolicitada(new Date());
        emergencia.setEmergenciaUrgenciasolicitada(severidad);
        emergencia.setEmergenciaAmbulanciaid(ambulancia);
        
        manejadorJMSBean.ProcesarEmergencia(emergencia);
    }
}
