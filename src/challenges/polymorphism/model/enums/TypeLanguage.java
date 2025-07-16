package challenges.polymorphism.model.enums;

public enum TypeLanguage {

    DUBLADO(1, "Dublado"),
    LEGENDADO(2, "Legendado");

    private final int code;
    private final String description;

    TypeLanguage(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TypeLanguage fromCode(int code) {
        for (TypeLanguage language : TypeLanguage.values()) {
            if(language.getCode() == code) return  language;
        }

        throw new IllegalArgumentException("Não existe o tipo escolhido: " + code);
    }
}
