package resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
        novaRoupa.setCorPrincipal(roupa.getCorPrincipal());
        novaRoupa.setTamanho(roupa.getTamanho());

        repository.persist(novaRoupa);

        return novaRoupa;

    }

    //

    @GET
    public List<Roupa> findAll() {
        return repository.listAll();
    }

    //

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

    //

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") long id, Roupa roupaAtualizada) {
        Roupa roupaAtual = repository.findById(id);

        if (roupaAtual == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        roupaAtual.setNome(roupaAtualizada.getNome());
        roupaAtual.setCorPrincipal(roupaAtualizada.getCorPrincipal());
        roupaAtual.setTamanho(roupaAtualizada.getTamanho());

        repository.persist(roupaAtual);

        return Response.ok(roupaAtual).build();
    }

    //

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") long id) {
        Roupa roupa = repository.findById(id);

        if (roupa == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        repository.delete(roupa);

        return Response.noContent().build();
    }

}
