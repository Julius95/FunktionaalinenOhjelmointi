package factory;

public class Main {
	public static void main(String[] args) {
		AbstractMeijeri m1 = new LaktoositonMeijeri();
		m1.getTuote("JOGURTTI").print();
		m1.getTuote("MAITO").print();
		m1.getTuote("JUUSTO").print();
		m1 = new VähäLaktoosinenMeijeri();
		m1.getTuote("JOGURTTI").print();
		m1.getTuote("MAITO").print();
		m1.getTuote("JUUSTO").print();
	}
}
