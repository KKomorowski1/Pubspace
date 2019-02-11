package pl.komorowski.pubspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Autowired
    private PubRepo pubRepo;


    public List<Seat> getAllSeat(int pubId) {


        List<Seat> seats = new ArrayList<>(5);


            seatRepo.findByPubId(pubId).forEach(seats::add);

        return seats;
    }


    public List<Seat> getTen(int pubId) {


        List<Seat> seats = new ArrayList<>();


        seatRepo.findTop5ByPubIdOrderBySeatIdDesc(pubId).forEach(seats::add);

        return seats;
    }


    public void addSeat(Seat seat) {


        LocalDateTime localDateTime = LocalDateTime.now();

        Timestamp now = Timestamp.valueOf(localDateTime);

        seat.setDateTime(now);

        seatRepo.save(seat);
    }

    public void updateSeat(int id, Seat seat) {

        seatRepo.save(seat);
    }

    public Seat getSeat(int id) {

        return seatRepo.findById(id).orElse(null);
    }



}
