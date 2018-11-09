package ar.com.cobol.interfaz;

import javax.swing.JFrame;
import ar.com.cobol.mapa.MapaNormal;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static ar.com.cobol.resources.DirectionUtils.Direcciones.*;

public class GameWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private GameGraphics contentPane;
	private GameCycle timer;
	private MapaNormal mapa;
	
	public GameWindow() throws IOException {
		super("Ejemplo Básico de Graphics");
		setResizable(false);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				setMovimiento(arg0);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 480);
		contentPane = new GameGraphics();
		setBackground(Color.WHITE);
	
		setContentPane(contentPane);
		
		setLocationRelativeTo(null);
		
		this.mapa = contentPane.getMapa();
		
		this.timer = new GameCycle(this);
		
		setVisible(true);
		timer.start();
	}
	
	public void refrescarPantalla() {
		repaint();
	}
	
	public void setMovimiento(KeyEvent evento){
		if(evento.getKeyCode() == KeyEvent.VK_A) {
			this.mapa.setMovimiento(IZQUIERDA);
		}
		
		if(evento.getKeyCode() == KeyEvent.VK_D) {
			this.mapa.setMovimiento(DERECHA);
		}
		
		if(evento.getKeyCode() == KeyEvent.VK_W) {
			this.mapa.setMovimiento(ARRIBA);
		}
		
		if(evento.getKeyCode() == KeyEvent.VK_S) {
			this.mapa.setMovimiento(ABAJO);
		}
	}
	
	public MapaNormal getMapa() {
		return this.mapa;
	}
	
	public void closeGame() {
		this.dispose();
	}
	
//	public ObjetosDelMapa mirarSiHayItem(int direc) {
//		
//		/*int posXSnake = this.snake.get(0).getCentro().getX();
//		int posYSnake = this.snake.get(0).getCentro().getY();;
//		int posXFruta = this.fruta.getCentro().getX();
//		int posYFruta = this.fruta.getCentro().getY();*/
//	
//		
//		if(direc == ARRIBA) {
//			return this.mapa.getPosMapaItems()[ this.mapa.getSnake().getBody().get(0).getCentro().getY()/MOVIMIENTO-1][ this.mapa.getSnake().getBody().get(0).getCentro().getX()/MOVIMIENTO];
//			//return posMapaItems[ this.snake.get(0).getCentro().getY()/MOVIMIENTO-1][ this.snake.get(0).getCentro().getX()/MOVIMIENTO];
//		}
//		
//		if(direc == ABAJO ) {
//			return this.mapa.getPosMapaItems()[ this.mapa.getSnake().getBody().get(0).getCentro().getY()/MOVIMIENTO+1][ this.mapa.getSnake().getBody().get(0).getCentro().getX()/MOVIMIENTO];
////			return posMapaItems[ this.snake.get(0).getCentro().getY()/MOVIMIENTO+1][ this.snake.get(0).getCentro().getX()/MOVIMIENTO];
//		}
//		
//		if(direc == IZQUIERDA) {
//			return this.mapa.getPosMapaItems()[ this.mapa.getSnake().getBody().get(0).getCentro().getY()/MOVIMIENTO][ this.mapa.getSnake().getBody().get(0).getCentro().getX()/MOVIMIENTO-1];
////			return posMapaItems[ this.snake.get(0).getCentro().getY()/MOVIMIENTO][ this.snake.get(0).getCentro().getX()/MOVIMIENTO-1];
//		}
//
//		if(direc == DERECHA ) {
//			return this.mapa.getPosMapaItems()[ this.mapa.getSnake().getBody().get(0).getCentro().getY()/MOVIMIENTO][ this.mapa.getSnake().getBody().get(0).getCentro().getX()/MOVIMIENTO+1];
////			return posMapaItems[ this.snake.get(0).getCentro().getY()/MOVIMIENTO][ this.snake.get(0).getCentro().getX()/MOVIMIENTO+1];
//		}
//		return VACIO;
//	}
	
//	public void agregarCuerpo() {
//		Circulo nuevoCuerpo = this.mapa.getFruta().getItem().clone();
//		this.mapa.getSnake().getBody().add(0, nuevoCuerpo);
////		Circulo nuevoCuerpo = this.fruta.clone();
////		this.snake.add(0, nuevoCuerpo);
//	}
	
