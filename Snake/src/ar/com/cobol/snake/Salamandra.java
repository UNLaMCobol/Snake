package ar.com.cobol.snake;

import java.util.ArrayList;
import java.util.List;

import ar.com.cobol.mapa.Item;
import ar.com.cobol.punto.Punto;
import static ar.com.cobol.resources.directionUtils.*;


public class Salamandra {


	private List<Punto> cuerpo;
	private Punto ultPosCola;
	private double velocidad;
	private Estado estado;
	private int direccion;

	public Salamandra(Punto p, int tam, int direc) {
		this.cuerpo = new ArrayList<Punto>();
		this.estado = new Normal();
		for (int i = 0; i < tam; i++) {
			if (IZQUIERDA == direc)
				this.cuerpo.add(p.generarBufanda(new Punto(-i, 0)));
			if (DERECHA == direc)
				this.cuerpo.add(p.generarBufanda(new Punto(i, 0)));
			if (ARRIBA == direc)
				this.cuerpo.add(p.generarBufanda(new Punto(0, i)));
			if (ABAJO == direc)
				this.cuerpo.add(p.generarBufanda(new Punto(0, -i)));
		}
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


	//Esto lo llamo antes de moverme, por si después consumo una fruta y tengo que agregar una nueva parte del cuerpo.
	//[Consumo -> Agrego] -> Guardo -> Muevo: Orden de acciones al mover.
	public void guardarUltPosCola(){
		this.ultPosCola = this.cuerpo.get(this.cuerpo.size() -1);	//Me guardo la última posición de la cola.
	}

	public void superponer(Item item){
		item.handleItem(this);
	}

	public void addParteDelCuerpo() {
		this.guardarUltPosCola();
		this.cuerpo.add(this.ultPosCola);
	}

	//La implementación de la velocidad es según el tiempo transcurrido de juego. Cuanto más pasa, más rapido irán las Salamandras.
	public void aumentarVelocidad(double value){
		this.velocidad += value;
	}

	public void cambiarDireccion(int direcNueva){
		if(direcNueva == this.direccion || sonOpuestos(direcNueva, this.direccion))
			return;
		this.direccion = direcNueva;
	}

	//TODO: Hacer una interfaz Dirección y hacer 4 clases para c/dirección que manejen los ejes c/u.
	public void moverse(){
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
