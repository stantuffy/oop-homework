package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

// impostaStanzaAdiacente v
// getStanzaAdiacente v
// addAttrezzo v
// hasAttrezzo v
// getAttrezzo v

public class StanzaTest {
	
	/**
	 * Test dei metodi di gestione degli attrezzi dentro la stanza.
	 * Verifica:
	 * - che un attrezzo venga aggiunto correttamente ad una stanza
	 * - che, una volta aggiunto, la stanza contenga effettivamente un oggetto
	 * - che le caratteristiche dell'attrezzo siano corrette, una volta messo nella stanza
	 */
	@Test
	public void testAttrezzi() {
		Attrezzo a = new Attrezzo("Martello", 98);
		Stanza s = new Stanza("Cantina");
		
		assertTrue(s.addAttrezzo(a));
		assertTrue(s.hasAttrezzo("Martello"));
		assertEquals(98, s.getAttrezzo("Martello").getPeso());
	}
	
	/**
	 * Verifica che, aggiungendo più attrezzi di quanti sia possibile contenere
	 * nella stanza, questi non vengano effettivamente aggiunti.
	 */
	@Test
	public void testAttrezzi_troppi() {
		Stanza s = new Stanza("");
		
		for(int i=0; i<s.getAttrezzi().length; i++) {
			s.addAttrezzo(new Attrezzo(i + "", i));
		}
		
		assertFalse(
				s.addAttrezzo(new Attrezzo("Cipolla", 10))
		);
	}
	
	@Test
	public void testStanzaAdiancente() {
		Stanza soggiorno = new Stanza("soggiorno");
		Stanza bagno = new Stanza("bagno");
		
		soggiorno.impostaStanzaAdiacente("nord", bagno);
		assertSame(bagno, soggiorno.getStanzaAdiacente("nord"));
	}
}
