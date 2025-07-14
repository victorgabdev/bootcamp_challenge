package challenges.oopBasic.challenge2.model.exceptions;

public class CarCannotBeTurnedOffException extends RuntimeException {
    public CarCannotBeTurnedOffException(String message) {
        super(message);
    }
}
