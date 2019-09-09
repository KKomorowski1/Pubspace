package pl.komorowski.pubspace.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.komorowski.pubspace.DTO.PubspaceDto;
import pl.komorowski.pubspace.model.Seat;
import pl.komorowski.pubspace.service.SeatService;

import java.util.List;

@RestController
public class SeatController {

    @Autowired
    private SeatService seatService;

    @RequestMapping("/pubs/{id}/seats/")
    public List<Seat> getAllSeat(@PathVariable int id) {

        return seatService.getAllSeat(id);
    }

    @RequestMapping("/pubs/last10")
    public List<PubspaceDto> getLast10Seats() {

        return seatService.get10LastUpdates();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/pubs/{id}/addUpdate")
    public Seat addUpdate(@PathVariable int id, @RequestBody Seat seat){
        seatService.addSeat(seat, id);

        return seat;
    }
}
