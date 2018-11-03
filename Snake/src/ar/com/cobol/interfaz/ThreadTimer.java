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
				if(game.mirarSiHayFruta(ARRIBA)==2) {
					game.agregarCuerpo();
					game.reacomodarFruta();
				}
				else if(game.mirarSiHayFruta(ARRIBA)==1){
					System.out.println("PERDISTEEEEE");
					MIF=0;
				}
				else{
					
					game.getSnake().get(0).desplazarVerticalmente(-game.getRad());
					game.reacomodarCuerpo();					
				}
			}
			
			if(game.getDireccion() == ABAJO) {
				if(game.mirarSiHayFruta(ABAJO)==2) {
					game.agregarCuerpo();
					game.reacomodarFruta();
				}
				else if(game.mirarSiHayFruta(ABAJO)==1){
					System.out.println("PERDISTEEEEE");
					MIF=0;
				}else {
					game.getSnake().get(0).desplazarVerticalmente(game.getRad());
					game.reacomodarCuerpo();					
				}
			}
			
			if(game.getDireccion() == IZQUIERDA) {
				if(game.mirarSiHayFruta(IZQUIERDA)==2) {
					game.agregarCuerpo();
					game.reacomodarFruta();
				}
				else if(game.mirarSiHayFruta(IZQUIERDA)==1){
					System.out.println("PERDISTEEEEE");
					MIF=0;
				}else {
					game.getSnake().get(0).desplazarHorizontalmente(-game.getRad());
					game.reacomodarCuerpo();					
				}
			}
			
			if(game.getDireccion() == DERECHA) {
				if(game.mirarSiHayFruta(DERECHA)==2) {
					game.agregarCuerpo();
					game.reacomodarFruta();
				}
				else if(game.mirarSiHayFruta(DERECHA)==1){
					System.out.println("PERDISTEEEEE");
					MIF=0;
				}else {
					game.getSnake().get(0).desplazarHorizontalmente(game.getRad());
					game.reacomodarCuerpo();					
				}
			}
			
			if(game.seFueDeRango() == ARRIBA) {
				game.pasarDeLado(ARRIBA);
			}
			if(game.seFueDeRango() == ABAJO) {
				game.pasarDeLado(ABAJO);
			}
			if(game.seFueDeRango() == IZQUIERDA) {
				game.pasarDeLado(IZQUIERDA);
			}
			if(game.seFueDeRango() == DERECHA) {
				game.pasarDeLado(DERECHA);
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
