package challenges.streamAPI.challenges;

import challenges.streamAPI.NumberListFactory;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Challenge7 {

    public static void main(String[] args) {
        List<Integer> numbers = NumberListFactory.create();

        // segundo numero maior da lista
        // Primeira forma
        Set<Integer> numbersSet = new HashSet<>(numbers);
        List<Integer> orderedNumbers = numbersSet
                .stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(orderedNumbers.get(1));

        // Segunda Forma
        Integer secondHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println(secondHighest);

    }
}
