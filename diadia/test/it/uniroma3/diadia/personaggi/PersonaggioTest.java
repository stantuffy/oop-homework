package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonaggioTest {

	private Personaggio personaggio;
	
	@Before
	public void setUp() throws Exception {
		this.personaggio = new MockPersonaggio("p", "descrizione");
	}
	
	// saluta -> haSalutato diventa true
	@Test
	public void testSaluta_haSalutatoTrue() {
		this.personaggio.saluta();
		assertTrue(this.personaggio.haSalutato());
	}
	
	// getNome -> il nome è quello atteso
	@Test
	public void testGetNome_impostatoCorrettamente() {
		assertEquals("p", this.personaggio.getNome());
	}
	
	// getDescrizione -> è quella attesa
	@Test
	public void testGetDescrizione_impostatoCorrettamente() {
		assertEquals("descrizione", this.personaggio.getDescrizione());
	}
	
	// haSalutato -> all'inizio, è false
	@Test
	public void testHaSalutato_allaCreazioneNonHaSalutato() {
		assertFalse(this.personaggio.haSalutato());
	}

}
