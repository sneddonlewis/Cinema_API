package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.InvalidKeyException;

//@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class IncorrectPasswordException extends InvalidKeyException {
    public IncorrectPasswordException(String message) {
        super(message);
    }
}