//	public void reacomodarCuerpo() {
//		
//		this.mapa.posMapaItems()[this.mapa.snake().getBody().get(0).getCentro().getY()/MOVIMIENTO][this.mapa.snake().getBody().get(0).getCentro().getX()/MOVIMIENTO] = SNAKE;
//		this.mapa.posMapaItems()[this.mapa.snake().getBody().get(this.mapa.snake().getBody().size()-1).getCentro().getY()/MOVIMIENTO][this.mapa.snake().getBody().get(this.mapa.snake().getBody().size()-1).getCentro().getX()/MOVIMIENTO] = VACIO;
////		posMapaItems[this.snake.get(0).getCentro().getY()/MOVIMIENTO][this.snake.get(0).getCentro().getX()/MOVIMIENTO] = SNAKE;
////		posMapaItems[this.snake.get(this.snake.size()-1).getCentro().getY()/MOVIMIENTO][this.snake.get(this.snake.size()-1).getCentro().getX()/MOVIMIENTO] = VACIO;
//		
//		for (int i = 1; i < this.mapa.snake().getBody().size(); i++) {
//			Punto aux = this.mapa.snake().getBody().get(i).getCentro().clone();
//			this.mapa.snake().getBody().get(i).setCentro(this.anterior.clone());
//			this.anterior = aux.clone();
//		}
//	
//		contentPane.setSnake(this.snake);
//		
//	}
	
//	public void reacomodarFruta() {
//		
//		posMapaItems[this.fruta.getCentro().getY()/MOVIMIENTO][this.fruta.getCentro().getX()/MOVIMIENTO] = SNAKE;
//		
//		Punto posFruta;
//		Random r = new Random();
//		do {
//			posFruta = new Punto(this.posMapa[r.nextInt(posMapa.length)], this.posMapa[r.nextInt(posMapa.length)]);
//		}while(posMapaItems[posFruta.getY()/MOVIMIENTO][posFruta.getX()/MOVIMIENTO] != VACIO);
//		
//		this.fruta.setCentro(posFruta);
//		
//		
//		posMapaItems[this.fruta.getCentro().getY()/MOVIMIENTO][this.fruta.getCentro().getX()/MOVIMIENTO] = FRUTA;
//		//this.fruta.setCentro(new Punto(new Random().nextInt(posMapa.length), new Random().nextInt(posMapa.length)));
//		
//	}
	
//	public void refrescarAnterior() {
//		this.anterior = this.snake.get(0).getCentro().clone();
//	}
	
	
//	
//	public void matarViborita() {
//		
//		for (int i = 0; i < this.snake.size(); i++) {
//			
//			posMapaItems[this.snake.get(i).getCentro().getY()][this.snake.get(i).getCentro().getY()] = VACIO;
//		}
//		
//	}
	
//	public int seFueDeRango() {
//		if(this.snake.get(0).getCentro().getX() > this.maxMap) {
//			return DERECHA;
//		}
//		
//		if(this.snake.get(0).getCentro().getX() < 0) {
//			return IZQUIERDA;
//		}
//		
//		if(this.snake.get(0).getCentro().getY() < 0) {
//			return ARRIBA;
//		}
//		
//		if(this.snake.get(0).getCentro().getY() > this.maxMap) {
//			return ABAJO;
//		}
//		
//		return -1;
//	}
	
//	public void pasarDeLado(int direc) {
//		Punto pasaDeLado = null;
//		if(direc == ARRIBA) {
//			pasaDeLado = new Punto(this.snake.get(0).getCentro().getX(), this.maxMap);
//		}
//		if(direc == ABAJO) {
//			pasaDeLado = new Punto(this.snake.get(0).getCentro().getX(), 0);
//		}
//		if(direc == IZQUIERDA) {
//			pasaDeLado = new Punto(this.maxMap, this.snake.get(0).getCentro().getY());
//		}
//		if(direc == DERECHA) {
//			pasaDeLado = new Punto(0, this.snake.get(0).getCentro().getY());
//		}
//		this.snake.get(0).setCentro(pasaDeLado);			
//	}

}
