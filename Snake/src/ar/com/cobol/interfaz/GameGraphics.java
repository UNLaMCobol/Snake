package ar.com.cobol.interfaz;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.List;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import javax.imageio.ImageIO;


import ar.com.cobol.figura.Circulo;
import ar.com.cobol.mapa.MapaNormal;



public class GameGraphics extends JPanel {
	
	//private static final int MAX_MAP = 400;

	private static final long serialVersionUID = 1L;
//	private List<Circulo> snake;
//	private Circulo fruta;
//	//private int[] posMapa /*= {0, 50, 100, 150, 200, 250, 300, 350, 400}*/;
//	private int[] posMapa;
//	private int[][] posMapaItems;
//	private Random r;
//	private BufferedImage head;
//	private BufferedImage body;
//	private BufferedImage fruit;
	
	private MapaNormal mapa;
	
	public GameGraphics() throws IOException {
		mapa = new MapaNormal();
//		head = ImageIO.read(new File("resources\\Pelado.png"));
//		body = ImageIO.read(new File("resources\\2.png"));
//		fruit = ImageIO.read(new File("resources\\swipl.png"));
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillOval((int) mapa.getSnake().getBody().get(0).getCentro().getX(), (int) mapa.getSnake().getBody().get(0).getCentro().getY(), (int) mapa.getSnake().getBody().get(0).getRadio(),
				(int) mapa.getSnake().getBody().get(0).getRadio());
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 1; i < mapa.getSnake().getBody().size(); i++) {
			g.fillOval((int) mapa.getSnake().getBody().get(i).getCentro().getX(), (int) mapa.getSnake().getBody().get(i).getCentro().getY(), (int) mapa.getSnake().getBody().get(0).getRadio(),
					(int) mapa.getSnake().getBody().get(0).getRadio());
		}
		g.setColor(Color.RED);
		g.fillOval(mapa.getFruta().getItem().getCentro().getX(), mapa.getFruta().getItem().getCentro().getY(), (int) mapa.getFruta().getItem().getRadio(), (int) mapa.getFruta().getItem().getRadio());
	}
	
	public MapaNormal getMapa() {
		return this.mapa;
	}

	public void setSnake(List<Circulo> body) {
		this.mapa.getSnake().setBody(body);
	}
//	SECRET
//	public void paintComponent(Graphics g) {		
//		g.drawImage(head, snake.get(0).getCentro().getX(), snake.get(0).getCentro().getY(), null);
//		for (int i = 1; i < snake.size(); i++) {
//			g.drawImage(body, snake.get(i).getCentro().getX(), snake.get(i).getCentro().getY(), null);
//		}
//		g.drawImage(fruit, fruta.getCentro().getX(), fruta.getCentro().getY(), null);
//	}
}
