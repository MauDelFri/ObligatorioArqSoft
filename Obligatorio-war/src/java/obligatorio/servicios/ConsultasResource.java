package obligatorio.servicios;

import DominioDTO.DatoTableroDTO;
import Negocio.AuditoriaSBLocal;
import com.google.gson.Gson;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("Consultas")
@RequestScoped
public class ConsultasResource {

    @Context
    private UriInfo context;

    @EJB
    AuditoriaSBLocal auditoriasBean;

    public ConsultasResource() {
    }

    @GET
    @Path("/consultaTablero")
    @Produces("application/json")
    public Response ConsultaTablero() {
        System.out.println("entro");
        Gson gson = new Gson();
        List<DatoTableroDTO> l = auditoriasBean.ConsultaTablero();
        return Response.accepted(gson.toJson(l)).build();
    }

    @GET
    @Path("/consultaEstado")
    @Produces("application/json")
    public Response ConsultaEstado() {
        try {
            auditoriasBean.Log(this, new Long("9999"), "ConsultaEstado", "OK", true);
            System.out.println("CONSULTA ESTADO OK");
        } catch (Exception e) {
            System.err.println("ERROR CONSULTA ESTADO");
            auditoriasBean.Log(this, new Long("9999"), "ConsultaEstado", e.getMessage(), false);
        }

        return Response.ok().build();
    }
}
