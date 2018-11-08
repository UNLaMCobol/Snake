package ar.com.cobol.interfaz;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import ar.com.cobol.figura.Circulo;
import ar.com.cobol.figura.Punto;
import ar.com.cobol.mapa.MapaNormal;

import static ar.com.cobol.resources.directionUtils.*;

public class JPanelGrafico extends JPanel {
	
	private static final int MAX_MAP = 400;

	private static final long serialVersionUID = 1L;
	private List<Circulo> snake;
	private Circulo fruta;
	//private int[] posMapa /*= {0, 50, 100, 150, 200, 250, 300, 350, 400}*/;
	private int[] posMapa;
	private int[][] posMapaItems;
	private Random r;
	private BufferedImage head;
	private BufferedImage body;
	private BufferedImage fruit;

	public JPanelGrafico() throws IOException {
		r = new Random();
		
		
		int cont = 0;
		posMapa = new int[(MAX_MAP/MOVIMIENTO) + 1];
		posMapa[0] = 0;
		for (int i = 1; i < posMapa.length; i++) {
			posMapa[i] = posMapa[i-1] + MOVIMIENTO;
		}
		
		posMapaItems  = new int[(MAX_MAP/MOVIMIENTO) + 1][(MAX_MAP/MOVIMIENTO) + 1];
		for (int i = 0; i < posMapaItems.length; i++) {
			for (int j = 0; j < posMapaItems.length; j++) {
				posMapaItems[i][j] = 0;
			}
		}
		
		
		this.snake = new ArrayList<Circulo>();
		for (int i = 40; i <= 80; i+=20) {
			snake.add(new Circulo(new Punto(100, i), 20));
			
			posMapaItems[i/MOVIMIENTO][100/MOVIMIENTO]=1;
			
		}
		
		
		Punto posFruta;
		do {
			posFruta = new Punto(this.posMapa[r.nextInt(posMapa.length)], this.posMapa[r.nextInt(posMapa.length)]);
		}while(posMapaItems[posFruta.getY()/MOVIMIENTO][posFruta.getX()/MOVIMIENTO]!=0);
		
		this.fruta = new Circulo(posFruta, 20);
		posMapaItems[posFruta.getY()/MOVIMIENTO][posFruta.getX()/MOVIMIENTO]=2;
		
		for (int i = 0; i < posMapaItems.length; i++) {
		for (int j = 0; j < posMapaItems.length; j++) {
			System.out.print(posMapaItems[i][j] + " ");
		}
		System.out.println("");
	}
		
		head = ImageIO.read(new File("resources\\Pelado.png"));
		body = ImageIO.read(new File("resources\\2.png"));
		fruit = ImageIO.read(new File("resources\\swipl.png"));
	}

	public int[][] getPosMapaItems() {
		return posMapaItems;
	}

//	public void paintComponent(Graphics g) {		
//		g.drawImage(head, snake.get(0).getCentro().getX(), snake.get(0).getCentro().getY(), null);
//		for (int i = 1; i < snake.size(); i++) {
//			g.drawImage(body, snake.get(i).getCentro().getX(), snake.get(i).getCentro().getY(), null);
//		}
//		g.drawImage(fruit, fruta.getCentro().getX(), fruta.getCentro().getY(), null);
//	}
	
//	Este seria el legal
	public void paintComponent(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillOval((int) snake.get(0).getCentro().getX(), (int) snake.get(0).getCentro().getY(), (int) snake.get(0).getRadio(),
				(int) snake.get(0).getRadio());
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 1; i < snake.size(); i++) {
			g.fillOval((int) snake.get(i).getCentro().getX(), (int) snake.get(i).getCentro().getY(), (int) snake.get(i).getRadio(),
					(int) snake.get(i).getRadio());
		}
		g.setColor(Color.RED);
		g.fillOval(fruta.getCentro().getX(), fruta.getCentro().getY(), (int) fruta.getRadio(), (int) fruta.getRadio());
	}
	
	public List<Circulo> getSnake() {
		return this.snake;
	}
	
	public Circulo getFruta() {
		return fruta;
	}
	
	public int[] getPosMapa() {
		return this.posMapa;
	}

	public void setSnake(List<Circulo> snake) {
		this.snake = snake;
	}
	
	public int getMAX_MAP() {
		return MAX_MAP;
	}
}
