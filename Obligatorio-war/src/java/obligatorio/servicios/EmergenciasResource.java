
package obligatorio.servicios;

import Entidades.Persona;
import Negocio.PersonaSBLocal;
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
    public void NuevaEmergencia(@FormParam("idPersona") int personaID) {

    }
    
    @POST
    @Path("/nuevaPersona")
    @Consumes("application/x-www-form-urlencoded")
    public void NuevaEmergencia(@FormParam("idPersona") long personaID) {
        Persona persona = new Persona();
        persona.setPersonaId(personaID);
        persona.setPersonaNombre("Netbeans");
        persona.setPersonaApellido("Puto");
        persona.setPersonaCedula("12345678");
        Date fecha = new Date();
        persona.setPersonaFechanac(fecha);

        personasBean.Crear(persona);
    }
}
