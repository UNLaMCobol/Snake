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

	private int tam;
	private ObjetosDelMapa[][] mapa;
	private Salamandra snake;
	private Punto anterior;
	private Fruta fruta;

	public MapaNormal(int tam) {
		snake = new Salamandra();
		this.tam = tam;
		this.generarMatrizDeItemsEnElMapa();
		this.ubicarSalamandraEnElMapa();
		this.ubicarFrutaEnElMapa(this.buscoPosicionVaciaParaLaFruta());
		this.anterior = this.snake.getBody().get(0).getCentro().clone();
	}
	
	private void generarMatrizDeItemsEnElMapa() {
		this.mapa = new ObjetosDelMapa[this.tam][this.tam];
		for(int i = 0; i < this.mapa.length; i++) {
			for(int j = 0; j < this.mapa.length; j++) {
				this.mapa[i][j] = VACIO;
			}
		}
	}
	
	private void ubicarSalamandraEnElMapa() {
		for(int i = 1; i <= 2; i++) {
			snake.addBody(i-1, new Circulo(new Punto(3, i), TAMAÑO));
			mapa[i][3] = SNAKE;
		}
	}
	
	private Punto buscoPosicionVaciaParaLaFruta() {
		Random r = new Random();
		Punto posFruta;
		int x, y;
		do {
			x = r.nextInt(this.tam);
			y = r.nextInt(this.tam);
			posFruta = new Punto(x, y);
		} while(this.mapa[y][x] != VACIO);
		return posFruta;
	}
	
	private void ubicarFrutaEnElMapa(Punto posFruta) {
		this.fruta = new Fruta(new Circulo(posFruta, TAMAÑO));
		mapa[posFruta.getY()][posFruta.getX()] = FRUTA;
	}
	
	public ObjetosDelMapa mirarSiHayItem(Direcciones direc) {
		
		if(direc == ARRIBA) {
			return this.mapa[this.snake.getHeadPoint().getY() - 1]
									[this.snake.getHeadPoint().getX()];
		}
		
		if(direc == ABAJO) {
			return this.mapa[this.snake.getHeadPoint().getY() + 1]
									[this.snake.getHeadPoint().getX()];
		}
		
		if(direc == IZQUIERDA) {
			return this.mapa[this.snake.getHeadPoint().getY()]
									[this.snake.getHeadPoint().getX() - 1];
		}
		
		if(direc == DERECHA) {
			return this.mapa[this.snake.getHeadPoint().getY()]
									[this.snake.getHeadPoint().getX() + 1];
		}
		
		return VACIO;
	}

	public void agregarCuerpo() {
		Circulo nuevoCuerpo = this.fruta.getCirculo().clone();
		this.snake.addBody(0, nuevoCuerpo);
	}
	
	public void reacomodarCuerpo() {
		
		this.mapa[this.snake.getHeadPoint().getY()]
						 [this.snake.getHeadPoint().getX()] = SNAKE;
		
		this.mapa[this.snake.getTailPoint().getY()]
						 [this.snake.getTailPoint().getX()] = VACIO;
		
		for (int i = 1; i < this.snake.getBody().size(); i++) {
			Punto aux = this.snake.getBody().get(i).getCentro().clone();
			this.snake.getBody().get(i).setCentro(this.anterior.clone());
			this.anterior = aux.clone();
		}
	}

	public void reacomodarFruta() {
		mapa[this.fruta.getCirculo().getCentro().getY()]
					[this.fruta.getCirculo().getCentro().getX()] = SNAKE;
		
		this.ubicarFrutaEnElMapa(this.buscoPosicionVaciaParaLaFruta());
		
		mapa[this.fruta.getCirculo().getCentro().getY()]
					[this.fruta.getCirculo().getCentro().getX()] = FRUTA;
	}
	
	public void refrescarAnterior() {
		this.anterior = this.snake.getBody().get(0).getCentro().clone();
	}
	
	
	
	//TODO: REVISAR
	public void matarViborita() {
		for (int i = 0; i < this.snake.getBody().size(); i++) {
			mapa[this.snake.getBody().get(i).getCentro().getY()][this.snake.getBody().get(i).getCentro().getY()] = VACIO;
		}
	}
	
	public void setMovimiento(Direcciones direccion){
		if(opuesto(this.snake.getDireccion()) == direccion)
			return;
		this.snake.setDireccion(direccion);
	}
	
	public Direcciones seFueDeRango() {
		
		int posX = this.snake.getHeadPoint().getX();
		int posY = this.snake.getHeadPoint().getY();
		
		if(posX > this.mapa.length) {
			return DERECHA;
		}
		
		if(posX < 0) {
			return IZQUIERDA;
		}
		
		if(posY < 0) {
			return ARRIBA;
		}
		
		if(posY > this.mapa.length) {
			return ABAJO;
		}
		
		return null;
	}
	
	public void pasarDeLado(Direcciones direc) {
		Punto pasaDeLado = null;
		int posX = this.snake.getHeadPoint().getX();
		int posY = this.snake.getHeadPoint().getY();
		
		if(direc == ARRIBA) {
			pasaDeLado = new Punto(posX, this.mapa.length-1);
		}
		if(direc == ABAJO) {
			pasaDeLado = new Punto(posX, 0);
		}
		if(direc == IZQUIERDA) {
			pasaDeLado = new Punto(this.mapa.length-1, posY);
		}
		if(direc == DERECHA) {
			pasaDeLado = new Punto(0, posY);
		}
		this.snake.getBody().get(0).setCentro(pasaDeLado);			
	}
	

	public ObjetosDelMapa[][] getPosMapaItems() {
		return this.mapa;
	}

	public Salamandra getSnake() {
		return snake;
	}

	public Fruta getFruta() {
		return fruta;
	}
}
