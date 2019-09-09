package pl.komorowski.pubspace.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.komorowski.pubspace.model.Pub;
import pl.komorowski.pubspace.service.PubService;

import java.util.List;

@RestController
public class PubController {

    private PubService pubService;

    @Autowired
    public PubController(PubService pubService) {
        this.pubService = pubService;
    }

    @RequestMapping(value = "/pubs", method = RequestMethod.GET)
    public List<Pub> getAllPub() {
        return pubService.getAllPubs();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pubs/")
    public void addPub(@RequestBody Pub pub) {
        pubService.addPub(pub);
    }

    @RequestMapping("/pubs/{id}")
    public Pub getPub(@PathVariable int id) {
        return pubService.getPub(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/pubs/{id}")
    public void deletePub(@PathVariable int id) {
        pubService.deletePub(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/pubs/{id}")
    public void updatePub(@PathVariable int id, @RequestBody Pub pub){
        pubService.updatePub(id, pub);
    }
}
