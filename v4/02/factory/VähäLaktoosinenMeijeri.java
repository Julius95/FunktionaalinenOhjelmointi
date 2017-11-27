package factory;

public class VähäLaktoosinenMeijeri extends AbstractMeijeri{
	public VähäLaktoosinenMeijeri(){
		super();
		map.put("MAITO", MaitoVähäLaktoosinen::new);
        map.put("JOGURTTI", JogurttiVähäLaktoosinen::new);
        map.put("JUUSTO", JuustoVähäLaktoosinen::new);
	}
}
