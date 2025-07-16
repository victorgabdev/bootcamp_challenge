package challenges.polymorphism.challenge1.model;

public class Ticket {

    private double value;
    private Movie movie;

    public Ticket(double value, Movie movie) {
        this.value = value;
        this.movie = movie;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
