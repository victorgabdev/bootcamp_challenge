package challenges.oopBasic.challenge2.model.enums;

public enum CarDirection {
    STRAIGHT_DIRECTION("Reto"),
    RIGHT_DIRECTION("Direita"),
    LEFT_DIRECTION("Esquerda");

    private final String description;

    CarDirection(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
