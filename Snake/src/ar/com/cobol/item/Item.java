package ar.com.cobol.item;

import ar.com.cobol.figura.Circulo;
import ar.com.cobol.figura.Punto;
import ar.com.cobol.snake.Salamandra;

public abstract class Item {

	private Circulo circulo;

	public Item(Circulo item){
	    this.circulo = item;
    }

	public void handleItem(Salamandra salamandra){}

    public Circulo getCirculo() {
        return circulo;
    }
}
