package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	private static final String ATTREZZO_DI_TEST = "attrezzo di test";
	private static final String NORD = "nord";
	private Stanza stanza;
	
	@Before
	public void setUp() {
		this.stanza = new Stanza("Stanza");
	}
	
	/**
	 * Test dei metodi di gestione degli attrezzi dentro la stanza.
	 * Verifica:
	 * - che un attrezzo venga aggiunto correttamente ad una stanza
	 * - che, una volta aggiunto, la stanza contenga effettivamente un oggetto
	 * - che le caratteristiche dell'attrezzo siano corrette, una volta messo nella stanza
	 */
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
	public void addAttrezzo_riempi() {
		for(int i=0; i<this.stanza.getAttrezzi().length; i++)
			assertTrue(this.stanza.addAttrezzo(new Attrezzo(ATTREZZO_DI_TEST, 1)));
	}
	
	/**
	 * Verifica che, aggiungendo più attrezzi di quanti sia possibile contenere
	 * nella stanza, questi non vengano effettivamente aggiunti.
	 */
	@Test
	public void addAttrezzo_troppi() {
		int length = this.stanza.getAttrezzi().length;
		
		for(int i=0; i<length; i++)
			this.stanza.addAttrezzo(new Attrezzo(ATTREZZO_DI_TEST, i));
		
		assertFalse(
				this.stanza.addAttrezzo(new Attrezzo(ATTREZZO_DI_TEST, 10))
		);
	}
	
	@Test
	public void testStanzaAdiancente() {
		Stanza bagno = new Stanza("bagno");
		
		this.stanza.impostaStanzaAdiacente(NORD, bagno);
		assertSame(bagno, this.stanza.getStanzaAdiacente(NORD));
	}
	
	@Test
	public void testStanzaAdiacente_direzioneInesistente() {
		assertNull(this.stanza.getStanzaAdiacente("direz. inesistente"));	
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
		this.stanza.impostaStanzaAdiacente("sud", new Stanza("stanza sud"));
		
		assertEquals("stanza nord", this.stanza.getStanzaAdiacente(NORD).getNome());
	}
	
	@Test
	public void impostaStanzaAdiacente_oltreMaxDirezioni() {
		for(int i=0; i<5; i++)
			this.stanza.impostaStanzaAdiacente(
				"direzione"+ i, 
				new Stanza("stanza nord"));

		
		assertNull(this.stanza.getStanzaAdiacente("direzione4"));
	}
}