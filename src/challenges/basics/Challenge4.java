package challenges.basics;

import java.util.Scanner;

public class Challenge4 {
    /*
    Escreva um código que receba o nome e a idade
    de 2 pessoa e imprime a diferença de idade entre elas
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da 1° pessoa: ");
        var personOneName = scanner.next();
        System.out.println("Digite a idade da 1° pessoa: ");
        var personOneAge = scanner.nextInt();
//
        System.out.print("Digite o nome da 2° pessoa: ");
        var personTwoName = scanner.next();
        System.out.println("Digite a idade da 2° pessoa: ");
        var personTwoAge = scanner.nextInt();

        var isValidFirstAge = isValidAge(personOneAge);
        var isValidSecondAge = isValidAge(personTwoAge);
        var validAges = isValidFirstAge && isValidSecondAge && isFirstOlderThanSecond(personOneAge, personTwoAge);

        String response = "Uma das duas idades é inválida!";

        if (validAges) {
            var ageDifference = personOneAge - personTwoAge;
            response = "A diferença entre as duas idade é: " + ageDifference;
        }

        System.out.println(response);
        scanner.close();

    }

    public static boolean isValidAge(int age) {
        return age >= 0;
    }

    public static boolean isFirstOlderThanSecond(int age, int otherAge) {
        return age > otherAge;
    }
}
