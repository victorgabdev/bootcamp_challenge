package challenges.streamAPI.challenges;

import challenges.streamAPI.NumberListFactory;

import java.util.List;

public class Challenge9 {

    public static void main(String[] args) {
        List<Integer> numbers = NumberListFactory.create();

        long quantityDistinct = numbers.stream().distinct().count();
        long quantitynumbers = (long) numbers.size();

        System.out.println(quantitynumbers == quantityDistinct);


    }
}
