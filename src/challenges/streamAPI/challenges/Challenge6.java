package challenges.streamAPI.challenges;

import challenges.streamAPI.NumberListFactory;

import java.util.List;

public class Challenge6 {

    public static void main(String[] args) {
        List<Integer> numbers = NumberListFactory.create();

        boolean anyNumberBigger10 = numbers
                .stream()
                .anyMatch(n -> n > 10);

        System.out.println(anyNumberBigger10);
    }
}
