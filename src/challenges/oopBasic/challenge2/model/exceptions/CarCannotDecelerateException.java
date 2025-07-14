package challenges.oopBasic.challenge2.model.exceptions;

public class CarCannotDecelerateException extends RuntimeException {
    public CarCannotDecelerateException(String message) {
        super(message);
    }
}
