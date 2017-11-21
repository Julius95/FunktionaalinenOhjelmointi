package factory;

public class LaktoositonMeijeri extends AbstractMeijeri{

	public LaktoositonMeijeri(){
		super();
		maitoS = MaitoLaktoositon::new;
		jogurttiS = JogurttiLaktoositon::new;
		juustoS = JuustoLaktoositon::new;
	}


}
