package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo; 

public class StanzaBloccataTest {
	
	StanzaBloccata sb = new StanzaBloccata("N5",NORD);
	private static final Direzione NORD = Direzione.Nord;
	private static final Stanza STANZA_BAGNO = new Stanza("Bagno");
	private static final Attrezzo ATTREZZO_CHIAVE = new Attrezzo("Chiave", 1);
	
	@Before
	public void setUp() {
		sb.impostaStanzaAdiacente(NORD, STANZA_BAGNO);
	}
	
	@Test
	public void testStanzaBloccataConChiave() {
		sb.addAttrezzo(ATTREZZO_CHIAVE);
		assertTrue(sb.hasAttrezzo("Chiave"));
	}
	
	@Test
	public void testGetStanzaAdiacenteConChiave() {
		sb.addAttrezzo(ATTREZZO_CHIAVE);
		assertTrue(sb.getStanzaAdiacente(NORD).getNome().equals("N5"));
	}
	
	@Test
	public void testStanzaBloccataSenzaChiave() {
		assertFalse(sb.getStanzaAdiacente(NORD).getNome().equals("Bagno"));
	}
}