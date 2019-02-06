package pl.komorowski.pubspace.repository;

import org.springframework.data.repository.CrudRepository;
import pl.komorowski.pubspace.model.Pub;

public interface PubRepo  extends CrudRepository<Pub, Integer> {


}
