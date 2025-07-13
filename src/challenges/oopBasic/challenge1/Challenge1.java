package challenges.oopBasic.challenge1;

/*
todos os execicios devem ter um menu de interativo para chamar as funções e ter uma opção de sair para finalizar a execução
Escreva um código onde temos uma conta bancaria que possa realizar as seguintes operações:
Consultar saldo (OK)
consultar cheque especial (OK)
Depositar dinheiro; (OK)
Sacar dinheiro;
Pagar um boleto.
Verificar se a conta está usando cheque especial.

Siga as seguintes regras para implementar

A conta bancária deve ter um limite de cheque especial somado ao saldo da conta;
O o valor do cheque especial é definido no momento da criação da conta, de acordo com o valor depositado na conta em sua criação;
Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque especial deve ser de R$50,00
Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor depositado;
Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial.
 */

import challenges.oopBasic.challenge1.exceptions.InsufficientFundsException;
import challenges.oopBasic.challenge1.model.BankAccount;

import java.util.Scanner;

public class Challenge1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- SISTEMA BANCÁRIO ---");
        System.out.println("Criar conta bancária!");
        System.out.print("Valor a Depositar: ");
        var firstDeposit = scanner.nextDouble();

        var account = new BankAccount(firstDeposit);

        boolean running = true;

        while (running) {
            showMenuOptions();

            System.out.println("Digite a operação: ");
            var option = scanner.nextInt();

            if(option < 1 || option > 7) {
                System.out.println("Opção Inválida!");
                showOperationEnd();
                continue;
            }

            switch (option) {
                case 1 -> {
                    System.out.println("Saldo da conta: " + account.checkBalance());
                    showOperationEnd();
                }

                case 2 -> {
                    System.out.println("Cheque Especial: " + account.checkSpecialCheck());
                    showOperationEnd();
                }

                case 3 -> {
                    String operation = "depositado";
                    var value = getValue(operation, scanner);
                    account.deposit(value);

                    successMessage(value, account.checkBalance(), operation);
                }

                case 4 -> {
                    try {
                        String operation = "sacado";
                        var value = getValue(operation, scanner);
                        account.withdrawMoney(value);

                        successMessage(value, account.checkBalance(), operation);
                    } catch (InsufficientFundsException ex) {
                        System.out.println(ex.getMessage());
                        showOperationEnd();
                        continue;
                    }

                }

                case 5 -> {

                    try {
                        String operation = "pago";
                        var value = getValue(operation, scanner);
                        account.withdrawMoney(value);

                        successMessage(value, account.checkBalance(), operation);
                    } catch (InsufficientFundsException ex) {
                        System.out.println(ex.getMessage());
                        showOperationEnd();
                        continue;
                    }
                }

                case 6 -> {
                    System.out.printf("O cheque espcecial %s usado!\n" ,
                        (account.isSpecialCheckUsed() ? "está sendo" : "não está sendo"));
                    showOperationEnd();
                }

                case 7 -> {
                    running = false;
                    showOperationEnd();
                }

            }

        }

        System.out.println("Encerrando Sessão...");

    }

    public static void showMenuOptions() {
        System.out.println("# Operações: ");
        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Consultar cheque especial");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Pagar Boleto");
        System.out.println("6 - Verificar se a conta está usando cheque especial");
        System.out.println("7 - Encerrar Sessão");
    }

    public static void showOperationEnd() {
        System.out.println("====================");
    }

    public static Double getValue(String operation, Scanner scanner) {
        System.out.print("Valor a ser " + operation + ": ");
        return scanner.nextDouble();
    }

    public static void successMessage(Double value, Double balance, String operation) {
        System.out.println("O valor de " + value + " foi " + operation + " com sucesso!");
        System.out.println("O saldo atual: " + balance);
        showOperationEnd();
    }
}
