package tehtavat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.*;
import java.util.stream.Collector;
import static java.util.stream.Collector.Characteristics.*;

/**
*
* @author Simo
* @param
*/
public class OmaListaKollektori<T> implements Collector<T, List<T>, List<T>> {
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
    public Supplier<List<T>> supplier() {     // () -> T
        return () -> {
        	System.out.println("Thread asking for storage : " + Thread.currentThread().getName());
        	return new CopyOnWriteArrayList<>();};
    }


    @Override
    public BiConsumer<List<T>, T> accumulator() {  // T, U -> void
    	System.out.println("Thread asking for accumulator function : " + Thread.currentThread().getName());
    	return (list, item) -> {list.add(item);};
    }

    @Override
    public BinaryOperator<List<T>> combiner() {   // T, T -> T
    	return (list1, list2) -> {
    		System.out.println("Thread combining results : " + Thread.currentThread().getName());
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        //return list -> list;
    	System.out.println("Finisher-method called by : " + Thread.currentThread().getName());
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));//CONCURRENT
    }
}


