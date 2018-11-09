package ar.com.cobol.mapa;

import static ar.com.cobol.resources.DirectionUtils.*;
import static ar.com.cobol.resources.DirectionUtils.Direcciones.*;
import java.util.Random;
import ar.com.cobol.figura.Circulo;
import ar.com.cobol.figura.Punto;
import ar.com.cobol.item.Fruta;
import ar.com.cobol.snake.Salamandra;

import static ar.com.cobol.mapa.ObjetosDelMapa.*;

public class MapaNormal implements Mapa {

	private static final int MAX_MAP = 400;

	private int[] posMapa;
	private ObjetosDelMapa[][] posMapaItems;
	private Salamandra snake;
	private Punto anterior;
	private Fruta fruta;

	public MapaNormal() {
		snake = new Salamandra();
		this.generarVectorDePosicionesValidas();
		this.generarMatrizDeItemsEnElMapa();
		this.ubicarSalamandraEnElMapa();
		this.ubicarFrutaEnElMapa(this.buscoPosicionVaciaParaLaFruta());
		this.anterior = this.snake.getBody().get(0).getCentro().clone();
	}

	private void generarVectorDePosicionesValidas() {
		this.posMapa = new int[(MAX_MAP / MOVIMIENTO) + 1];
		this.posMapa[0] = 0;
		for (int i = 1; i < this.posMapa.length; i++) {
			this.posMapa[i] = this.posMapa[i - 1] + MOVIMIENTO;
		}
	}

	private void generarMatrizDeItemsEnElMapa() {
		this.posMapaItems = new ObjetosDelMapa[(MAX_MAP / MOVIMIENTO) + 1][(MAX_MAP / MOVIMIENTO) + 1];
		for (int i = 0; i < this.posMapaItems.length; i++) {
			for (int j = 0; j < this.posMapaItems.length; j++) {
				this.posMapaItems[i][j] = VACIO;
			}
		}
	}

	private void ubicarSalamandraEnElMapa() {
		for (int i = 0; i <= MOVIMIENTO * 3; i += MOVIMIENTO) {
			snake.addBody(i/MOVIMIENTO, new Circulo(new Punto(100, i), MOVIMIENTO));
			posMapaItems[i / MOVIMIENTO][100 / MOVIMIENTO] = SNAKE;
		}
	}

	private Punto buscoPosicionVaciaParaLaFruta() {
		Random r = new Random();
		Punto posFruta;
		do {
			posFruta = new Punto(this.posMapa[r.nextInt(posMapa.length)], this.posMapa[r.nextInt(posMapa.length)]);
		} while (posMapaItems[posFruta.getY() / MOVIMIENTO][posFruta.getX() / MOVIMIENTO] != VACIO);
		return posFruta;
	}

	private void ubicarFrutaEnElMapa(Punto posFruta) {
		this.fruta = new Fruta(new Circulo(posFruta, MOVIMIENTO));
		posMapaItems[posFruta.getY() / MOVIMIENTO][posFruta.getX() / MOVIMIENTO] = FRUTA;
	}

	public ObjetosDelMapa mirarSiHayItem(Direcciones direc) {

		if (direc == ARRIBA) {
			return this.getPosMapaItems()[this.snake.getBody().get(0).getCentro().getY() / MOVIMIENTO - 1][this.snake
					.getBody().get(0).getCentro().getX() / MOVIMIENTO];
		}

		if (direc == ABAJO) {
			return this.getPosMapaItems()[this.snake.getBody().get(0).getCentro().getY() / MOVIMIENTO + 1][this.snake
					.getBody().get(0).getCentro().getX() / MOVIMIENTO];
		}

		if (direc == IZQUIERDA) {
			return this.getPosMapaItems()[this.snake.getBody().get(0).getCentro().getY()
					/ MOVIMIENTO][this.snake.getBody().get(0).getCentro().getX() / MOVIMIENTO - 1];
		}

		if (direc == DERECHA) {
			return this.getPosMapaItems()[this.snake.getBody().get(0).getCentro().getY()
					/ MOVIMIENTO][this.snake.getBody().get(0).getCentro().getX() / MOVIMIENTO + 1];
		}
		return VACIO;
	}

