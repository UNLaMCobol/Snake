package ar.com.cobol.interfaz;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import ar.com.cobol.punto.Circulo;
import ar.com.cobol.punto.Punto;

public class JPanelGrafico extends JPanel {

	private Circulo circulo;
	private Circulo c2;
	private List<Circulo> snake;

	public JPanelGrafico(Circulo circulo, Circulo c2) {
		this.circulo = circulo;
		this.c2 = c2;
		
		snake = new ArrayList<Circulo>();
		for (int i = 100; i < 350; i+=50) {
			snake.add(new Circulo(new Punto(100, i), 50));
		}
	}

	public void paintComponent(Graphics g2/*, Graphics g2*/) {
		
//		g.setColor(Color.BLUE);
//		
//		g.fillOval((int) circulo.getCentro().getX(), (int) circulo.getCentro().getY(), (int) circulo.getRadio(),
//				(int) circulo.getRadio());
//		g.fillOval((int) c2.getCentro().getX(), (int) c2.getCentro().getY(), (int) c2.getRadio(),
//				(int) c2.getRadio());
		
		g2.setColor(Color.RED);
		for (int i = 0; i < snake.size(); i++) {
			g2.fillOval((int) snake.get(i).getCentro().getX(), (int) snake.get(i).getCentro().getY(), (int) snake.get(i).getRadio(),
					(int) snake.get(i).getRadio());
		}
		
	}
	
	public Circulo getC2() {
		return c2;
	}

	public void setC2(Circulo c2) {
		this.c2 = c2;
	}

	public Circulo getCirculo() {
		return this.circulo;
	}
	
	public void setCirculo(Circulo circulo) {
		this.circulo = circulo;
	}
	
	public List<Circulo> getSnake() {
		return this.snake;
	}
	
	public void setSnake(List<Circulo> snake) {
		this.snake = snake;
	}
}
