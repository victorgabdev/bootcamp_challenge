package challenges.basics;

import java.util.Scanner;

public class Challenge3 {
    /*
    Escreva um código que receba a base e a altura de um
    retângulo, calcule sua área e exiba na tela
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho de uma base de retangulo: ");
        var rectangleLength = scanner.nextDouble();

        System.out.print("Digite o tamanho da altura de um retangulo: ");
        var rectangleWidth = scanner.nextDouble();

        var rectangleArea = rectangleLength * rectangleWidth;

        System.out.printf("A area do retângulo é: %.2f\n", rectangleArea);
    }
}
