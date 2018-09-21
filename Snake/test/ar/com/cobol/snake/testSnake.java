package ar.com.cobol.snake;

import org.junit.*;

public class testSnake {
	
	Snake s1, s2;
	
	@Before
	public void setUp() {
		s1 = new Snake();
		s2 = new Snake(5, 2);
	}
	
	@Test
	public void snakeBienGenerada() {
		Assert.assertEquals(4, s1.getLongitud());
		Assert.assertEquals(1, s1.getVelocidad());
		Assert.assertEquals(5, s2.getLongitud());
		Assert.assertEquals(2, s2.getVelocidad());
	}
	
	@Test
	public void aumentoVelocidadDeSnakeUnaVez() {
		s1.incrementarVelocidad();
		Assert.assertEquals(2, s1.getVelocidad());
	}
	
	@Test
	public void aumentoLongitudDeSnakeUnaVez() {
		s1.incrementarLongitud();
		Assert.assertEquals(5, s1.getLongitud());
	}

}
