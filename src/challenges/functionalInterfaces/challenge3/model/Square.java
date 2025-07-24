package challenges.functionalInterfaces.challenge3.model;

import challenges.functionalInterfaces.challenge3.model.interfaces.Area;

public class Square implements Area {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }


    @Override
    public double getAreaValue() {
        return side * side;
    }
}
