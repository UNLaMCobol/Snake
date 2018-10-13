package ar.com.cobol.mapa;

import java.util.Random;

public class MapaNormal implements Mapa {

    private static final int TAM = 15;
    private int[][] mapa;

    public MapaNormal(){
        this.mapa = new int[TAM][TAM];
    }

    public int getTAM() {
        return TAM;
    }

    public int[][] getMapa() {
        return mapa;
    }

    @Override
    public void fomarMapa() {
        for(int i = 0; i < TAM; i++){
            for(int j = 0; j < TAM; j++){
                if(i == 0 || i == TAM-1 || j == 0 || j == TAM-1)
                    this.mapa[i][j] = PARED;
            }
        }
    }

    @Override
    public void ubicarFruta() {
        Random r = new Random();
        int posX = r.nextInt(13)+1;
        int posY = r.nextInt(13)+1;
        this.mapa[posX][posY] = FRUTA;
    }
}
