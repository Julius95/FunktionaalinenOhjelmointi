import java.util.concurrent.ThreadLocalRandom;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

interface Arpoja{
	IntStream arvo();
}

public class Makihyppy {

    static DoubleUnaryOperator makePistelaskuri(double kPiste, double lisapisteet){
            return (pituus) -> 60 + (pituus - kPiste) * lisapisteet;
    }

    public static void main(String[] args) {
    	//T.1
    	IntSupplier sup = () -> ThreadLocalRandom.current().nextInt(1, 42);

    	System.out.println("IntSupplier " + sup.getAsInt());
    	//T.2
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
       	System.out.println("\n---Fibonacci---");
       	IntSupplier fibo = new IntSupplier(){
       		int n1=0, n2=1, i = 0;

			@Override
			public int getAsInt() {
				if(i<2){
					i++;
					return i==1 ? 0 : 1;
				}
				int n3 = n1+n2;
				n1 = n2;
				n2 = n3;
				return n3;
			}
       	};

       	IntStream.generate(fibo).limit(10).forEach(n->System.out.println(n));


    }

}