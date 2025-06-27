package challenges.controlstructure;

import java.util.Scanner;
import java.util.function.Predicate;

public class Challenge3 {
    /*
    Escreva um código que o usuário entre com um primeiro número, um segundo número maior
    que o primeiro e escolhe entre a opção par e impar, com isso o código deve informar
    todos os números pares ou ímpares (de acordo com a seleção inicial) no intervalo de números informados,
    incluindo os números informados e em ordem decrescente;
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        var startNumber = scanner.nextInt();

        System.out.print("Digite o segundo número (Tem que ser maior que " + startNumber + "): ");
        var endNumber = scanner.nextInt();

        if(endNumber > startNumber) {
            System.out.print("Digite [1] para par ou [2] para ímpar: " );
            var option = scanner.nextInt();

            var isValidOption = option == 1 || option == 2;
            if(isValidOption) {
                var isEvenOption = option == 1;

                if(isEvenOption) {
                    showNumbersByCondition(startNumber, endNumber, num -> num % 2 == 0);
                } else {
                    showNumbersByCondition(startNumber, endNumber, num -> num % 2 != 0);
                }

            } else {
                System.out.printf("Erro: Não existe a opção %s\n", option);
            }
        } else {
            var isEqualNumbers = startNumber == endNumber;
            var errorMessage = isEqualNumbers ?
                    "os números informados são iguais." :
                    "o número " + startNumber + " é maior que " + endNumber + ".";
            System.out.println("ERRO: " + errorMessage);
        }
        scanner.close();
    }

    public static void showNumbersByCondition(int startNumber, int endNumber, Predicate<Integer> condition) {
        for (var index = endNumber; index >= startNumber; index--) {
            if(condition.test(index)) System.out.println(index);
        }
    }

}
