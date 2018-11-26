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

}
