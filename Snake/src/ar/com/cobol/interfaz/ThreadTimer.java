package ar.com.cobol.interfaz;

import static ar.com.cobol.resources.directionUtils.*;

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
				game.getSnake().get(0).desplazarVerticalmente(-game.getRad());
				game.reacomodarCuerpo();
			}
			
			if(game.getDireccion() == ABAJO) {
				game.getSnake().get(0).desplazarVerticalmente(game.getRad());
				game.reacomodarCuerpo();
			}
			
			if(game.getDireccion() == IZQUIERDA) {
				game.getSnake().get(0).desplazarHorizontalmente(-game.getRad());
				game.reacomodarCuerpo();
			}
			
			if(game.getDireccion() == DERECHA) {
				game.getSnake().get(0).desplazarHorizontalmente(game.getRad());
				game.reacomodarCuerpo();
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
