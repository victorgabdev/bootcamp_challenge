package challenges.polymorphism.challenge1.model;

public class HalfPriceTicket extends Ticket {

    private final double valueHalfPriceTicket;

    public HalfPriceTicket(double value, Movie movie) {
        super(value, movie);
        this.valueHalfPriceTicket = calculeHalfPrice(value);
    }

    public double getValueHalfPriceTicket() {
        return valueHalfPriceTicket;
    }

    private double calculeHalfPrice(double value) {
        var discount = value * 0.5;
        return value - discount;
    }
}
