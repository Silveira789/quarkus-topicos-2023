package resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Roupa;
import repository.RoupaRepository;

@Path("/roupas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoupaResource {

    @Inject
    RoupaRepository repository;

    @POST
    @Transactional
    public Roupa insert(Roupa roupa) {
        Roupa novaRoupa = new Roupa();
        novaRoupa.setNome(roupa.getNome());
        novaRoupa.setTamanho(roupa.getTamanho());
        novaRoupa.setCorPricipal(roupa.getCorPricipal());

        repository.persist(novaRoupa);

        return novaRoupa;

    }

    @GET
    public List<Roupa> findAll() {
        return repository.listAll();
    }


    @GET
    @Path("/{id}")
    public Roupa findById(@PathParam("id") long id) {
        return repository.findById(id);
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<Roupa> findByNome(@PathParam("nome") String nome) {
        return repository.findByNome(nome);
    }




}
