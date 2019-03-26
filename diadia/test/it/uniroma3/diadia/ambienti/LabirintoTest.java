package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

public class LabirintoTest {
	
	/**
	 * All'inizializzazione del labirinto,
	 * esso non è vuoto.
	 */
	@Test
	public void testStanzaCorrente_esiste() {
		Labirinto l = new Labirinto();
		
		assertNotNull(
				"Il labirinto è vuoto",
				l.getStanzaCorrente());
	}
	
	/**
	 * All'inizializzazione del labirinto,
	 * esiste la stanza vincente.
	 */
	@Test
	public void testStanzaVincente_esiste() {
		Labirinto l = new Labirinto();
		
		assertNotNull(
				"Nel labirinto non esiste la stanza vincente", 
				l.getStanzaVincente());
	}
}