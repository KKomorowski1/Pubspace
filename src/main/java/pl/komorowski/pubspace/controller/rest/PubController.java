package pl.komorowski.pubspace.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import pl.komorowski.pubspace.exception.NoContent;
import pl.komorowski.pubspace.model.Pub;
import pl.komorowski.pubspace.service.PubService;

import java.util.List;

@RestController
@CrossOrigin
public class PubController {

    private PubService pubService;

    @Autowired
    public PubController(PubService pubService) {
        this.pubService = pubService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pubs")
    public List getAllPub() {
        List getAllList = pubService.getAllPubs();
        if (getAllList == null){
            String message = "No pubs to Display";
            throw new NoContent(message);
        }
        return getAllList;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pubs")
    public void addPub(@RequestBody Pub pub) {
        pubService.addPub(pub);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pubs/{id}")
    public Pub getPub(@PathVariable int id) {
        Pub pub = pubService.getPub(id);
        if (pub == null){
            String message = "No pub corresponding with this id";
            throw new NoContent(message);
        }
        return pub;
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