package ar.com.cobol.item;

import ar.com.cobol.figura.Circulo;
import ar.com.cobol.figura.Punto;
import ar.com.cobol.snake.Salamandra;

public abstract class Item {

	private Circulo item;

	public Item(Circulo item){
	    this.item = item;
    }

	public void handleItem(Salamandra salamandra){}

    public Circulo getItem() {
        return item;
    }
}
