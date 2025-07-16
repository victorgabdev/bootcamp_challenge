package challenges.polymorphism.challenge2.model;

public class Attendant extends Employee {

    private double cashValue;

    public Attendant(String name, String email, String password,double cashValue) {
        super(name, email, password, false);
        this.cashValue = cashValue;
    }

    public double getCashValue() {
        return cashValue;
    }

    public void setCashValue(double cashValue) {
        this.cashValue = cashValue;
    }

    public void receivePayment(double cash) {
        if(cash <= 0) System.out.println("Coloque um valor de pagamento válido...");
        cashValue += cash;
    }
    public void closeRegister() {
        if(cashValue > 0) cashValue = 0;
    }

}
