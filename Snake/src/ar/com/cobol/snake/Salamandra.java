package ar.com.cobol.snake;

import java.util.ArrayList;
import java.util.List;

import ar.com.cobol.punto.Punto;

public class Salamandra {
	
	private List<Punto> cuerpo;
	private double velocidad;
	private Estado estado;
	
	public Salamandra(Punto p) {
		this.cuerpo = new ArrayList<Punto>();
		this.estado = new Normal();
		this.cuerpo.add(p);
		this.cuerpo.add(new Punto(p.getX()-1, p.getY()));
	}
	

	public List<Punto> getCuerpo() {
		return  cuerpo;
	}

	public void setCuerpo(List<Punto> cuerpo) {
		this.cuerpo = cuerpo;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	/**
	 * 
	 * @param p es el punto que se le asignará a la cabeza
	 * 
	 * Este metodo le asigna p a la cabeza y 
	 * el punto de la cabeza se lo asigna a la siguente parte del cuerpo
	 *  
	 */
//	public void addParteDelCuerpo(Punto p) {
//		Punto puntoCuerpo = new Punto(this.getCuerpo().get(0).getX(), this.getCuerpo().get(0).getY());
//		this.getCuerpo().get(0).resetXY(p.getX(), p.getY());
//		for (int i = 1; i < this.getCuerpo().size() - 1; i++) {
//			
//		}
//		
//		
//		this.getCuerpo().add(puntoCuerpo);
//	}
	
	
	
}
