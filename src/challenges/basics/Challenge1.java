package challenges.basics;

import java.util.Scanner;

public class Challenge1 {
    /*
    Escreva um codigo que receba o nome e o ano de
    nascimento de alguém e imprima na tela a seguinte
    mensagem: "Olá fulano você tem x anos".
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        var name = scanner.next();

        System.out.print("Digite sua idade: ");
        var age = scanner.nextInt();

        System.out.printf("Olá %s, você tem %s anos", name, age);
    }
}
