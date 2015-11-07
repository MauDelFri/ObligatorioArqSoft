
package obligatorio.servicios;

import Obligatorio.beans.AccesoDatosLocal;
import Obligatorio.entidades.Emergencia;
import Obligatorio.entidades.Persona;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

@Path("emergencias")
@RequestScoped
public class EmergenciasResource {

    @Context
    private UriInfo context;

    @EJB
    AccesoDatosLocal accesoDatos;
    
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
    public void NuevaEmergencia(@FormParam("title") int personaID) {
        Persona persona = new Persona();
        persona.setPersonaID(personaID);
        
        Emergencia emergencia = new Emergencia();
        emergencia.setPersona(persona);
        
        accesoDatos.AltaEmergencia(emergencia);
    }
}
