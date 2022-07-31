package cinema.exception;

import java.security.InvalidKeyException;

//@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class IncorrectPasswordException extends InvalidKeyException {
    public IncorrectPasswordException(String message) {
        super(message);
    }
}
