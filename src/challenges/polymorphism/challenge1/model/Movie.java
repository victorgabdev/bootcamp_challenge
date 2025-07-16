package challenges.polymorphism.challenge1.model;

import challenges.polymorphism.challenge1.enums.TypeLanguage;

import java.util.Objects;

public class Movie {

    private final String name;
    private final TypeLanguage typeLanguage;

    public Movie(String name, TypeLanguage typeLanguage) {
        this.name = name;
        this.typeLanguage = typeLanguage;
    }

    public String getName() {
        return name;
    }

    public TypeLanguage getTypeLanguage() {
        return typeLanguage;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", typeLanguage=" + typeLanguage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Movie movie)) return false;
        return Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
