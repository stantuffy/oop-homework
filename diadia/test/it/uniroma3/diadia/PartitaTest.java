package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	private Partita partita;

	@Before
	public void setUp() {
		this.partita = new Partita();
	}
	
	public void testFinita_zeroCfu() {
		this.partita.getGiocatore().setCfu(0);
		
		assertTrue(
			"Sebbene i cfu siano pari a 0, la partita non e' finita",
			this.partita.isFinita()
		);
	}
	
	@Test
	public void testStanzaCorrente_esiste() {
		assertNotNull(
			"All'inizio della partita, non esistono stanze", 
			this.partita.getStanzaCorrente()
		);
	}
	
	@Test
	public void testVinta_onInit() {
		assertFalse(
			"Partita vinta al momento della sua inizializzazione", 
			this.partita.vinta());
	}
	
	@Test
	public void testFinita_onInit() {
		assertFalse(this.partita.isFinita());
	}
	
	public void testFinita_set() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testFinita_raggiuntoStanzaVincente() {
		Stanza vincente = this.partita.getStanzaVincente();
		this.partita.setStanzaCorrente(vincente);
		
		assertTrue(
			"Stanza vincente raggiunta ma partita non finita", 
			this.partita.isFinita());
	}

	@Test
	public void testVinta_raggiuntoStanzaVincente() {
		Stanza vincente = this.partita.getStanzaVincente();
		this.partita.setStanzaCorrente(vincente);
		
		assertTrue(
			"Stanza vincente raggiunta ma partita non vinta", 
			this.partita.vinta());
	}
	
	@Test
	public void testStanzaVincente_esiste() {
		Partita p = new Partita();
		assertNotNull("Non esiste la stanza vincente", p.getStanzaVincente());
	}
	
	@Test
	public void testStanzaVincente_biblioteca() {
		Partita p = new Partita();
		
		assertEquals(
				"La stanza vincente non e' la biblioteca", 
				"Biblioteca", p.getStanzaVincente().getNome()
			);
	}
}
