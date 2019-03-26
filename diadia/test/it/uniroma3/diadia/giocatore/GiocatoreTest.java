package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	/**
	 * Verifica che un nuovo giocatore abbia sempre 0 cfu.
	 */
	@Test
	public void testNuovo_zeroCfu() {
		Giocatore g = new Giocatore();
		assertEquals(0, g.getCfu());
	}
	
	/**
	 * Verifica che il metodo setCfu imposti correttamente
	 * i cfu del giocatore, e che il metodo getCfu restituisca
	 * correttamente i suoi cfu.
	 */
	@Test
	public void testCfu_getSet() {
		Giocatore g = new Giocatore();
		g.setCfu(3);
		assertEquals(3, g.getCfu());
	}
}
