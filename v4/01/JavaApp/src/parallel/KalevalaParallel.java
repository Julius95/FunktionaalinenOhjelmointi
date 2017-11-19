package parallel;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class KalevalaParallel {

	public static void main(String[] args) throws IOException {
		Supplier<Stream<String>> supplier = () ->
		{
			try {
				return Files.lines(Paths.get(".", "v3\\01\\JavaApp\\data.txt"), Charset.defaultCharset());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		};

		System.out.println("Rinnakkainen toteutus : " + measurePerf(KalevalaParallel::sanatRinnakkainen, supplier));
		System.out.println("Peräkkäinen toteutus : " + measurePerf(KalevalaParallel::sanatPeräkkäinen, supplier));
	}

	public static <T, R> long measurePerf(Function<T,R> f, T input) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 15; i++) {
            long start = System.nanoTime();
            R result = f.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + result);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

	public static TreeMap<String, Long> sanatRinnakkainen(Supplier<Stream<String>> supplier) {
		Stream<String> stream = supplier.get();
		stream.parallel();
		//System.out.println("Should be Parallel(true) : " + stream.isParallel());
		return	stream
			.flatMap(line -> Arrays.stream(line.split(" ")))
			.filter(line -> line.matches("[^, :.!\\r\\n;][\\wåäöÅÄÖ']*"))
			.collect(
					Collectors.groupingBy(Function.identity(),
					()->new TreeMap<String, Long>((a, b) -> a.compareToIgnoreCase(b)),
					Collectors.counting())
			);
	}

	public static TreeMap<String, Long> sanatPeräkkäinen(Supplier<Stream<String>> supplier) {
		Stream<String> stream = supplier.get();
		//System.out.println("Should NOT be Parallel(false) : " + stream.isParallel());

		return stream
			.flatMap(line -> Arrays.stream(line.split(" ")))
			.filter(line -> line.matches("[^, :.!\\r\\n;][\\wåäöÅÄÖ']*"))
			.collect(
					Collectors.groupingBy(Function.identity(),
					()->new TreeMap<String, Long>((a, b) -> a.compareToIgnoreCase(b)),
					Collectors.counting())
			);
	}

}
