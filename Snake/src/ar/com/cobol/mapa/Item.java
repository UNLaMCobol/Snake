package ar.com.cobol.mapa;

import ar.com.cobol.punto.Punto;
import ar.com.cobol.snake.Salamandra;

public abstract class Item {

	private Punto posicion;

	public void handleItem(Salamandra salamandra){}

    public Punto getPosicion() {
        return posicion;
    }
}
