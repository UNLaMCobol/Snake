package ar.com.cobol.mapa;

import ar.com.cobol.snake.Salamandra;

public class Fruta extends Item{

    @Override
    public void handleItem(Salamandra salamandra){
        salamandra.addParteDelCuerpo();
    }

}
