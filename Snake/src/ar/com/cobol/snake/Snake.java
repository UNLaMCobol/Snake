package ar.com.cobol.snake;

public class Snake {
	
	private final static int LONG_INI = 4;
	private final static int VEL_INI = 1;
	
	private int longitud, velocidad;
	
	public Snake(){
		this.longitud = LONG_INI;
		this.velocidad = VEL_INI;
	}
	
	public Snake(int lon, int vel) {
		this.longitud = lon;
		this.velocidad = vel;
	}
	
	public void incrementarVelocidad() {
		this.velocidad++;
	}
	
	public void incrementarLongitud() {
		this.longitud++;
	}

	public int getLongitud() {
		return longitud;
	}

	public int getVelocidad() {
		return velocidad;
	}

}
