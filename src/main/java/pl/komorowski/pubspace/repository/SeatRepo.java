package pl.komorowski.pubspace.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.komorowski.pubspace.DTO.PubspaceDto;
import pl.komorowski.pubspace.model.Seat;

import java.util.List;

public interface SeatRepo extends CrudRepository<Seat, Integer> {

    List<Seat> findByPubId(int pubId);

    List<Seat> findTop5ByPubIdOrderBySeatIdDesc(int pubId);

    @Query("SELECT new pl.komorowski.pubspace.DTO.PubspaceDto(p.name, s.space, s.dateTime, s.seatId)" +
            " from Seat s INNER JOIN s.pub p order by s.seatId desc")
    List<PubspaceDto> get10LastUpdates();

}
