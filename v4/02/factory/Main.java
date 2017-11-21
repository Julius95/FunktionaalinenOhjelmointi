package factory;

public class Main {
	public static void main(String[] args) {
		AbstractMeijeri m1 = new LaktoositonMeijeri();
		m1.getJogurtti().print();
		m1.getMaito().print();
		m1.getJuusto().print();
		m1 = new V‰h‰LaktoosinenMeijeri();
		m1.getJogurtti().print();
		m1.getMaito().print();
		m1.getJuusto().print();
	}
}
