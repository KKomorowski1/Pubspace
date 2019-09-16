package pl.komorowski.pubspace.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {

    @RequestMapping(method = RequestMethod.GET,value = "/user")
    @ResponseBody
    public Principal user (Principal principal){
        return principal;
    }
}
