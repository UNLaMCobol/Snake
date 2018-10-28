package ar.com.cobol.punto;

public class Punto {

	private int x, y;

	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void resetXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double distanciaCon(Punto p) {
		return (double) Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Punto generarPuntoAdyacente(Punto punto) {
		return new Punto(this.getX() + punto.getX(), this.getY() + punto.getY());
	}
	
	public void desplazar(int delta_x, int delta_y) {
		this.x += delta_x;
		this.y += delta_y;
	}

	public String mostrarPunto() {
		return "( " + x + " , " + y + " )";		
	}

}
