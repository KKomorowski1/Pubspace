package pl.komorowski.pubspace.controller.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin
public class LoginController {

    @GetMapping(value = "/user")
    public Principal user (Principal principal){
        return principal;
    }

}
