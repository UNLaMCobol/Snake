package ar.com.cobol.snake;

import java.util.ArrayList;
import java.util.List;

import ar.com.cobol.punto.Punto;

public class Salamandra {
	
	private List<Punto> cuerpo;
	private double velocidad;
	private Estado estado;
	
	public Salamandra() {
		this.cuerpo = new ArrayList<Punto>();
		this.estado = new Normal();
	}

	public List<Punto> getCuerpo() {
		return cuerpo;
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
	
	
	
}
