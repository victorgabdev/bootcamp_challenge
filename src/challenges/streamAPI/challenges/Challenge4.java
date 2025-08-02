package challenges.streamAPI.challenges;

import challenges.streamAPI.NumberListFactory;

import java.util.List;

public class Challenge4 {

    public static void main(String[] args) {
        List<Integer> numbers = NumberListFactory.create();

        List<Integer> oddNumbers = numbers.stream()
                .filter(number -> number % 2 != 0)
                .toList();

        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();

        System.out.println(oddNumbers);
        System.out.println(evenNumbers);
    }
}
