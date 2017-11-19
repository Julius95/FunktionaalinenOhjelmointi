package parallel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MoreParallel {
	static ArrayList<Long> taulukkoLista;
	static LinkedList<Long> linkitettyLista;

	static long N = 5_000_000L;

	public static void main(String[] args) {
		taulukkoLista = (ArrayList<Long>) LongStream.rangeClosed(1, N)
				.boxed().collect(Collectors.toList());
		linkitettyLista = (LinkedList<Long>) LongStream.rangeClosed(1, N)
				.boxed().collect(Collectors.toCollection(()->new LinkedList<Long>()));
		//Mitataan ajat peräkkäisiä toteutuksia käyttäen
		System.out.println("ArrayList, Peräkkäinen : " + measurePerf(MoreParallel::hidasNelioSummaList, taulukkoLista));

		System.out.println("LinkedList, Peräkkäinen : " + measurePerf(MoreParallel::hidasNelioSummaList, linkitettyLista));

		System.out.println("LongStream, Peräkkäinen : " + measurePerf(MoreParallel::hidasNelioSummaStream,
				() -> LongStream.rangeClosed(1, N)));

		//Mitataan ajat parallel toteutuksilla
				System.out.println("ArrayList, Rinnakkainen : " + measurePerf(MoreParallel::hidasNelioSummaListParallel, taulukkoLista));

				System.out.println("LinkedList, Rinnakkainen : " + measurePerf(MoreParallel::hidasNelioSummaListParallel, linkitettyLista));

				System.out.println("LongStream, Rinnakkainen : " + measurePerf(MoreParallel::hidasNelioSummaStream,
						() -> LongStream.rangeClosed(1, N)));
	}

	public static <T, R> long measurePerf(Function<T, R> f, T input) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            R result = f.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
            //System.out.println("Result: " + result);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

	public static long hidasNelioSummaList(List<Long> input) {
        return input.stream()
	                  .map(x -> x * x)
	                  .reduce( (long) 0, (acc, x) -> acc + x);
	}

	public static long hidasNelioSummaStream(Supplier<LongStream> input) {
		return input.get()
				.map(x -> x * x)
				.reduce(0, (acc, x) -> acc + x);
	}

	public static long hidasNelioSummaListParallel(List<Long> input) {
        return input.parallelStream()
        		.map(x -> x * x)
        		.reduce( (long) 0, (acc, x) -> acc + x);
	}

	public static long hidasNelioSummaStreamParallel(Supplier<LongStream> input) {
		return input.get()
				.parallel()
				.map(x -> x * x)
				.reduce(0, (acc, x) -> acc + x);
	}

}
