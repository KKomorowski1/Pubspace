package pl.komorowski.pubspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.komorowski.pubspace.DTO.PubspaceDto;
import pl.komorowski.pubspace.model.Pub;
import pl.komorowski.pubspace.model.Seat;
import pl.komorowski.pubspace.repository.PubRepo;
import pl.komorowski.pubspace.repository.SeatRepo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepo seatRepo;

    public List<Seat> getAllSeat(int pubId) {
        List<Seat> seats = new ArrayList<>(5);

            seatRepo.findByPubId(pubId).forEach(seats::add);

        return seats;
    }

    public List<Seat> getLast5(int pubId) {
        List<Seat> seats = new ArrayList<>();

        seatRepo.findTop5ByPubIdOrderBySeatIdDesc(pubId).forEach(seats::add);

        return seats;
    }

    public void addSeat(Seat seat, int id) {

        Pub pub = new Pub(id);

        LocalDateTime localDateTime = LocalDateTime.now();

        Timestamp now = Timestamp.valueOf(localDateTime);

        seat.setDateTime(now);

        seat.setPub(pub);

        seatRepo.save(seat);
    }

    public void updateSeat(int id, Seat seat) {

        seatRepo.save(seat);
    }

    public Seat getSeat(int id) {

        return seatRepo.findById(id).orElse(null);
    }

    public List<PubspaceDto> get10LastUpdates() {
        List<PubspaceDto> list = seatRepo.get10LastUpdates();
        list.addAll(seatRepo.get10LastUpdates());
        return list.subList(0, 9);
    }

}
