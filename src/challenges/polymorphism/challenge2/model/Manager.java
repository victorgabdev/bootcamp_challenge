package challenges.polymorphism.challenge2.model;

public class Manager extends Employee {

    public Manager(String name, String email, String password) {
        super(name, email, password, true);
    }

    public void generateFinancialReport(double cashValue, double salesQuantity) {
        System.out.println("Quantidade de dinheiro em caixa: " + cashValue);
        System.out.println("Quantidade de vendas: " + salesQuantity);
    }

    public void consultSales(int quantitySales) {
        System.out.println("Quantidade de vendas: " + quantitySales);
    }
}
