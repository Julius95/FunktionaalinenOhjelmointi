package menu;
import java.util.stream.*;

import menu.Dish.Type;
import streams.Transaction;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static menu.Dish.dishTags;
import static menu.Dish.menu;

public class Reducing{

    public static void main(String...args){

        List<Integer> numbers = Arrays.asList(3,4,5,1,2);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = numbers.stream().reduce(0, (a,b) -> Integer.sum(a,b));
        System.out.println(sum2);

        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);

        Optional<Integer> min = numbers.stream().reduce((s,i) -> Integer.min(s,i));
        min.ifPresent(i -> System.out.println());

        int calories = menu.stream()
                           .map(dish -> dish.getCalories())
                           .reduce(0, (a,b) -> Integer.sum(a,b));
        System.out.println("Number of calories:" + calories);


    }
}
