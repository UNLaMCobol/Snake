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
	
	@Test
	public void snakeCome() {
		Salamandra salam = new Salamandra (new Punto(5,5), 4, 1);
		Item fruit = new Fruta(new Punto(5,6));
		for (int i = 0; i < salam.getCuerpo().size(); i++) {
			System.out.println(salam.getCuerpo().get(i).mostrarPunto());
		}
		System.out.println("--------------------------");
		salam.superponer(fruit);
		
		for (int i = 0; i < salam.getCuerpo().size(); i++) {
			System.out.println(salam.getCuerpo().get(i).mostrarPunto());
		}
	}
}
