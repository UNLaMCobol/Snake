package ar.com.cobol.mapa;

import ar.com.cobol.snake.Muerto;
import ar.com.cobol.snake.Salamandra;

public class Pared extends Item {

    @Override
    public void handleItem(Salamandra salamandra){
        salamandra.setEstado(new Muerto());
    }
}
