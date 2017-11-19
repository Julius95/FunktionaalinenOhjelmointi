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

	public static Function<Piste,Piste> makeSiirto(int i, int j) {
		return (Piste p) -> new Piste(p.x + i, p.y + j);
	}

	public static Function<Piste, Piste> makeSkaalaus(int i) {
		return (Piste p) -> new Piste(p.x * i, p.y * i);
	}

	public static Function<Piste,Piste> makeKierto(double phi) {
		return (Piste p) -> new Piste(Math.round(p.x*Math.cos(phi*Math.PI/phi) - p.y * Math.sin(phi*Math.PI/phi)),
				Math.round(p.x*Math.sin(phi*Math.PI/phi) + p.y * Math.cos(phi*Math.PI/phi)));
	}

	@Override
	public String toString(){
		return x + " " + y;
	}


}
