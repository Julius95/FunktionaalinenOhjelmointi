import java.util.concurrent.ThreadLocalRandom;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;

interface Arpoja{
	IntStream arvo();
}

public class Makihyppy {

    static DoubleUnaryOperator makePistelaskuri(double kPiste, double lisapisteet){
            return (pituus) -> 60 + (pituus - kPiste) * lisapisteet;
    }

    public static void main(String[] args) {


       DoubleUnaryOperator normaaliLahti = makePistelaskuri(90, 1.8);

       System.out.println(normaaliLahti.applyAsDouble(91));


       //T.3

       //Tapa 1
       IntStream rivi = IntStream.generate(
    		   () -> ThreadLocalRandom.current().nextInt(1, 42))
    		   .distinct().limit(7);

       System.out.println();
       rivi.forEach(i -> System.out.print(i + " "));

       //Tapa 2
       Arpoja arpoja = () -> IntStream.generate(
    		   () -> ThreadLocalRandom.current().nextInt(1, 42))
    		   .distinct().limit(7);
       	System.out.println();
       	arpoja.arvo().forEach(i -> System.out.print(i + " "));

       	//T.4
       	
    }

}