package challenges.oopBasic.challenge2.model.exceptions;

public class CarCannotAccelerateException extends RuntimeException {
    public CarCannotAccelerateException(String message) {
        super(message);
    }
}
