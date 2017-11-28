package factory;

public class V‰h‰LaktoosinenMeijeri extends AbstractMeijeri{
	public V‰h‰LaktoosinenMeijeri(){
		super();
		map.put("MAITO", MaitoV‰h‰Laktoosinen::new);
        map.put("JOGURTTI", JogurttiV‰h‰Laktoosinen::new);
        map.put("JUUSTO", JuustoV‰h‰Laktoosinen::new);
	}
}
