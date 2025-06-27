package challenges.basics;

import java.util.Scanner;

public class Challenge2 {
    /*
    Escreva um código que receba o tamanho do lado dequadrado, calcule sua
    area e exiba na tela
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do lado de um quadrado: ");
        var squareSide = scanner.nextDouble();

        var squareArea = Math.pow(squareSide, 2);

        System.out.printf("Area de um quadrado de lado %s: %.2f \n", squareSide, squareArea);

    }
}
