package pl.komorowski.pubspace.repository;

import org.springframework.data.repository.CrudRepository;
import pl.komorowski.pubspace.model.Pub;

import java.util.List;

public interface PubRepo  extends CrudRepository<Pub, Integer> {
    List<Pub> findAll();

    Pub findById(int id);

    Pub save(Pub pub);

    Pub deleteById(int id);
}
