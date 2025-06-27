package challenges.controlstructure;

import java.util.Scanner;

public class Challenge2 {
    /*
    Escreva um código onde o usuário entra com sua altura e peso,
    seja feito o calculo do seu IMC e seja exibida a mensagem de acordo com o resultado:

    Se for menor ou igual a 18,5 "Abaixo do peso";
    se for entre 18,6 e 24,9 "Peso ideal";
    Se for entre 25,0 e 29,9 "Levemente acima do peso";
    Se for entre 30,0 e 34,9 "Obesidade Grau I";
    Se for entre 35,0 e 39,9 "Obesidade Grau II (Severa)";
    Se for maior ou igual a 40,0 "Obesidade III (Mórbida)";

    IMC =  peso/(altura * altura)
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua altura: ");
        var height = scanner.nextDouble();

        System.out.print("Digite seu peso: ");
        var weight = scanner.nextDouble();

        var imc = weight / (height * height);

        String situation;
        if (imc <= 18.5) {
            situation = "Abaixo do peso";
        } else if (imc <= 24.9) {
            situation = "Peso ideal";
        } else if (imc <= 29.9) {
            situation = "Levemente acima do peso";
        } else if (imc <= 34.9) {
            situation = "Obesidade Grau I";
        } else if (imc <= 39.9) {
            situation = "Obesidade Grau II (Severa)";
        } else {
            situation = "Obesidade Grau III (Mórbida)";
        }

        System.out.println(situation);
        scanner.close();
    }
}
