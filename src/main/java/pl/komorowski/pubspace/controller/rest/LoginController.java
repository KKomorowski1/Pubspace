package pl.komorowski.pubspace.controller.rest;

import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@CrossOrigin
public class LoginController {

    @GetMapping(value = "/user")
    @ResponseBody
    public Principal user(Principal principal) {
        return principal;
    }
}