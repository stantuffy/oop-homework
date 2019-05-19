package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	private Giocatore giocatore;
	private Attrezzo piuma;
	
	@Before
	public void setUp() {
		this.giocatore = new Giocatore(0);
		this.piuma = new Attrezzo("piuma", 1);
	}
	
	/**
	 * Verifica che un nuovo giocatore abbia sempre 0 cfu.
	 */
	@Test
	public void testNuovo_zeroCfu() {
		assertEquals(0, this.giocatore.getCfu());
	}
	
	/**
	 * Verifica che il metodo setCfu imposti correttamente
	 * i cfu del giocatore, e che il metodo getCfu restituisca
	 * correttamente i suoi cfu.
	 */
	@Test
	public void testCfu_getSet() {
		this.giocatore.setCfu(3);
		assertEquals(3, this.giocatore.getCfu());
	}
	
	@Test
	public void testPrendi_null() {
		assertFalse(this.giocatore.prendi(null));
	}
	
	@Test
	public void testPosa_null() {
		assertNull(this.giocatore.posa(null));
	}
	
	@Test
	public void testPosa_attrezzoNonInBorsa() {
		Attrezzo attrezzo = new Attrezzo("Attrezzo", 0);
		assertNull(this.giocatore.posa(attrezzo.getNome()));
	}
	
	@Test
	public void testPrendi_borsaContieneUnAttrezzo() {
		Attrezzo attrezzo = new Attrezzo("Attrezzo", 0);
		this.giocatore.prendi(attrezzo);
		assertSame(1, this.giocatore.getBorsa().getNumAttrezzi());
	}
	
	@Test
	public void testPrendi_ritornaTrue() {
		assertTrue(this.giocatore.prendi(new Attrezzo("attrezzo gigante bellizsimo", 0)));
	}
	
	@Test
	public void testBorsaGetNumAttrezzi_vuota() {
		assertSame(0, this.giocatore.getBorsa().getNumAttrezzi());	}

	@Test
	public void testBorsaVuota_allInizio() {
		assertTrue(this.giocatore.getBorsa().isEmpty());
	}
}
