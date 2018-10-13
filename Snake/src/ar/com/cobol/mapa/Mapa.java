package ar.com.cobol.mapa;

import ar.com.cobol.item.Item;
import ar.com.cobol.punto.Punto;
import ar.com.cobol.snake.Salamandra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Mapa {

	static final int ESPACIO = 0;
    static final int FRUTA = 6;
    static final int PARED = 5;

    public void fomarMapa();
	public int[][] getMapa();
	public int getTAM();
	public void ubicarFruta();
	public void ubicarSalamandra(ArrayList<Punto> cuerpo);


}
