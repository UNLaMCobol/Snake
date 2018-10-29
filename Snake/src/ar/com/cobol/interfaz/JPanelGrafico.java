package ar.com.cobol.interfaz;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import ar.com.cobol.figura.Circulo;
import ar.com.cobol.figura.Punto;
import static ar.com.cobol.resources.directionUtils.*;

public class JPanelGrafico extends JPanel {
	
	private static final int MAX_MAP = 400;

	private static final long serialVersionUID = 1L;
	private List<Circulo> snake;
	private Circulo fruta;
	private int[] posMapa /*= {0, 50, 100, 150, 200, 250, 300, 350, 400}*/;
	private Random r;

	public JPanelGrafico() {
		r = new Random();
		
		posMapa = new int[(MAX_MAP/MOVIMIENTO) + 1];
		posMapa[0] = 0;
		for (int i = 1; i < posMapa.length; i++) {
			posMapa[i] = posMapa[i-1] + MOVIMIENTO;
		}
		
		this.snake = new ArrayList<Circulo>();
		for (int i = 100; i <= 200; i+=50) {
			snake.add(new Circulo(new Punto(100, i), 50));
		}
		
		Punto posFruta = new Punto(this.posMapa[r.nextInt(posMapa.length)], this.posMapa[r.nextInt(posMapa.length)]);
		this.fruta = new Circulo(posFruta, 50);
	}

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
