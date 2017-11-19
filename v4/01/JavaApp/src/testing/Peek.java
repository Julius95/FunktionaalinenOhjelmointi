package testing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;


public class Peek {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

		numbers.stream()
		.map(x -> x + 17)
                .filter(x -> x % 2 == 0)
                .limit(3)
                .forEach(System.out::println);

		numbers.stream()
		.peek(x -> System.out.println("taking from stream: " + x)).map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x)).filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter: " + x)).limit(3)
                .peek(x -> System.out.println("after limit: " + x)).collect(toList());

		List<String> l = new ArrayList(Arrays.asList("one", "two"));
		Stream<String> sl = l.stream();
	    l.add("three");
	    String s = sl.collect(Collectors.joining(" "));
	    System.out.println(s);
    }
}
