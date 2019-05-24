package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



public class StanzaMagicaTest {
	StanzaMagica sm = new StanzaMagica("N5", 3);
	

	@Before
	public void setUp() throws Exception {
		
		sm.addAttrezzo(new Attrezzo("sapone", 3));
		sm.addAttrezzo(new Attrezzo("righello", 5));
		sm.addAttrezzo(new Attrezzo("libro di fisica", 10));
		sm.addAttrezzo(new Attrezzo("pezzo de carta", 90));
	}
	
	@Test
	public void testCostruttore() {
		assertNull(sm.getAttrezzo("tu zia"));
		assertNotNull(sm.getAttrezzo("libro di fisica"));
		assertNotNull(sm.getAttrezzo("righello"));
		assertTrue(sm.getAttrezzo("righello").getPeso() == 5);
	}
	
	@Test
	public void testStanzaVuota() {
		assertTrue(sm.getAttrezzi() != null);
	}
	
	@Test
	public void testAddAttrezzo() {
		assertNotNull(sm.getAttrezzo("sapone"));
		assertTrue(sm.getAttrezzo("sapone").getNome().equals("sapone"));
		assertTrue(sm.getAttrezzo("sapone").getPeso() == 3);
	}
	
	@Test 
	public void triggerEffettoMagico() {
		assertTrue(sm.getAttrezzo("libro di fisica").getPeso() == 20);
		assertTrue(sm.getAttrezzo("pezzo de carta").getPeso() == 180);
		
		assertNotNull(sm.getAttrezzo("pezzo de carta"));
		assertFalse(sm.getAttrezzo("pezzo de carta").getNome().equals("atrac ed ozzep"));
		
	}
}
