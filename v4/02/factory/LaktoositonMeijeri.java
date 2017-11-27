package factory;

public class LaktoositonMeijeri extends AbstractMeijeri{

	public LaktoositonMeijeri(){
		super();
		map.put("MAITO", MaitoLaktoositon::new);
        map.put("JOGURTTI", JogurttiLaktoositon::new);
        map.put("JUUSTO", JuustoLaktoositon::new);
	}


}
