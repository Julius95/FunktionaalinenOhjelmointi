package tehtavat;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Supplier;
import static java.util.stream.Collectors.*;
import java.util.stream.DoubleStream;


class Kollektori{

    public static void main(String[] args){

        Omena o1 = new Omena("vihreä", 100);
        Omena o2 = new Omena("vihreä", 110);
        Omena o3 = new Omena("punainen", 101);
        Omena o4 = new Omena("punainen", 105);

        List<Omena> omenat = new ArrayList<>();

        omenat.add(o1);
        omenat.add(o2);
        omenat.add(o3);
        omenat.add(o4);

        List<Omena> moreApples = new ArrayList<>();
        int j = 0;
        for(int i = 0; i<5000;i++){
        	if(j>3){
        		j=0;
        	}
        	moreApples.add(omenat.get(j));
        	j++;
        }

        String result = moreApples.parallelStream()
        .map(e -> ("Omena(" + e.getVari() + ", " + e.getPaino() + ")\n"))
        .collect(CustomCollector.getInstance());
        System.out.println(result);

        //Luodaan lennossa uusi Collectori
        List<Omena> omenaLista = omenat.stream()
        .collect(
        		ArrayList::new,//supplier
        		List::add,//accumulator
        		List::addAll//combiner
        		);

        omenaLista.forEach(e -> System.out.println(e.getPaino() + " " + e.getVari()));

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Cores: " + cores);

        long start = System.nanoTime();

        List<Double> l = DoubleStream.generate(Math::random)
        .parallel()
        .limit(50000)
        .boxed()
        .collect(new OmaListaKollektori<>());  // ikioma kollektori
        //.collect(toList()); // Javan oma

        long duration = System.nanoTime() - start;

        System.out.println(l.size() + " " + duration / 1000000);

    }

}

