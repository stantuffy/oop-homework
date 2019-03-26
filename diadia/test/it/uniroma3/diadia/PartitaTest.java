package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	/**
	 * Verifica che, quando i cfu raggiungono lo zero, 
	 * la partita comunichi che è finita.
	 */
	@Test
	public void testFinita_zeroCfu() {
		Partita p = new Partita();
		p.getGiocatore().setCfu(0);
		
		assertTrue(
			"Sebbene i cfu siano pari a 0, la partita non e' finita",
			p.isFinita()
		);
	}
	
	/**
	 * All'inizio della partita, esiste una stanza nella quale ci troviamo.
	 */
	@Test
	public void testStanzaCorrente_esiste() {
		Partita p = new Partita();
		
		assertNotNull(
			"All'inizio della partita, non esistono stanze", 
			p.getStanzaCorrente()
		);
	}
	
	/**
	 * Quando la partita viene creata, non è ancora stata vinta.
	 */
	@Test
	public void testNonVinta_onInit() {
		Partita p = new Partita();
		
		assertFalse("Partita vinta al momento della sua inizializzazione", p.vinta());
	}
	
	/**
	 * Quando la stanza corrente è la stanza vincente,
	 * la partita deve finire e deve risultare che sia stata vinta.
	 */
	@Test
	public void testFinita_raggiuntoStanzaVincente() {
		Partita p = new Partita();
		Stanza vincente = p.getStanzaVincente();
		p.setStanzaCorrente(vincente);
		
		assertTrue("Stanza vincente raggiunta ma partita non finita", p.isFinita());
		assertTrue("Stanza vincente raggiunta ma partita non vinta", p.vinta());
	}
	
	/**
	 * Verifica che, alla creazione di una nuova partita,
	 * il sistema imposti in automatico una stanza vincente.
	 */
	@Test
	public void testStanzaVincente_esiste() {
		Partita p = new Partita();
		assertNotNull("Non esiste la stanza vincente", p.getStanzaVincente());
	}
	
	/**
	 * Alla creazione di una nuova partita,
	 * il sistema deve impostare in automatico la biblioteca 
	 * come stanza vincente.
	 */
	@Test
	public void testStanzaVincente_biblioteca() {
		Partita p = new Partita();
		
		assertEquals(
				"La stanza vincente non e' la biblioteca", 
				"Biblioteca", p.getStanzaVincente().getNome()
			);
	}
	
}
