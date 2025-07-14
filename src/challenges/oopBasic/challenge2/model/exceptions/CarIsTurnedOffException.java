package challenges.oopBasic.challenge2.model.exceptions;

public class CarIsTurnedOffException extends RuntimeException {
    public CarIsTurnedOffException(String message) {
        super(message);
    }
}
