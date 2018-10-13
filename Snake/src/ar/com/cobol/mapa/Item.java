package ar.com.cobol.mapa;

import ar.com.cobol.punto.Punto;
import ar.com.cobol.snake.Salamandra;

public abstract class Item {

	private Punto posicion;

	public Item(Punto posicion){
	    this.posicion = posicion;
    }

	public void handleItem(Salamandra salamandra){}
	

    public Punto getPosicion() {
        return posicion;
    }

	public void setPosicion(Punto posicion) {
		this.posicion = posicion;
	}
}
