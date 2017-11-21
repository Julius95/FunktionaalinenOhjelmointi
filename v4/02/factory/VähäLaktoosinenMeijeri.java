package factory;

public class V‰h‰LaktoosinenMeijeri extends AbstractMeijeri{
	public V‰h‰LaktoosinenMeijeri(){
		super();
		maitoS = MaitoV‰h‰Laktoosinen::new;
		jogurttiS = JogurttiV‰h‰Laktoosinen::new;
		juustoS = JuustoV‰h‰Laktoosinen::new;
	}
}
