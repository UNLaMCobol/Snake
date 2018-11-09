package ar.com.cobol.interfaz;

import static ar.com.cobol.resources.DirectionUtils.*;
import static ar.com.cobol.resources.DirectionUtils.Direcciones.*;
import static ar.com.cobol.mapa.ObjetosDelMapa.*;

public class GameCycle extends Thread{
	
	private static int MIF = 10;	//MAKE IT FASTER
	private static int TIME = 1000;
	
	private GameWindow game;
	private int cont;
	
	public GameCycle(GameWindow game) {
		super();
		this.game = game;
		this.cont = 0;
	}
	
	@SuppressWarnings("deprecation")
	public void run() {
		while(true) {
			
			try { sleep(TIME); } catch (InterruptedException e) {}
			
			game.getMapa().refrescarAnterior();
			
			if(game.getMapa().getSnake().getDireccion() == ARRIBA) {
				if(game.getMapa().mirarSiHayItem(ARRIBA) == FRUTA) {
					game.getMapa().agregarCuerpo();
					game.getMapa().reacomodarFruta();
				}
				else if(game.getMapa().mirarSiHayItem(ARRIBA) == SNAKE){
					game.dispose();
					MIF=0;
				}
				else{
					
					game.getMapa().getSnake().getBody().get(0).desplazarVerticalmente(-MOVIMIENTO);
					game.getMapa().reacomodarCuerpo();					
				}
			}
			
			if(game.getMapa().getSnake().getDireccion() == ABAJO) {
				if(game.getMapa().mirarSiHayItem(ABAJO) == FRUTA) {
					game.getMapa().agregarCuerpo();
					game.getMapa().reacomodarFruta();
				}
				else if(game.getMapa().mirarSiHayItem(ABAJO) == SNAKE){
					game.dispose();
					MIF=0;
				}else {
					game.getMapa().getSnake().getBody().get(0).desplazarVerticalmente(MOVIMIENTO);
					game.getMapa().reacomodarCuerpo();					
				}
			}
			
			if(game.getMapa().getSnake().getDireccion() == IZQUIERDA) {
				if(game.getMapa().mirarSiHayItem(IZQUIERDA) == FRUTA) {
					game.getMapa().agregarCuerpo();
					game.getMapa().reacomodarFruta();
				}
				else if(game.getMapa().mirarSiHayItem(IZQUIERDA) == SNAKE){
					game.dispose();
					MIF=0;
				}else {
					game.getMapa().getSnake().getBody().get(0).desplazarHorizontalmente(-MOVIMIENTO);
					game.getMapa().reacomodarCuerpo();					
				}
			}
			
			if(game.getMapa().getSnake().getDireccion() == DERECHA) {
				if(game.getMapa().mirarSiHayItem(DERECHA) == FRUTA) {
					game.getMapa().agregarCuerpo();
					game.getMapa().reacomodarFruta();
				}
				else if(game.getMapa().mirarSiHayItem(DERECHA) == SNAKE){
					game.dispose();
					MIF=0;
				}else {
					game.getMapa().getSnake().getBody().get(0).desplazarHorizontalmente(MOVIMIENTO);
					game.getMapa().reacomodarCuerpo();					
				}
			}
			
			if(game.getMapa().seFueDeRango() == ARRIBA) {
				game.getMapa().pasarDeLado(ARRIBA);
			}
			if(game.getMapa().seFueDeRango() == ABAJO) {
				game.getMapa().pasarDeLado(ABAJO);
			}
			if(game.getMapa().seFueDeRango() == IZQUIERDA) {
				game.getMapa().pasarDeLado(IZQUIERDA);
			}
			if(game.getMapa().seFueDeRango() == DERECHA) {
				game.getMapa().pasarDeLado(DERECHA);
			}
			
			game.refrescarPantalla();
			
			this.cont++;
			if(TIME > 100 && this.cont == MIF) {
				MIF *= 2;
				TIME -= 200;
				if(TIME == 0)
					TIME = 100;
			}
		}
		
	}

}
