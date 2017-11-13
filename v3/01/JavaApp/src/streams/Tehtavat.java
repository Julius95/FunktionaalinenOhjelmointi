package streams;

import static java.util.stream.Collectors.toList;
import static menu.Dish.menu;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import jdk.internal.util.xml.impl.Pair;
import menu.Dish;
import menu.Dish.Type;

public class Tehtavat {


	public static void main(String[] args) throws IOException {

		//T.1//

		Function <Float, Float> toCelsius = (fah) ->{
			return (float)(5*((fah)-32))/9;
		};
		System.out.println(toCelsius.apply((float)50));

		Function <Float, Float> area = (radius) ->{
			return (float) ((float)Math.PI * Math.pow(radius, 2));
		};
		System.out.println(area.apply((float)10));

		//////

		//T.2//
		Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950),
            new Transaction(alan, 2013, 950)
        );

		//Ker‰‰ transaktioiden m‰‰r‰
		long maara = transactions.stream()
					.filter(t -> t.getYear()>2012 && t.getValue() >= 900)
					.count();
					//.collect(toList());
		System.out.println("maara = " + maara);

		//Ker‰‰ ruokatyyppien m‰‰r‰
		List<Long> listaus = Arrays.stream(Type.values())
    			.map(t -> menu.stream()
    					.filter(d -> d.getType() == t)
    					.count())
    			.collect(toList());
		//Toinen tapa
		Map<Type,Long> collect = (Map<Type, Long>) menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));

		System.out.println(collect);
		///////

		//T.3//
		System.out.println("Heitet‰‰n Noppaa 20 kertaa");
		int kuutoset = (int) IntStream.generate(() -> ThreadLocalRandom.current().nextInt(1, 7))
						.limit(20)
						.filter(luku ->{ System.out.println(luku);return luku == 6;})
						.count();

		System.out.println("Kuutosten m‰‰r‰ : " + kuutoset);
		///////

		//T.4//


		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(3, 4);

		ArrayList <Pari> parit;

		parit =  (ArrayList<Pari>) list1.stream()
        .flatMap(i -> list2.stream()
                .map(j -> new Pari((int)i,(int)j))
        ).
        collect(toList());


		parit.forEach(x-> System.out.println(x.x + " " + x.y));

		//T.5
		TreeMap<String, Long> result = Files.lines(Paths.get(".", "v3\\01\\JavaApp\\data.txt"), Charset.defaultCharset())
				.flatMap(line -> {
					return Arrays.stream(line.split(" "))
					.filter((s) -> s.matches("[^, :.!\\r\\n;][\\wÂ‰ˆ≈ƒ÷']*"))
					.collect(toList()).stream();
				})
				.collect(
						Collectors.groupingBy(Function.identity(),
						()->new TreeMap<String, Long>((a, b) -> a.compareToIgnoreCase(b)),
						Collectors.counting())
				);

		System.out.println(result);
	}

}
