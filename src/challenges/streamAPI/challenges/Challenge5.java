package challenges.streamAPI.challenges;

import challenges.streamAPI.NumberListFactory;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.ToIntFunction;

public class Challenge5 {

    public static void main(String[] args) {

        List<Integer> numbers = NumberListFactory.create();

        List<Integer> bigger5Numbers = numbers
                .stream()
                .filter(number -> number > 5)
                .toList();

        int quantityBigger5 = bigger5Numbers.size();

        int sum = bigger5Numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println("Media: " + sum / quantityBigger5);

        // Outra forma
        double media = numbers.stream()
                .filter(n -> n > 5)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

    }
}
