
package obligatorio.servicios;

import Entidades.Ambulancia;
import Entidades.Emergencia;
import Entidades.Persona;
import Negocio.AmbulanciaSBLocal;
import Negocio.EmergenciaSBLocal;
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
    EmergenciaSBLocal emergenciasBean;
    
    @EJB
    PersonaSBLocal personasBean;
    
    @EJB
    AmbulanciaSBLocal ambulanciasBean;
    
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
        Persona persona = personasBean.GetPersona(personaID);
        Ambulancia ambulancia = ambulanciasBean.GetAmbulancia(1);
        
        Emergencia emergencia = new Emergencia();
        emergencia.setEmergenciaPersonaid(persona);
        emergencia.setEmergenciaFechasolicitada(new Date());
        emergencia.setEmergenciaCalcperfil(BigDecimal.ONE);
        emergencia.setEmergenciaUrgenciasolicitada(Short.parseShort("1"));
        emergencia.setEmergenciaAmbulanciaid(ambulancia);
        
        emergenciasBean.Crear(emergencia);
    }
}
