package ar.com.cobol;

import ar.com.cobol.figura.Punto;
import ar.com.cobol.mapa.Mapa;
import ar.com.cobol.snake.Salamandra;

import java.util.ArrayList;
import java.util.List;

import static ar.com.cobol.resources.directionUtils.*;

public class SalamandraGame {

    private Mapa mapa;
    private ArrayList<Salamandra> listSalamandra;

    public SalamandraGame(Mapa mapa, int cantJugadores){
        this.mapa = mapa;
        listSalamandra = new ArrayList<Salamandra>();

    }

    private void acomodarSalamandrasSegunCantJugadores(int cantJugadores){
        Punto posPj1 = new Punto(3, 5);
        Punto posPj2 = new Punto(7, 5);
        this.listSalamandra.add(new Salamandra(posPj1, 2, DERECHA));
        this.listSalamandra.add(new Salamandra(posPj2, 2, IZQUIERDA));
        if(cantJugadores > 2){
            Punto posPj3 = new Punto(5, 3);
            this.listSalamandra.add(new Salamandra(posPj3, 2, ABAJO));
            if(cantJugadores > 3){
                Punto posPj4 = new Punto(5, 7);
                this.listSalamandra.add(new Salamandra(posPj1, 2, ARRIBA));
            }
        }

        for(int i = 0; i < cantJugadores; i++){
            mapa.ubicarSalamandra((ArrayList<Punto>) listSalamandra.get(i).getCuerpo());
        }
    }

}