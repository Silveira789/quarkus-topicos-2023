package repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Roupa;

@ApplicationScoped
public class RoupaRepository implements PanacheRepository<Roupa> {

    public List<Roupa> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1)", "%" + nome + "%").list();

    }

}
