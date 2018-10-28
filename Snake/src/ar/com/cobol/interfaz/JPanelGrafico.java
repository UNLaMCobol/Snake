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

	private List<Circulo> snake;

	public JPanelGrafico(Circulo circulo, Circulo c2) {
		
		snake = new ArrayList<Circulo>();
		for (int i = 100; i < 350; i+=50) {
			snake.add(new Circulo(new Punto(100, i), 50));
		}
	}

	public void paintComponent(Graphics g) {		
		g.setColor(Color.RED);
		for (int i = 0; i < snake.size(); i++) {
			g.fillOval((int) snake.get(i).getCentro().getX(), (int) snake.get(i).getCentro().getY(), (int) snake.get(i).getRadio(),
					(int) snake.get(i).getRadio());
		}
	}
	
	public List<Circulo> getSnake() {
		return this.snake;
	}
	
	public void setSnake(List<Circulo> snake) {
		this.snake = snake;
	}
}
