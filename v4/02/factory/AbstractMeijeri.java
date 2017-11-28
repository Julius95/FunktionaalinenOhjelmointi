package factory;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AbstractMeijeri {
	Map<String, Supplier<Tuote>> map;

    public AbstractMeijeri(){
    	map = new HashMap<>();
    }

    public Tuote getTuote(String nimi){
    	Supplier<Tuote> shape = map.get(nimi.toUpperCase());
        if(shape != null) {
          return shape.get();
        }
        throw new IllegalArgumentException("No such shape " + nimi.toUpperCase());
    }

}
