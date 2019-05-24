package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	private static final String ATTREZZO_DI_TEST = "attrezzo di test";
	private static final Direzione NORD = Direzione.Nord;
	private static final Direzione SUD = Direzione.Sud;
	private Stanza stanza;
	
	@Before
	public void setUp() {
		this.stanza = new Stanza("Stanza");
	}
	
	@Test
	public void addHasGetAttrezzo() {
		Attrezzo a = new Attrezzo("Martello", 98);
		
		assertTrue(this.stanza.addAttrezzo(a));
		assertTrue(this.stanza.hasAttrezzo("Martello"));
		assertEquals(98, this.stanza.getAttrezzo("Martello").getPeso());
	}
	
	@Test
	public void hasAttrezzo_inesistente() {
		assertFalse(this.stanza.hasAttrezzo(ATTREZZO_DI_TEST));
	}
	
	@Test 
	public void getAttrezzo_null() {
		assertNull(this.stanza.getAttrezzo(ATTREZZO_DI_TEST));
	}
	
	@Test
	public void testStanzaAdiancente() {
		Stanza bagno = new Stanza("bagno");
		
		this.stanza.impostaStanzaAdiacente(NORD, bagno);
		assertSame(bagno, this.stanza.getStanzaAdiacente(NORD));
	}
	
	@Test
	public void testStanzaAdiacente_direzioneInesistente() {
		assertNull(this.stanza.getStanzaAdiacente(SUD));	
	}
	
	@Test
	public void testStanzaAdiacente_direzioneNull() {
		assertNull(this.stanza.getStanzaAdiacente(null));
	}
	
	@Test
	public void impostaStanzaAdiacente_sovrascriviStanza() {
		this.stanza.impostaStanzaAdiacente(NORD, new Stanza("vecchia"));
		this.stanza.impostaStanzaAdiacente(NORD, new Stanza("nuova"));
		
		assertEquals("nuova", this.stanza.getStanzaAdiacente(NORD).getNome());
	}
	
	@Test
	public void impostaStanzaAdiacente_dueDirezioni() {
		this.stanza.impostaStanzaAdiacente(NORD, new Stanza("stanza nord"));
		this.stanza.impostaStanzaAdiacente(SUD, new Stanza("stanza sud"));
		
		assertEquals("stanza nord", this.stanza.getStanzaAdiacente(NORD).getNome());
	}
}