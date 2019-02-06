package pl.komorowski.pubspace.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.komorowski.pubspace.model.Seat;
import pl.komorowski.pubspace.service.SeatService;

import java.util.List;

@RestController
public class SeatController {

    @Autowired
    private SeatService seatService;

    @RequestMapping("/pubs/{id}/seats/format=json")
    public List<Seat> getAllSeat(@PathVariable int id) {

        return seatService.getAllSeat(id);
    }
}
