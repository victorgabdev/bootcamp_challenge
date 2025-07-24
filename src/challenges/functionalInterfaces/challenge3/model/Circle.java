package challenges.functionalInterfaces.challenge3.model;

import challenges.functionalInterfaces.challenge3.model.interfaces.Area;

public class Circle implements Area {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getAreaValue() {
        return Math.PI * Math.pow(radius, 2);
    }
}
