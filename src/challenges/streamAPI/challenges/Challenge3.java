package challenges.streamAPI.challenges;

import challenges.streamAPI.NumberListFactory;

import java.util.List;

public class Challenge3 {


    // Todos os numeros são positivos
    public static void main(String[] args) {
        List<Integer> numbers = NumberListFactory.create();

        boolean isPositiveList = numbers.stream()
                        .allMatch(number -> number > 0);


        System.out.println(isPositiveList);
    }
}
