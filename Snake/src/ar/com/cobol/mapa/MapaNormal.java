package ar.com.cobol.mapa;

import ar.com.cobol.punto.Punto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapaNormal implements Mapa {

    private static final int TAM = 15;
    private Objeto[][] mapa;

    public MapaNormal(){
    	for (int i = 0; i < TAM; i++) {
    		for (int j = 0; j < TAM; j++) {
				this.mapa[i][j] = Objeto.ESPACIO;
			}
		}
    }

    public int getTAM() {
        return TAM;
    }

    public Objeto[][] getMapa() {
        return mapa;
    }

    @Override
    public void fomarMapa() {
        for(int i = 0; i < TAM; i++){
            for(int j = 0; j < TAM; j++){
                if(i == 0 || i == TAM-1 || j == 0 || j == TAM-1)
                    this.mapa[i][j] = Objeto.COLICION;
            }
        }
    }

    @Override
    public void ubicarFruta() {
        Random r = new Random();
        int posX = r.nextInt(13)+1;
        int posY = r.nextInt(13)+1;
        this.mapa[posX][posY] = Objeto.FRUTA;
    }

    @Override
    public void ubicarSalamandra(ArrayList<Punto> cuerpo) {

    }
}
