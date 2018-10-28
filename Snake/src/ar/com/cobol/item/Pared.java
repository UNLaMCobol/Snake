package ar.com.cobol.item;

import ar.com.cobol.figura.Punto;
import ar.com.cobol.snake.Muerto;
import ar.com.cobol.snake.Salamandra;

public class Pared extends Item {

    public Pared(Punto posicion){
        super(posicion);
    }

    @Override
    public void handleItem(Salamandra salamandra){
        salamandra.setEstado(new Muerto());
    }
}
