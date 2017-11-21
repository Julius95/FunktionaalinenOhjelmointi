package tehtavat;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

import java.nio.Buffer;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Collector.Characteristics;

public class CustomCollector implements Collector<CharSequence,StringBuffer,String> {
/*
    @Override
    public Supplier<List<T>> supplier() {
        return new Supplier<List<T>>(){
            @Override
            public List<T> get(){
                return new ArrayList<>();
            }
        };
    }

*/
    @Override
    public Supplier<StringBuffer > supplier() {     // () -> T
        return () -> new StringBuffer ();
    }


    @Override
    public BiConsumer<StringBuffer, CharSequence> accumulator() {  // T, U -> void
        return (buf, item) -> buf.append(item.toString());
    }

    @Override
    public BinaryOperator<StringBuffer> combiner() {   // T, T -> T
        return (buf1, buf2) -> {
        	buf1.append(buf2);
            return buf1;
        };
    }

    @Override
    public Function<StringBuffer, String> finisher() {
        return (buffer) -> (String)buffer.toString();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT, Characteristics.UNORDERED);//Collections.emptySet()
    }

    public static Collector<CharSequence,StringBuffer,String> getInstance(){
    	return new CustomCollector();
    }
}