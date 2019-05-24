package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	@Test
	public void testNuovo_zeroCfu() {
		Giocatore g = new Giocatore();
		assertEquals(0, g.getCfu());
	}
	
	@Test
	public void testCfu_getSet() {
		Giocatore g = new Giocatore();
		g.setCfu(3);
		assertEquals(3, g.getCfu());
	}
}
