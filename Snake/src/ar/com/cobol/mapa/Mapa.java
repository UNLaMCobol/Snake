package ar.com.cobol.mapa;

import java.util.HashMap;

public class Mapa {
	
	private static final int TAM = 10;
	
	private int[][] mapa = new int [TAM][TAM];
	private HashMap<Integer, Item> itemList;
	

	public void verMapa() {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa.length; j++) {
				System.out.print(this.mapa[i][j] + " ");
			}
			System.out.println();
		}
	}
}
