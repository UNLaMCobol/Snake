package ar.com.cobol.mapa;

import ar.com.cobol.punto.Punto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapaNormal implements Mapa {

    private static final int TAM = 15;
    private Objeto[][] mapa = new Objeto[TAM][TAM];

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
		for (int i = 0; i < TAM; i++) {
			this.mapa[i][0] = Objeto.PARED;
			this.mapa[i][TAM - 1] = Objeto.PARED;
			this.mapa[0][i] = Objeto.PARED;
			this.mapa[TAM - 1][i] = Objeto.PARED;
		}
		
//        for(int i = 0; i < TAM; i++){
//            for(int j = 0; j < TAM; j++){
//                if(i == 0 || i == TAM-1 || j == 0 || j == TAM-1)
//                    this.mapa[i][j] = Objeto.COLICION;
//            }
//        }
    }

    @Override
    public void ubicarFruta() {
		Random r = new Random();
		int posX = r.nextInt(TAM - 2) + 1;
		int posY = r.nextInt(TAM - 2) + 1;
		while (getMapa()[posX][posY] == Objeto.PARED) {
			r = new Random();
			posX = r.nextInt(TAM - 2) + 1;
			posY = r.nextInt(TAM - 2) + 1;
		}
		this.mapa[posX][posY] = Objeto.FRUTA;
	}

    @Override
    public void ubicarSalamandra(ArrayList<Punto> cuerpo) {

    }
}
