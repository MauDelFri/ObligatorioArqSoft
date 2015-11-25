package obligatorio.servicios;

import DominioDTO.AmbulanciaDTO;
import DominioDTO.EmergenciaDTO;
import Negocio.AmbulanciaSBLocal;
import Negocio.ColaEmergenciaSBLocal;
import Negocio.EmergenciaSBLocal;
import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import obligatorio.cifrado.Cifrado;

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
            @FormParam("urgenciaResuelta") String urgenciaResuelta,
            @FormParam("idEmergencia") String emergenciaID,
            @FormParam("idColaEmergencia") String colaEmergenciaID) {
        try {
            String fechaR = Cifrado.Desencriptar(fechaResuelta);
            short urgenciaR = Short.parseShort(Cifrado.Desencriptar(urgenciaResuelta));
            long idEmergencia = Long.parseLong(Cifrado.Desencriptar(emergenciaID));
            long idColaEmergencia = Long.parseLong(Cifrado.Desencriptar(colaEmergenciaID));

            EmergenciaDTO emergencia = emergenciaSB.GetEmergenciaDTO(idEmergencia);
            try {
                emergencia.setFechaResuelta(new SimpleDateFormat("dd/MM/yyyy").parse(fechaR));
            } catch (ParseException ex) {
                Logger.getLogger(AmbulanciasResource.class.getName()).log(Level.SEVERE, null, ex);
            }
            emergencia.setUrgenciaResuelta(urgenciaR);

            emergenciaSB.Editar(emergencia);
            colaEmergenciaSB.RemoverEmergencia(emergencia, idColaEmergencia);
            return Response.ok().build();

        } catch (Exception ex) {
            Logger.getLogger(AmbulanciasResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.notAcceptable(null).build();
    }

    @POST
    @Path("/atenderEmergencia")
    @Consumes("application/x-www-form-urlencoded")
    public Response AtenderEmergencia(@FormParam("idAmbulancia") String ambulanciaID,
            @FormParam("idEmergencia") String emergenciaID) {
        try {
            long idAmbulancia = Long.parseLong(Cifrado.Desencriptar(ambulanciaID));
            long idEmergencia = Long.parseLong(Cifrado.Desencriptar(emergenciaID));

            EmergenciaDTO emergencia = emergenciaSB.GetEmergenciaDTO(idEmergencia);
            if (emergencia.getAmbulancia() == null) {
                AmbulanciaDTO ambulancia = ambulanciasSB.GetAmbulanciaDTO(idAmbulancia);
                emergencia.setAmbulancia(ambulancia);
                emergenciaSB.Editar(emergencia);

                return Response.ok().build();
            }
        } catch (Exception ex) {
            Logger.getLogger(AmbulanciasResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.notAcceptable(null).build();
    }

    @GET
    @Path("/getColasSubscripcion")
    @Produces("application/json")
    @Consumes("application/json")
    public Response GetColasSubscripcion(@QueryParam("idAmbulancia") long ambulanciaID) {
        Gson gson = new Gson();
        int[] target = ambulanciasSB.GetColasAmbulancia(ambulanciaID);
        return Response.accepted(gson.toJson(target)).build();
    }
}
