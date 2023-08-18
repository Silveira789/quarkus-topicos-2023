package resource;

import java.util.List;

import model.Estado;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/estados")
public class EstadoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> todoEstados() {
        return Estado.listAll();
    }

}
