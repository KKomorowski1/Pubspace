package pl.komorowski.pubspace.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public List<Pub> getAllPub() {
        return pubService.getAllPubs();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pubs")
    public void addPub(@RequestBody Pub pub) {
        pubService.addPub(pub);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pubs/{id}")
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
/*
security:
        oauth2:
            client:
                clientId: 809358122358-jn9ojomrpnk49qcbba16mp7cqujqnj8k.apps.googleusercontent.com
                clientSecret: UtbvRKZ3e1a0B7_qSDBvwVBL
                accessTokenUri: https://www.googleapis.com/oauth2/v3/token
                userAuthorizationUri: https://accounts.google.com/o/oauth2/auth
                tokenName: oauth_token
                authenticationScheme: query
                clientAuthenticationScheme:
                scope: profile email
            resource:
                userInfoUri: https://www.googleapis.com/userinfo/v2/me
                preferTokenInfo: false
 */