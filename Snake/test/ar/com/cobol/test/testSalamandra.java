package ar.com.cobol.test;

import org.junit.*;

import ar.com.cobol.mapa.*;
import ar.com.cobol.punto.*;
import ar.com.cobol.snake.*;

public class testSalamandra {
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void snakeBienGenerada() {
		Salamandra salam = new Salamandra (new Punto(5,5), 4, 1);
		for (int i = 0; i < salam.getCuerpo().size(); i++) {
			System.out.println(salam.getCuerpo().get(i).mostrarPunto());
		}
	}
	
	@Test
	public void mapaVacio() {
		Mapa map = new Mapa();
		map.verMapa();
	}
}
