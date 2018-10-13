package ar.com.cobol.snake;

import java.util.ArrayList;
import java.util.List;

import ar.com.cobol.item.Item;
import ar.com.cobol.punto.Punto;

import static ar.com.cobol.resources.directionUtils.*;


public class Salamandra{

	/*@Override
	public void handleItem(Salamandra salamandra){
		salamandra.setEstado(new Muerto());
	}*/

	private ArrayList<Punto> cuerpo;
	private Punto ultPosCola;
	private double modifVelocidad;
	private Estado estado;
	private int direccion;

	//TODO: REVISAR EL TEMA DE LA POSICION INICIAL DE LA SALAMANDRA
	public Salamandra(Punto p, int tam, int direc) {
		this.cuerpo = new ArrayList<Punto>();
		this.estado = new Normal();
		for (int i = 0; i < tam; i++) {
			if (IZQUIERDA == direc)
				this.cuerpo.add(p.generarPuntoAdyacente(new Punto(-i, 0)));
			if (DERECHA == direc)
				this.cuerpo.add(p.generarPuntoAdyacente(new Punto(i, 0)));
			if (ARRIBA == direc)
				this.cuerpo.add(p.generarPuntoAdyacente(new Punto(0, i)));
			if (ABAJO == direc)
				this.cuerpo.add(p.generarPuntoAdyacente(new Punto(0, -i)));
		}
		this.ultPosCola = this.cuerpo.get(this.cuerpo.size() - 1);

		// this.cuerpo.add(p);
		// this.cuerpo.add(new Punto(p.getX()-1, p.getY()));
	}
	

	public List<Punto> getCuerpo() {
		return  cuerpo;
	}

	public void setCuerpo(ArrayList<Punto> cuerpo) {
		this.cuerpo = cuerpo;
	}

	public double getmodifVelocidad() {
		return modifVelocidad;
	}

	public void setmodifVelocidad(double modifVelocidad) {
		this.modifVelocidad = modifVelocidad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Punto getUltPosCola() {
		return ultPosCola;
	}

	public void setUltPosCola(Punto ultPosCola) {
		this.ultPosCola = ultPosCola;
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	//Esto lo llamo antes de moverme, por si después consumo una fruta y tengo que agregar una nueva parte del cuerpo.
	//[Consumo -> Agrego] -> Guardo -> Muevo: Orden de acciones al mover.
	public void guardarUltPosCola(){
		this.ultPosCola = this.cuerpo.get(this.cuerpo.size() -1);	//Me guardo la última posición de la cola.
	}

	public void superponer(Item item){
		item.handleItem(this);
	}

	public void addParteDelCuerpo() {
		this.cuerpo.add(this.ultPosCola);
	}

	//La implementación de la modifVelocidad es según el tiempo transcurrido de juego. Cuanto más pasa, más rapido irán las Salamandras.
	public void aumentarmodifVelocidad(double value){
		this.modifVelocidad += value;
	}

	public void cambiarDireccion(int direcNueva){
		if(direcNueva == this.direccion || sonOpuestos(direcNueva, this.direccion))
			return;
		this.direccion = direcNueva;
	}

	//TODO: Hacer una interfaz Dirección y hacer 4 clases para c/dirección que manejen los ejes c/u.
	public void moverse(){

		if(this.direccion == QUIETO)
			return;

		this.ultPosCola = this.cuerpo.get(this.cuerpo.size() - 1);

		if(this.direccion == IZQUIERDA){
			this.cuerpo.add(0, new Punto(this.cuerpo.get(0).getX() + MOVER_IZQ_O_ABAJO, this.cuerpo.get(0).getY()));
			this.cuerpo.remove(this.cuerpo.size() - 1);
		}
		if(this.direccion == ABAJO){
			this.cuerpo.add(0, new Punto(this.cuerpo.get(0).getX(), this.cuerpo.get(0).getY() + MOVER_IZQ_O_ABAJO));
			this.cuerpo.remove(this.cuerpo.size() - 1);
		}
		if(this.direccion == DERECHA){
			this.cuerpo.add(0, new Punto(this.cuerpo.get(0).getX() + MOVER_DER_O_ARRIBA, this.cuerpo.get(0).getY()));
			this.cuerpo.remove(this.cuerpo.size() - 1);
		}
		if(this.direccion == ARRIBA){
			this.cuerpo.add(0, new Punto(this.cuerpo.get(0).getX(), this.cuerpo.get(0).getY() + MOVER_DER_O_ARRIBA));
			this.cuerpo.remove(this.cuerpo.size() - 1);
		}
	}
	
}
