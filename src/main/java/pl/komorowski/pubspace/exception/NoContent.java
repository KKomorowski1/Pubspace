package pl.komorowski.pubspace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "No Pubs To Display")
public class NoContent extends RuntimeException{
    public NoContent(String message) {
        super(message);
    }
}
