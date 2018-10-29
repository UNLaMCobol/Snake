package ar.com.cobol.interfaz;

import static ar.com.cobol.resources.directionUtils.*;

import ar.com.cobol.figura.Circulo;
import ar.com.cobol.figura.Punto;

public class ThreadTimer extends Thread{
	
	private static int MIF = 10;	//MAKE IT FASTER
	private static int TIME = 1000;
	
	private JVentanaGrafica game;
	private int cont;
	
	public ThreadTimer(JVentanaGrafica game) {
		super();
		this.game = game;
		this.cont = 0;
	}
	
	public void run() {
		while(true) {
			
			try { sleep(TIME); } catch (InterruptedException e) {}
			
			game.refrescarAnterior();
			
			if(game.getDireccion() == ARRIBA) {
				if(game.mirarSiHayFruta(ARRIBA)) {
					game.agregarCuerpo();
					game.reacomodarFruta();
				}
				else {
					game.getSnake().get(0).desplazarVerticalmente(-game.getRad());
					game.reacomodarCuerpo();					
				}
			}
			
			if(game.getDireccion() == ABAJO) {
				if(game.mirarSiHayFruta(ABAJO)) {
					game.agregarCuerpo();
					game.reacomodarFruta();
				}
				else {
					game.getSnake().get(0).desplazarVerticalmente(game.getRad());
					game.reacomodarCuerpo();					
				}
			}
			
			if(game.getDireccion() == IZQUIERDA) {
				if(game.mirarSiHayFruta(IZQUIERDA)) {
					game.agregarCuerpo();
					game.reacomodarFruta();
				}
				else {
					game.getSnake().get(0).desplazarHorizontalmente(-game.getRad());
					game.reacomodarCuerpo();					
				}
			}
			
			if(game.getDireccion() == DERECHA) {
				if(game.mirarSiHayFruta(DERECHA)) {
					game.agregarCuerpo();
					game.reacomodarFruta();
				}
				else {
					game.getSnake().get(0).desplazarHorizontalmente(game.getRad());
					game.reacomodarCuerpo();					
				}
			}
			
//			int posXSnake = game.getSnake().get(0).getCentro().getX();
//			int posYSnake = game.getSnake().get(0).getCentro().getY();
//			int posXFruta = game.getFruta().getCentro().getX();
//			int posYFruta = game.getFruta().getCentro().getY();
//			
//			if(posXSnake == posXFruta && posYSnake == posYFruta) {
//				game.reacomodarFruta();
//				Circulo nuevoCuerpo = game.getSnake().get(game.getSnake().size()).clone();
//				game.getSnake().add(nuevoCuerpo);
//			}
			
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
