package challenges.controlstructure;

import java.util.Scanner;

public class Challenge1 {
    /*
    Escreva um código onde o usuário entra com um número e seja
    gerada a tabuada de 1 até desse número
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        var baseNumber = scanner.nextInt();

        for (var index = 1; index <= 10; index++) {
            var result = baseNumber * index;
            System.out.printf("%s x %s = %s\n", baseNumber, index, result);
        }

        scanner.close();
    }
}
