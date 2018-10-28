package ar.com.cobol.interfaz;

import javax.swing.JFrame;

import ar.com.cobol.punto.Circulo;
import ar.com.cobol.punto.Punto;

import java.awt.Color;


import java.awt.event.ContainerListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;


public class JVentanaGrafica extends JFrame{
	
private JPanelGrafico contentPane;
	
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
	}
	
	public void setMovimiento(KeyEvent evento){
		
		Circulo c1 = contentPane.getCirculo();
		Circulo c2 = contentPane.getC2();
		List<Circulo> snake = contentPane.getSnake();
		int RAD = (int) snake.get(0).getRadio();
		//Punto anterior = c1.getCentro().clone();
//		
//		if(evento.getKeyCode() == KeyEvent.VK_LEFT) {
//			c1.desplazarHorizontalmente(-50);
//			contentPane.setCirculo(c1);
//			c2.setCentro(anterior);
//			contentPane.setC2(c2);
//		}
//		if(evento.getKeyCode() == KeyEvent.VK_RIGHT) {
//			c1.desplazarHorizontalmente(50);
//			contentPane.setCirculo(c1);
//			c2.setCentro(anterior);
//			contentPane.setC2(c2);
//				
//		}
//		if(evento.getKeyCode() == KeyEvent.VK_UP) {
//			c1.desplazarVerticalmente(-50);
//			contentPane.setCirculo(c1);
//			c2.setCentro(anterior);
//			contentPane.setC2(c2);
//			
//		}
//		if(evento.getKeyCode() == KeyEvent.VK_DOWN) {
//			c1.desplazarVerticalmente(50);
//			contentPane.setCirculo(c1);
//			c2.setCentro(anterior);
//			contentPane.setC2(c2);;
//		}
//		
		Punto anterior = snake.get(0).getCentro().clone();
		if(evento.getKeyCode() == KeyEvent.VK_A) {
			snake.get(0).desplazarHorizontalmente(-RAD);
			for (int i = 1; i < snake.size(); i++) {
				snake.get(i).setCentro(anterior.clone());
				anterior = snake.get(i).getCentro().clone();
				contentPane.setSnake(snake);
			}
	
		}
		
		if(evento.getKeyCode() == KeyEvent.VK_D) {
			snake.get(0).desplazarHorizontalmente(RAD);
			for (int i = 1; i < snake.size(); i++) {
				snake.get(i).setCentro(anterior.clone());
				anterior = snake.get(i).getCentro().clone();
				contentPane.setSnake(snake);
			}
			
				
		}
		if(evento.getKeyCode() == KeyEvent.VK_W) {
			snake.get(0).desplazarVerticalmente(-RAD);
			for (int i = 1; i < snake.size(); i++) {
				
				snake.get(i).setCentro(anterior.clone());
				anterior = snake.get(i).getCentro().clone();
				contentPane.setSnake(snake);
			}
			
			
		}
		if(evento.getKeyCode() == KeyEvent.VK_S) {
			snake.get(0).desplazarVerticalmente(RAD);
			for (int i = 1; i < snake.size(); i++) {
				
				snake.get(i).setCentro(anterior.clone());
				anterior = snake.get(i).getCentro().clone();
				contentPane.setSnake(snake);
				
			}
			
		}
		repaint();
	}

	public static void main(String[] args) {
		new JVentanaGrafica().setVisible(true);
	}

}
