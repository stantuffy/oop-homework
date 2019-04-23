package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private static final String NOME_STANZA = "Stanza";
	private static final String NOME_ATTREZZO_ILLUMINANTE = "Attrezzo";
	private StanzaBuia stanza;
	private Attrezzo attrezzoIlluminante;

	@Before
	public void setUp() throws Exception {
		this.attrezzoIlluminante = new Attrezzo(NOME_ATTREZZO_ILLUMINANTE, 0);
		this.stanza = new StanzaBuia(NOME_STANZA, NOME_ATTREZZO_ILLUMINANTE);
	}
	
	// Metodi di StanzaBuia:
	// String getBlindDescrizione()
	// String getNomeAttrezzoIlluminante()
	// StanzaBuia(nome, nomeAttrezzoIlluminante)
	
	// Test-cases:
	// Al momento della creazione, l'oggetto illuminante non è presente nella stanza
	// Se l'oggetto illuminante non è presente nella stanza, la descrizione è getBlindDescrizione()
	// Se l'oggetto illuminante è nella stanza, la descrizione non è getBlindDescrizione()
	
	@Test
	public void testAttrezzoIlluminanteNonPresenteOnInit() {
		assertFalse(stanza.hasAttrezzo(stanza.getNomeAttrezzoIlluminante()));
	}
	
	@Test
	public void testGetDescrizioneSeAttrezzoIlluminanteNonPresente() {
		assertEquals(stanza.getBlindDescrizione(), stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSeAttrezzoIlluminantePresente() {
		stanza.addAttrezzo(this.attrezzoIlluminante);
		assertNotEquals(this.stanza.getBlindDescrizione(), this.stanza.getDescrizione());
	}
}
