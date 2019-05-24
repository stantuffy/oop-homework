package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	StanzaBuia sb = new StanzaBuia("N5");
	Attrezzo LANTERNA = new Attrezzo("Lanterna",2);
	
	@Before
	public void setUp() {
		sb.addAttrezzo(new Attrezzo("spaghetti",0));
		sb.addAttrezzo(new Attrezzo("sale", 0));
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzoIlluminante() {
		sb.removeAttrezzo("Lanterna");
		assertFalse(sb.hasAttrezzo("Lanterna"));
		assertFalse(sb.toString().equals("Qui c'è un buio pesto!"));
	}
	
	@Test
	public void testStampaDescrizioneConAttrezzoIlluminante() {
		sb.addAttrezzo(LANTERNA);
		assertTrue(sb.toString().equals("Qui c'è un buio pesto!"));
	}
	
	@Test
	public void testPresenzaAttrezzoIlluminante() {
		sb.addAttrezzo(LANTERNA);
		assertTrue(sb.hasAttrezzo("Lanterna"));
	}
}
