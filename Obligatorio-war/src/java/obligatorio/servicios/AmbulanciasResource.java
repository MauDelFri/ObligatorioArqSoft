
package obligatorio.servicios;

import DominioDTO.AmbulanciaDTO;
import DominioDTO.EmergenciaDTO;
import Negocio.AmbulanciaSBLocal;
import Negocio.ColaEmergenciaSBLocal;
import Negocio.EmergenciaSBLocal;
import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("ambulancias")
@RequestScoped
public class AmbulanciasResource {

    @Context
    private UriInfo context;

    @EJB
    AmbulanciaSBLocal ambulanciasSB;
    
    @EJB
    EmergenciaSBLocal emergenciaSB;
    
    @EJB
    ColaEmergenciaSBLocal colaEmergenciaSB;
    
    public AmbulanciasResource() {
    }

    @POST
    @Path("/emergenciaResuelta")
    @Consumes("application/x-www-form-urlencoded")
    public Response EmergenciaResultado(@FormParam("fechaResuelta") String fechaResuelta,
                                        @FormParam("urgenciaResuelta") short urgenciaResuelta,
                                        @FormParam("idEmergencia") long emergenciaID,
                                        @FormParam("idColaEmergencia") long colaEmergenciaID) {
        EmergenciaDTO emergencia = emergenciaSB.GetEmergenciaDTO(emergenciaID);
        try {
            emergencia.setFechaResuelta(new SimpleDateFormat("dd/MM/yyyy").parse(fechaResuelta));
        } catch (ParseException ex) {
            Logger.getLogger(AmbulanciasResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        emergencia.setUrgenciaResuelta(urgenciaResuelta);
        
        emergenciaSB.Editar(emergencia);
        colaEmergenciaSB.RemoverEmergencia(emergencia, colaEmergenciaID);
        return Response.ok().build();
    }
    
    @POST
    @Path("/atenderEmergencia")
    @Consumes("application/x-www-form-urlencoded")
    public Response AtenderEmergencia(@FormParam("idAmbulancia") long ambulanciaID,
                                      @FormParam("idEmergencia") long emergenciaID) {
        EmergenciaDTO emergencia = emergenciaSB.GetEmergenciaDTO(emergenciaID);
        if(emergencia.getAmbulancia() == null){
            AmbulanciaDTO ambulancia = ambulanciasSB.GetAmbulanciaDTO(ambulanciaID);
            emergencia.setAmbulancia(ambulancia);
            emergenciaSB.Editar(emergencia);
            
            return Response.ok().build();
        }
        else{
            return Response.notAcceptable(null).build();
        }
    }
    
    @GET
    @Path("/getColasSubscripcion")
    @Produces("application/json")
    public Response GetColasSubscripcion(@QueryParam("idAmbulancia") long ambulanciaID) {
        Gson gson = new Gson(); 
        int[] target = ambulanciasSB.GetColasAmbulancia(ambulanciaID);
        return Response.accepted(gson.toJson(target)).build();
    }
}
