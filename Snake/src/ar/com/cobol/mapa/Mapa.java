package ar.com.cobol.mapa;

import ar.com.cobol.snake.Salamandra;

import java.util.HashMap;

public class Mapa {
	
	private static final int TAM = 10;
	
	private int[][] mapa;
	private HashMap<Integer, Item> itemList;
	private HashMap<Integer, Salamandra> salamandraList;
	private int cantJugadores;

	public Mapa(int cantJugadores){
		this.mapa = new int[TAM][TAM];
		this.cantJugadores = cantJugadores;
		itemList = new HashMap<Integer, Item>();
		salamandraList = new HashMap<Integer, Salamandra>();
		for(int i = 1; i <= cantJugadores; i++){
			//salamandraList.;
		}

	}
	

	public void verMapa() {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa.length; j++) {
				System.out.print(this.mapa[i][j] + " ");
			}
			System.out.println();
		}
	}
}
