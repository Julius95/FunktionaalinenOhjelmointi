import java.util.function.Function;

public class Piste {
	private double x,y;

	public Piste(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public static Function makeSiirto(int i, int j) {
		Function<Piste, Piste> siirra = (Piste p) -> {
			p.setX(i+p.getX());
			p.setY(j+p.getY());
			return p;
		};
		return siirra;
	}

	public static Function makeSkaalaus(int i) {
		Function<Piste, Piste> skaalaa = (Piste p) -> {
			p.setX(i*p.getX());
			p.setY(i*p.getY());
			return p;
		};
		return skaalaa;
	}

	public static Function makeKierto(double phi) {
		Function<Piste, Piste> kierra = (Piste p) -> {
			p.setX(Math.round(p.x*Math.cos(phi*Math.PI/phi) - p.y * Math.sin(phi*Math.PI/phi)));
			p.setY(Math.round(p.x*Math.sin(phi*Math.PI/phi) + p.y * Math.cos(phi*Math.PI/phi)));
			return p;
		};
		return kierra;
	}

	@Override
	public String toString(){
		return x + " " + y;
	}


}
