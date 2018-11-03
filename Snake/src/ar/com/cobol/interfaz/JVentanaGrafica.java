package ar.com.cobol.interfaz;

import javax.swing.JFrame;

import ar.com.cobol.figura.Circulo;
import ar.com.cobol.figura.Punto;

import java.awt.Color;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import static ar.com.cobol.resources.directionUtils.*;


public class JVentanaGrafica extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanelGrafico contentPane;
	private List<Circulo> snake;
	private Circulo fruta;
	private int rad;
	private Punto anterior;
	private int direccion;
	private ThreadTimer timer;
	private int[][] posMapaItems;
	private int[] posMapa;
	private int maxMap;
	
	public JVentanaGrafica() throws IOException {
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
		contentPane = new JPanelGrafico();
		setBackground(Color.WHITE);
	
		setContentPane(contentPane);
		
		setLocationRelativeTo(null);
		
		this.snake = contentPane.getSnake();
		this.fruta = contentPane.getFruta();
		this.rad = (int) this.snake.get(0).getRadio();
		this.anterior = this.snake.get(0).getCentro().clone();
		this.direccion = ARRIBA;
		this.posMapa = contentPane.getPosMapa();
		this.maxMap = contentPane.getMAX_MAP();
		this.posMapaItems = contentPane.getPosMapaItems();
		
	/*	for (int i = 0; i < posMapa.length; i++) {
			for (int j = 0; j < posMapa.length; j++) {
				System.out.print("i:" + i +"j:"+ j + "=" + this.posMapa[i][j] + "/");
			}
			System.out.println("");
		}*/
		
	
		
		this.timer = new ThreadTimer(this);
		
		setVisible(true);
		timer.start();
	}
	
	public int mirarSiHayFruta(int direc) {
		
		/*int posXSnake = this.snake.get(0).getCentro().getX();
		int posYSnake = this.snake.get(0).getCentro().getY();;
		int posXFruta = this.fruta.getCentro().getX();
		int posYFruta = this.fruta.getCentro().getY();*/
	
		
		if(direc == ARRIBA) {
			return posMapaItems[ this.snake.get(0).getCentro().getY()/MOVIMIENTO-1][ this.snake.get(0).getCentro().getX()/MOVIMIENTO];
			 
		}
		
		if(direc == ABAJO ) {
			return posMapaItems[ this.snake.get(0).getCentro().getY()/MOVIMIENTO+1][ this.snake.get(0).getCentro().getX()/MOVIMIENTO];
		}
		
		if(direc == IZQUIERDA) {
			return posMapaItems[ this.snake.get(0).getCentro().getY()/MOVIMIENTO][ this.snake.get(0).getCentro().getX()/MOVIMIENTO-1];
		}

		if(direc == DERECHA ) {
			return posMapaItems[ this.snake.get(0).getCentro().getY()/MOVIMIENTO][ this.snake.get(0).getCentro().getX()/MOVIMIENTO+1];
		}
		return 0;

	}
	
	public void agregarCuerpo() {
		Circulo nuevoCuerpo = this.fruta.clone();
		this.snake.add(0, nuevoCuerpo);
	}
	
	public void reacomodarCuerpo() {
		
		posMapaItems[this.snake.get(0).getCentro().getY()/MOVIMIENTO][this.snake.get(0).getCentro().getX()/MOVIMIENTO]=1;
		posMapaItems[this.snake.get(this.snake.size()-1).getCentro().getY()/MOVIMIENTO][this.snake.get(this.snake.size()-1).getCentro().getX()/MOVIMIENTO]=0;
		
		for (int i = 1; i < this.snake.size(); i++) {
			
			
			Punto aux = this.snake.get(i).getCentro().clone();
			this.snake.get(i).setCentro(this.anterior.clone());
			this.anterior = aux.clone();
			
		}
	
		contentPane.setSnake(this.snake);
		System.out.println("");
		for (int i = 0; i < posMapaItems.length; i++) {
			for (int j = 0; j < posMapaItems.length; j++) {
				System.out.print(posMapaItems[i][j] + " ");
			}
			System.out.println("");}
		System.out.println("");
		
	}
	
	public void reacomodarFruta() {
		
		posMapaItems[this.fruta.getCentro().getY()/MOVIMIENTO][this.fruta.getCentro().getX()/MOVIMIENTO]=1;
		
		Punto posFruta;
		Random r = new Random();
		do {
			posFruta = new Punto(this.posMapa[r.nextInt(posMapa.length)], this.posMapa[r.nextInt(posMapa.length)]);
		}while(posMapaItems[posFruta.getY()/MOVIMIENTO][posFruta.getX()/MOVIMIENTO]!=0);
		
		this.fruta.setCentro(posFruta);
		
		
		posMapaItems[this.fruta.getCentro().getY()/MOVIMIENTO][this.fruta.getCentro().getX()/MOVIMIENTO]=2;
		//this.fruta.setCentro(new Punto(new Random().nextInt(posMapa.length), new Random().nextInt(posMapa.length)));
		
	}
	
	public void refrescarAnterior() {
		this.anterior = this.snake.get(0).getCentro().clone();
	}
	
	
	
	public void matarViborita() {
		
		for (int i = 0; i < this.snake.size(); i++) {
			
			posMapaItems[this.snake.get(i).getCentro().getY()][this.snake.get(i).getCentro().getY()]=0;
		}
		
	}
	
	public void setMovimiento(KeyEvent evento){
		if(evento.getKeyCode() == KeyEvent.VK_A) {
			if(this.direccion == DERECHA)
				return;
			this.direccion = IZQUIERDA;
		}
		
		if(evento.getKeyCode() == KeyEvent.VK_D) {
			if(this.direccion == IZQUIERDA)
				return;
			this.direccion = DERECHA;
		}
		
		if(evento.getKeyCode() == KeyEvent.VK_W) {
			if(this.direccion == ABAJO)
				return;
			this.direccion = ARRIBA;
		}
		
		if(evento.getKeyCode() == KeyEvent.VK_S) {
			if(this.direccion == ARRIBA)
				return;
			this.direccion = ABAJO;
		}
	}
	
	public int seFueDeRango() {
		if(this.snake.get(0).getCentro().getX() > this.maxMap) {
			return DERECHA;
		}
		
		if(this.snake.get(0).getCentro().getX() < 0) {
			return IZQUIERDA;
		}
		
		if(this.snake.get(0).getCentro().getY() < 0) {
			return ARRIBA;
		}
		
		if(this.snake.get(0).getCentro().getY() > this.maxMap) {
			return ABAJO;
		}
		
		return -1;
	}
	
	public void pasarDeLado(int direc) {
		Punto pasaDeLado = null;
		if(direc == ARRIBA) {
			pasaDeLado = new Punto(this.snake.get(0).getCentro().getX(), this.maxMap);
		}
		if(direc == ABAJO) {
			pasaDeLado = new Punto(this.snake.get(0).getCentro().getX(), 0);
		}
		if(direc == IZQUIERDA) {
			pasaDeLado = new Punto(this.maxMap, this.snake.get(0).getCentro().getY());
		}
		if(direc == DERECHA) {
			pasaDeLado = new Punto(0, this.snake.get(0).getCentro().getY());
		}
		this.snake.get(0).setCentro(pasaDeLado);			
	}
	
	public void refrescarPantalla() {
		repaint();
	}

	public int getDireccion() {
		return direccion;
	}

	public List<Circulo> getSnake() {
		return snake;
	}

	public int getRad() {
		return rad;
	}

	public Circulo getFruta() {
		return fruta;
	}

	public static void main(String[] args) throws IOException {
		new JVentanaGrafica();
	}

}
