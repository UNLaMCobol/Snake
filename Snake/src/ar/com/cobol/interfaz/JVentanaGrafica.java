package ar.com.cobol.interfaz;

import javax.swing.JFrame;

import ar.com.cobol.punto.Circulo;
import ar.com.cobol.punto.Punto;

import java.awt.Color;


import java.awt.event.ContainerListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import static ar.com.cobol.resources.directionUtils.*;

public class JVentanaGrafica extends JFrame{
	
	
	private JPanelGrafico contentPane;
	private List<Circulo> snake;
	private int rad;
	private Punto anterior;
	private int direccion;
	
	public JVentanaGrafica() {
		super("Ejemplo Básico de Graphics");
		setResizable(false);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				setMovimiento(arg0);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanelGrafico(new Circulo(new Punto(100, 100), 50), new Circulo(new Punto(100, 60), 50));
		setBackground(Color.WHITE);
	
		setContentPane(contentPane);
		
		setLocationRelativeTo(null);
		
		this.snake = contentPane.getSnake();
		this.rad = (int) this.snake.get(0).getRadio();
		this.anterior = this.snake.get(0).getCentro().clone();
		this.direccion = ARRIBA;
		
	}
	
	private void reacomodarCuerpo() {
		for (int i = 1; i < this.snake.size(); i++) {
			Punto aux = this.snake.get(i).getCentro().clone();
			this.snake.get(i).setCentro(this.anterior.clone());
			this.anterior = aux.clone();
			
		}
		contentPane.setSnake(this.snake);
	}
	
	public void setMovimiento(KeyEvent evento){
		this.anterior = this.snake.get(0).getCentro().clone();
		if(evento.getKeyCode() == KeyEvent.VK_A) {
			if(this.direccion == DERECHA)
				return;
			this.direccion = IZQUIERDA;
			this.snake.get(0).desplazarHorizontalmente(-this.rad);
			reacomodarCuerpo();
		}
		
		if(evento.getKeyCode() == KeyEvent.VK_D) {
			if(this.direccion == IZQUIERDA)
				return;
			this.direccion = DERECHA;
			this.snake.get(0).desplazarHorizontalmente(this.rad);
			reacomodarCuerpo();	
		}
		
		if(evento.getKeyCode() == KeyEvent.VK_W) {
			if(this.direccion == ABAJO)
				return;
			this.direccion = ARRIBA;
			this.snake.get(0).desplazarVerticalmente(-this.rad);
			reacomodarCuerpo();
		}
		
		if(evento.getKeyCode() == KeyEvent.VK_S) {
			if(this.direccion == ARRIBA)
				return;
			this.direccion = ABAJO;
			this.snake.get(0).desplazarVerticalmente(this.rad);
			reacomodarCuerpo();	
		}
		
		repaint();
	}

	public static void main(String[] args) {
		new JVentanaGrafica().setVisible(true);
	}

}
