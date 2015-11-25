/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.servicios;

import DominioDTO.AmbulanciaDTO;
import DominioDTO.DatoTableroDTO;
import DominioDTO.EmergenciaDTO;
import DominioDTO.PersonaDTO;
import Negocio.AmbulanciaSBLocal;
import Negocio.AuditoriaSBLocal;
import Negocio.EmergenciaSBLocal;
import Negocio.ManejadorJMS_SBLocal;
import Negocio.PersonaSBLocal;
import com.google.gson.Gson;
import java.util.Date;
import java.util.List;
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
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author martinintroini
 */
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
