package pl.komorowski.pubspace.repository;

import org.springframework.data.repository.CrudRepository;
import pl.komorowski.pubspace.model.Seat;

import java.util.List;

public interface SeatRepo extends CrudRepository<Seat, Integer> {

     List<Seat> findByPubId(int pubId);





}
