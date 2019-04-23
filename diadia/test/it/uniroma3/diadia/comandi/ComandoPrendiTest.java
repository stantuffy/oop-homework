package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	private static final String _NOME_ATTREZZO_INESISTENTE = null;
	private static final Attrezzo _ATTREZZO = new Attrezzo("Attrezzo", 0);
	private Partita partita;
	private ComandoPrendi comando;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.partita.getStanzaCorrente().addAttrezzo(_ATTREZZO);
		this.comando = new ComandoPrendi();
		this.comando.setParametro(_ATTREZZO.getNome());
	}

	// Prendi oggetto che non esiste -> la borsa del giocatore non ha tale attrezzo
	@Test
	public void testEseguiAttrezzoInesistente() {
		this.comando.setParametro(_NOME_ATTREZZO_INESISTENTE);
		this.comando.esegui(this.partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(_NOME_ATTREZZO_INESISTENTE));
	}
	
	// Prendi oggetto presente nella stanza -> l'oggetto si trova nella borsa
	@Test
	public void testEseguiAttrezzoAggiuntoInBorsa() {
		this.comando.esegui(this.partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo(_ATTREZZO.getNome()));
	}
	
	// Prendi oggetto presente nella stanza -> la stanza ha un oggetto in meno
	@Test
	public void testEseguiStanzaHaUnAttrezzoInMeno() {
		int prevSize = this.partita.getStanzaCorrente().getNumAttrezzi();
		this.comando.esegui(this.partita);
		assertSame(prevSize - 1, this.partita.getStanzaCorrente().getNumAttrezzi());
	}
}