	public void agregarCuerpo() {
		Circulo nuevoCuerpo = this.fruta.getItem().clone();
		this.snake.addBody(0, nuevoCuerpo);
	}

	public void reacomodarCuerpo() {

		this.posMapaItems[this.snake.getBody().get(0).getCentro().getY() / MOVIMIENTO][this.snake.getBody().get(0)
				.getCentro().getX() / MOVIMIENTO] = SNAKE;
		this.posMapaItems[this.snake.getBody().get(this.snake.getBody().size() - 1).getCentro().getY()
				/ MOVIMIENTO][this.snake.getBody().get(this.snake.getBody().size() - 1).getCentro().getX()
						/ MOVIMIENTO] = VACIO;

		for (int i = 1; i < this.snake.getBody().size(); i++) {
			Punto aux = this.snake.getBody().get(i).getCentro().clone();
			this.snake.getBody().get(i).setCentro(this.anterior.clone());
			this.anterior = aux.clone();
		}
	}

	public void reacomodarFruta() {
		posMapaItems[this.fruta.getItem().getCentro().getY() / MOVIMIENTO][this.fruta.getItem().getCentro().getX()
				/ MOVIMIENTO] = SNAKE;

		this.ubicarFrutaEnElMapa(this.buscoPosicionVaciaParaLaFruta());

		posMapaItems[this.fruta.getItem().getCentro().getY() / MOVIMIENTO][this.fruta.getItem().getCentro().getX()
				/ MOVIMIENTO] = FRUTA;
	}

	public void refrescarAnterior() {
		this.anterior = this.snake.getBody().get(0).getCentro().clone();
	}
	
	//TODO: REVISAR
	public void matarViborita() {
		for (int i = 0; i < this.snake.getBody().size(); i++) {
			posMapaItems[this.snake.getBody().get(i).getCentro().getY()][this.snake.getBody().get(i).getCentro().getY()] = VACIO;
		}
	}
	
	public void setMovimiento(Direcciones direccion){
		if(opuesto(this.snake.getDireccion()) == direccion)
			return;
		this.snake.setDireccion(direccion);
	}
	
	public Direcciones seFueDeRango() {
		if(this.snake.getBody().get(0).getCentro().getX() > MAX_MAP) {
			return DERECHA;
		}
		
		if(this.snake.getBody().get(0).getCentro().getX() < 0) {
			return IZQUIERDA;
		}
		
		if(this.snake.getBody().get(0).getCentro().getY() < 0) {
			return ARRIBA;
		}
		
		if(this.snake.getBody().get(0).getCentro().getY() > MAX_MAP) {
			return ABAJO;
		}
		
		return null;
	}
	
	@Deprecated
	public void pasarDeLado(Direcciones direc) {
		Punto pasaDeLado = null;
		if(direc == ARRIBA) {
			pasaDeLado = new Punto(this.snake.getBody().get(0).getCentro().getX(), MAX_MAP);
		}
		if(direc == ABAJO) {
			pasaDeLado = new Punto(this.snake.getBody().get(0).getCentro().getX(), 0);
		}
		if(direc == IZQUIERDA) {
			pasaDeLado = new Punto(MAX_MAP, this.snake.getBody().get(0).getCentro().getY());
		}
		if(direc == DERECHA) {
			pasaDeLado = new Punto(0, this.snake.getBody().get(0).getCentro().getY());
		}
		this.snake.getBody().get(0).setCentro(pasaDeLado);			
	}
	

	public ObjetosDelMapa[][] getPosMapaItems() {
		return this.posMapaItems;
	}

	public Salamandra getSnake() {
		return snake;
	}

	public Fruta getFruta() {
		return fruta;
	}

	public int[] getPosMapa() {
		return this.posMapa;
	}

}
