package tehtavat;

import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;

public class ElementCountCollector<T> implements Collector<T,LongAccumulator,Long> {

	@Override
	public Supplier<LongAccumulator> supplier() {
		return () -> new LongAccumulator(Long::sum, 0);
	}

	@Override
	public BiConsumer<LongAccumulator, T> accumulator() {
		return (acc, e) -> acc.accumulate(1);
	}

	@Override
	public BinaryOperator<LongAccumulator> combiner() {
		return (acc1, acc2) -> {
			acc1.accumulate(acc2.longValue());
			return acc1;
		};
	}

	@Override
	public Function<LongAccumulator, Long> finisher() {
		return (acc) -> acc.longValue();
	}

	public static<T> Collector<T,LongAccumulator,Long> getInstance(){
    	return new ElementCountCollector<T>();
    }

	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics() {
		return EnumSet.of(Characteristics.CONCURRENT);
	}

}
