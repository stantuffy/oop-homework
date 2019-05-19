package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private static final String NOME_ATTREZZO_SBLOCCANTE = "Attrezzo";
	private static final DirezioneStanza DIREZIONE_BLOCCATA = DirezioneStanza.Nord;
	private static final String[] DIREZIONI_NON_BLOCCATE = {"sud", "est", "ovest"};
	private static final String NOME_STANZA = "Stanza";
	private StanzaBloccata stanza;
	private Stanza stanzaPlaceholder;

	@Before
	public void setUp() throws Exception {
		this.stanza = new StanzaBloccata(NOME_STANZA, DIREZIONE_BLOCCATA.toString(), NOME_ATTREZZO_SBLOCCANTE);
		
		this.stanzaPlaceholder = new Stanza("placeholder");
		
		this.stanza.impostaStanzaAdiacente(DIREZIONE_BLOCCATA, stanzaPlaceholder);
		for(String direzione: DIREZIONI_NON_BLOCCATE)
			this.stanza.impostaStanzaAdiacente(direzione, stanzaPlaceholder);
	}
	
	// Metodi di StanzaBloccata:
	// String getNomeDirezioneBloccata()
	// String getNomeAttrezzoSbloccante()
	// StanzaBloccata(nomeStanza, nomeDirezione, nomeAttrezzo)
	
	// Alla creazione, non c'è l'attrezzo sbloccante nella stanza.
	@Test
	public void testHasAttrezzoSbloccanteFalseOnInit() {
		assertFalse(this.stanza.hasAttrezzo(NOME_ATTREZZO_SBLOCCANTE));
	}
	
	// La direzione bloccata è quella impostata.
	@Test
	public void testGetNomeDirezioneBloccata() {
		assertEquals(DIREZIONE_BLOCCATA, this.stanza.getDirezioneBloccata());
	}
	
	// L'attrezzo sbloccante è quello impostato.
	@Test
	public void testGetNomeAttrezzoSbloccante() {
		assertEquals(NOME_ATTREZZO_SBLOCCANTE, this.stanza.getNomeAttrezzoSbloccante());
	}
	
	// Se l'attrezzo sbloccante non è nella stanza, getStanzaAdiacente() lanciato sulla direzione bloccata, restituisce un ref alla stanza corrente.
	@Test
	public void testGetStanzaAdiacenteDirezioneBloccataSenzaAttrezzoSbloccante() {
		assertSame(this.stanza, this.stanza.getStanzaAdiacente(DIREZIONE_BLOCCATA));
	}
	
	// Se l'attrezzo sbloccante è nella stanza, getStanzaAdiacente() lanciato sulla direzione bloccata, restituisce un ref ad una stanza diversa da quella corrente.
	@Test
	public void testGetStanzaAdiacenteDirezioneBloccataConAttrezzoSbloccante() {
		Attrezzo attrezzoSbloccante = new Attrezzo(NOME_ATTREZZO_SBLOCCANTE, 0);
		this.stanza.addAttrezzo(attrezzoSbloccante);
		assertNotSame(this.stanza, this.stanza.getStanzaAdiacente(DIREZIONE_BLOCCATA));
	}
	
	// Lanciando getStanzaAdiacente() su direzioni diverse da quella bloccata, si ottengono riferimenti diversi dalla stanza corrente.
	@Test
	public void testGetStanzaAdiacenteDirezioniNonBloccate() {
		for(String direzione: DIREZIONI_NON_BLOCCATE) {
			assertNotSame(this.stanza, this.stanza.getStanzaAdiacente(direzione));
		}
	}
}
