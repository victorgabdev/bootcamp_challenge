package challenges.functionalInterfaces.challenge2.model;

public class Product implements Tax {
    private TypeProduct type;

    public Product(TypeProduct type) {
        this.type = type;
    }

    public TypeProduct getType() {
        return type;
    }

    public void setType(TypeProduct type) {
        this.type = type;
    }


    @Override
    public double getTaxValue() {
        double tax = 0;
        switch (type) {
            case FOOD -> tax = 0.01;
            case HEALTH -> tax = 0.015;
            case CLOTHING -> tax = 0.025;
            case CULTURE -> tax = 0.04;
        }

        return tax;
    }
}
