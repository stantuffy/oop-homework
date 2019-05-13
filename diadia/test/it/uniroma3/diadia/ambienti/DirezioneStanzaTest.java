package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

public class DirezioneStanzaTest {

	@Test
	public void testFromString_direzioneEsistenteLower() {
		final String DIR_NORD = "nord";
		assertNotNull(DirezioneStanza.fromString(DIR_NORD));
	}
	
	@Test
	public void testFromString_direzioneEsistenteUpper() {
		final String DIR_NORD = "NORD";
		assertNotNull(DirezioneStanza.fromString(DIR_NORD));
	}
	
	@Test
	public void testFromString_contieneDirezioneEsistente() {
		final String DIREZIONE_NON_VALIDA = "stanza nord";
		assertNull(DirezioneStanza.fromString(DIREZIONE_NON_VALIDA));
	}
	
	@Test
	public void testFromString_direzioneEsistenteUpperFirst() {
		final String DIR_NORD = "Nord";
		assertNotNull(DirezioneStanza.fromString(DIR_NORD));
	}

}
