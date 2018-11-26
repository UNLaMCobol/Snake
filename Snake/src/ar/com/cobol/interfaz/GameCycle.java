package ar.com.cobol.interfaz;

import static ar.com.cobol.resources.DirectionUtils.*;
import static ar.com.cobol.resources.DirectionUtils.Direcciones.*;
import static ar.com.cobol.mapa.ObjetosDelMapa.*;

public class GameCycle extends Thread{
	
	private static int MIF = 50;	//MAKE IT FASTER
	private static int TIME = 300;
	
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
			
			try {
				sleep(TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			try {
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
						
						game.getMapa().getSnake().getBody().get(0).desplazarVerticalmente(-1);
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
						game.getMapa().getSnake().getBody().get(0).desplazarVerticalmente(1);
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
						game.getMapa().getSnake().getBody().get(0).desplazarHorizontalmente(-1);
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
						game.getMapa().getSnake().getBody().get(0).desplazarHorizontalmente(1);
						game.getMapa().reacomodarCuerpo();					
					}
				}
			} catch(ArrayIndexOutOfBoundsException e) {
				if(game.getMapa().getSnake().getDireccion() == ARRIBA) {
					game.getMapa().pasarDeLado(ARRIBA);
				}
				if(game.getMapa().getSnake().getDireccion() == ABAJO) {
					game.getMapa().pasarDeLado(ABAJO);
				}
				if(game.getMapa().getSnake().getDireccion() == IZQUIERDA) {
					game.getMapa().pasarDeLado(IZQUIERDA);
				}
				if(game.getMapa().getSnake().getDireccion() == DERECHA) {
					game.getMapa().pasarDeLado(DERECHA);
				}
			} finally {				
				game.refrescarPantalla();
				
				this.cont++;
				if(TIME > 75 && this.cont == MIF) {
					MIF *= 2;
					TIME -= 100;
					if(TIME == 0)
						TIME = 75;
				}
			}
		}
		
	}

}
