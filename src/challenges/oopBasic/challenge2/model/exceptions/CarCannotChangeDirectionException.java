package challenges.oopBasic.challenge2.model.exceptions;

public class CarCannotChangeDirectionException extends RuntimeException {
    public CarCannotChangeDirectionException(String message) {
        super(message);
    }
}
