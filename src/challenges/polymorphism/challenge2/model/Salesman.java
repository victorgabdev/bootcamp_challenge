package challenges.polymorphism.challenge2.model;

public class Salesman extends Employee {

    private int salesQuantity;

    public Salesman(String name, String email, String password, int salesQuantity) {
        super(name, email, password, false);
        this.salesQuantity = salesQuantity;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void doSale(int quantity) {
        if(quantity <= 0) System.out.println("Coloque uma quantidade de vendas válida...");
        salesQuantity += quantity;
    }
}
