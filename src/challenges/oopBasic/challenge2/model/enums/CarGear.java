package challenges.oopBasic.challenge2.model.enums;

public enum CarGear {

    NEUTRAL_POINT(0, "Ponto Neutro"),
    FIRST_GEAR(1, "Primeira Marcha"),
    SECOND_GEAR(2, "Segunda Marcha"),
    THIRD_GEAR(3, "Terceira Marcha"),
    FOURTH_GEAR(4, "Quarta Marcha"),
    FIFTH_GEAR(5, "Quinta Marcha"),
    SIXTH_GEAR(6, "Sexta Marcha");

    private final int code;
    private final String description;

    CarGear(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static CarGear byCode(int code) {
        for(CarGear gear: values()) {
            if(gear.getCode() == code) {
                return gear;
            }
        }
        throw new IllegalArgumentException("Marcha Inválida: " + code);
    }
}
