package challenges.polymorphism.model;

import java.util.Objects;

public class FamilyTicket extends Ticket {

    private int quantityTicket;
    private final double valueFamilyTicket;
    private final boolean isPromotional;

    public FamilyTicket(double value, Movie movie, int quantityTicket) {
        super(value, movie);
        this.quantityTicket = quantityTicket;
        this.isPromotional = quantityTicket > 3;
        this.valueFamilyTicket = calculeFamilyTicketValue(quantityTicket, value);
    }

    public int getQuantityTicket() {
        return quantityTicket;
    }

    public void setQuantityTicket(int quantityTicket) {
        this.quantityTicket = quantityTicket;
    }

    public double getValueFamilyTicket() {
        return valueFamilyTicket;
    }

    public boolean isPromotional() {
        return isPromotional;
    }

    private double calculeFamilyTicketValue(int quantity, double value) {
        var familyTicketValue = quantity * value;
        if(isPromotional) familyTicketValue -= familyTicketValue * 0.05;  // Desconto de 5%
        return familyTicketValue;
    }

}
