package factory;

public class VähäLaktoosinenMeijeri extends AbstractMeijeri{
	public VähäLaktoosinenMeijeri(){
		super();
		maitoS = MaitoVähäLaktoosinen::new;
		jogurttiS = JogurttiVähäLaktoosinen::new;
		juustoS = JuustoVähäLaktoosinen::new;
	}
}
