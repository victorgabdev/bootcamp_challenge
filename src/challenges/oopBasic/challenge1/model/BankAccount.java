package challenges.oopBasic.challenge1.model;

import challenges.oopBasic.challenge1.exceptions.InsufficientFundsException;

public class BankAccount {

    private Double balance;
    private Double specialCheck;
    private boolean specialCheckUsed;
    private Double specialCheckUsedAmount = 0.0;

    private final Double DEFAULT_SC_VALUE = 50.0;
    private final Double BASE_BALANCE_VALUE = 500.0;

    public BankAccount() {
        this.balance = 0.0;
        this.specialCheck = DEFAULT_SC_VALUE;
        this.specialCheckUsed =  false;
    }

    public BankAccount(Double balance) {
        this.balance = balance;

        this.specialCheck =
                this.balance > BASE_BALANCE_VALUE ?
                        (this.balance * 0.5) :
                        DEFAULT_SC_VALUE;

        this.specialCheckUsed =  false;
    }

    public boolean isSpecialCheckUsed() {
        return specialCheckUsed;
    }

    public Double getTotalBalance() {
        return this.balance + this.specialCheck;
    }

    // methods
    public Double checkBalance() {
        return this.balance;
    }

    public Double checkSpecialCheck() {
        return this.specialCheck;
    }

    public void deposit(Double value) {
        if(specialCheckUsed && specialCheckUsedAmount > 0) {
            double fee = specialCheckUsedAmount * 0.2;
            value -= fee;
            System.out.println("Taxa de R$ " + fee + " cobrada por uso do cheque especial.");

            this.specialCheck += specialCheckUsedAmount;
            this.specialCheckUsedAmount = 0.0;
            this.specialCheckUsed = false;
        }

        this.balance += value;
    }

    public void withdrawMoney(Double value) {

        if(value > getTotalBalance()) throw new InsufficientFundsException("Saldo insuficiente para essa operação.");

        if (value <= this.balance) {
            this.balance -= value;
        } else {
            this.specialCheckUsedAmount = value - this.balance;
            this.balance = 0.0;
            this.specialCheck -= this.specialCheckUsedAmount;
            this.specialCheckUsed = true;
        }

    }

    @Override
    public String toString() {
        return "Conta Bancária{" +
                "saldo=" + balance +
                ", Cheque Especial=" + specialCheck +
                '}';
    }
}
