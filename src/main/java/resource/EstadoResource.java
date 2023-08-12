package resource;

import org.hibernate.mapping.List;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;

import jakarta.enterprise.inject.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import model.Estado;

@Path("/estados")
public class EstadoResource {


    // @GET
    // @Produces(MediaType.APPLICATION_JSON)
    // public List<Estado>todosEstados(){

    //     return Estado.listAll();
    // }
    
}
