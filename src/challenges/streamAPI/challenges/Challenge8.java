package challenges.streamAPI.challenges;

import challenges.streamAPI.NumberListFactory;

import java.util.List;

public class Challenge8 {

    public static void main(String[] args) {
        List<Integer> numbers = NumberListFactory.create();

        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);
    }
}
