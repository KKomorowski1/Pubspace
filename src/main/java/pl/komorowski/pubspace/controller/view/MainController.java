package pl.komorowski.pubspace.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.komorowski.pubspace.model.Pub;
import pl.komorowski.pubspace.model.Seat;
import pl.komorowski.pubspace.service.ButtonService;
import pl.komorowski.pubspace.service.PubService;
import pl.komorowski.pubspace.service.SeatService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {


    @Autowired
    private PubService pubService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private ButtonService buttonService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {

        Map<String, Object> model = new HashMap<String, Object>();

        model.put("pubs", pubService.getAllPubs());


        return new ModelAndView("index", "model", model);

    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView getPub(@RequestParam(value = "id") int id, Seat seat, Pub pub) {

        Map<String, Object> model = new HashMap<String, Object>();


        model.put("name", pubService.getPub(id).getName());
        model.put("address", pubService.getPub(id).getAddress());
        model.put("seat", seatService.getAllSeat(id));
        model.put("buttonList", buttonService.populateSeat());
        model.put("id", pubService.getPub(id).getId());
        model.put("space", seatService.getSeat(id).getSpace());
        model.put("time", seatService.getTen(id));

        return new ModelAndView("pubTemplet", "model", model);

    }


    @PostMapping("/saveUpdate")
    public String saveUpdate(@Valid Seat seat, Pub pub, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {


            return "pubTemplet";
        }


        seatService.addSeat(seat);


        return "redirect:/index";


    }
}

