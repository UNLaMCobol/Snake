package ar.com.cobol.snake;

import java.util.ArrayList;
import java.util.List;
import ar.com.cobol.figura.Circulo;
import ar.com.cobol.figura.Punto;

import static ar.com.cobol.resources.DirectionUtils.*;
import static ar.com.cobol.resources.DirectionUtils.Direcciones.*;

public class Salamandra{
	
	private List<Circulo> body;
	private Direcciones direccion;
//	private Punto ultPosCola;
//	private double modifVelocidad;
//	private Estado estado;
//	private int direccion;

	public Salamandra() {
		this.body = new ArrayList<Circulo>();
		direccion = DERECHA;
	}
	
	public void addBody(int pos, Circulo part) {
		body.add(pos, part);
	}
	
	public List<Circulo> getBody(){
		return this.body;
	}
	
	public void setBody(List<Circulo> body) {
		this.body = body;
	}
	
	public Direcciones getDireccion() {
		return this.direccion;
	}
	
	public void setDireccion(Direcciones direccion) {
		this.direccion = direccion;
	}
	
	public Punto getHeadPoint() {
		return this.body.get(0).getCentro();
	}
	
	public Punto getTailPoint() {
		return this.body.get(this.body.size() - 1).getCentro();
	}
	
}
