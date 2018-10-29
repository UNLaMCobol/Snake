package ar.com.cobol.interfaz;

import static ar.com.cobol.resources.directionUtils.*;

public class ThreadTimer extends Thread{
	
	private JVentanaGrafica game;
	
	public ThreadTimer(JVentanaGrafica game) {
		super();
		this.game = game;
	}
	
	public void run() {
		while(1==1) {
			
			try { sleep(1000); } catch (InterruptedException e) {}
			
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
		}
		
	}

}
