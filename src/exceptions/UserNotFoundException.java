package exceptions;

// UNCHECKED EXCEPTION
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
