package ar.com.cobol.mapa;

import ar.com.cobol.punto.Punto;
import ar.com.cobol.snake.Salamandra;

public class Fruta extends Item{

    public Fruta(Punto posicion){
        super(posicion);
    }

    @Override
    public void handleItem(Salamandra salamandra){
        salamandra.addParteDelCuerpo();
    }

}
