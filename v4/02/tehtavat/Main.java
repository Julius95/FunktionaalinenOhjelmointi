package tehtavat;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		long N = 10_000_000L;

		System.out.println("Pernentoteutus aika : " + measurePerf(Main::laskentaa, ()->LongStream.rangeClosed(1, N).boxed()));

		System.out.println("Rinnakkainentoteutus aika : " + measurePerf(Main::laskentaaParallel, ()->LongStream.rangeClosed(1, N).boxed()));
	}

	public static <T, R> long measurePerf(Function<T, R> f, T input) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            R result = f.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + result);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

	public static long laskentaa(Supplier<Stream<Long>> input) {
        return input.get()
        		.collect(ElementCountCollector.getInstance());
	}

	public static long laskentaaParallel(Supplier<Stream<Long>> input) {
        return input.get()
        		.parallel()
        		.collect(ElementCountCollector.getInstance());
	}

}
