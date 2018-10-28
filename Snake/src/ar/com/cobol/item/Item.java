package ar.com.cobol.item;

import ar.com.cobol.figura.Punto;
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
}
