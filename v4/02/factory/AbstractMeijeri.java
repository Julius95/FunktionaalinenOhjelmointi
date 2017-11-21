package factory;


import java.util.function.Supplier;

public class AbstractMeijeri {
	protected Supplier<Maito> maitoS;
	protected Supplier<Juusto> juustoS;
	protected Supplier<Jogurtti> jogurttiS;

    public AbstractMeijeri(){}

    public Maito getMaito(){
    	return maitoS.get();
	}

    public Juusto getJuusto(){
    	return juustoS.get();
    }

    public Jogurtti getJogurtti(){
    	return jogurttiS.get();
    }

}
