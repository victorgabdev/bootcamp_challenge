package challenges.controlstructure;

import java.util.Scanner;

public class Challenge4 {
    /*
    Escreva um código onde o usuário informa um número inicial, posteriormente irá informar outros N números,
    a execução do código irá continuar até que o número informado dividido pelo primeiro número tenha resto
    diferente de 0 na divisão, números menores que o primeiro número devem ser ignorados.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int startNumber = scanner.nextInt();

        while (true) {
            System.out.print("Digite outro número: ");
            int otherNumber = scanner.nextInt();

            boolean isInvalidNumber = otherNumber <= startNumber;
            if(isInvalidNumber) continue;

            boolean isEndNumber = otherNumber % startNumber != 0;
            if(isEndNumber) break;
        }

        System.out.println("Finalização do App");
        scanner.close();
    }
}
