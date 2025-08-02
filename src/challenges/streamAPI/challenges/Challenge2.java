package challenges.streamAPI.challenges;

import challenges.streamAPI.NumberListFactory;

import java.util.List;
import java.util.function.ToIntFunction;

public class Challenge2 {

    public static void main(String[] args) {
        List<Integer> numbers = NumberListFactory.create();

        // Soma dos números pares da lista

        // Primeira maneira
        int sum = numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);  // retorna nulo

        int sum2 = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(value -> value)
                .sum();

        System.out.println(sum);

    }
}
