package resource;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Roupas;

@Path("/roupas")
public class RoupasResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Roupas>todasRoupas() {
        return Roupas.listAll();
    }




}