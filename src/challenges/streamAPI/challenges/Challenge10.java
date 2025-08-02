package challenges.streamAPI.challenges;

import challenges.streamAPI.NumberListFactory;

import java.util.List;

public class Challenge10 {

    public static void main(String[] args) {
        List<Integer> numbers = NumberListFactory.create();

        List<Integer> groupNumbers = numbers
                .stream()
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .toList();

        System.out.println(groupNumbers);
    }
}
