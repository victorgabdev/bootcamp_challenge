package challenges.streamAPI.challenges;

import challenges.streamAPI.NumberListFactory;

import java.util.List;

public class Challenge1 {

    public static void main(String[] args) {
        List<Integer> numbers = NumberListFactory.create();

        List<Integer> orderedNumbers =
                numbers.stream().
                        sorted().  // Integer é um Comparable
                        toList();

        System.out.println(orderedNumbers);
    }
}
