package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosaTest {

	private Partita partita;
	private Borsa borsa;
	private ComandoPosa comando;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.comando = new ComandoPosa();
		this.borsa = this.partita.getGiocatore().getBorsa();
	}

	// Posa oggetto non posseduto -> la borsa ha lo stesso numero di oggetti
	@Test
	public void testEsegui_posaOggettoNonPosseduto_borsaNonCambia() {
		this.borsa.addAttrezzo(
				new Attrezzo("piuma", 0)
				);
		this.comando.setParametro("ascia");
		this.comando.esegui(this.partita);
		assertSame(1, this.borsa.getNumAttrezzi());
	}
	
	// Posa oggetto non posseduto -> la stanza corrente ha lo stesso numero di oggetti
	@Test
	public void testEsegui_posaOggettoNonPosseduto_stanzaCorrenteHaStessoNumOggetti() {
		final int numAttrezziStanzaCorrente = this.partita.getStanzaCorrente().getNumAttrezzi();
		
		this.comando.setParametro("");
		this.comando.esegui(this.partita);
		
		assertSame(numAttrezziStanzaCorrente, this.partita.getStanzaCorrente().getNumAttrezzi());
	}
	
	// Posa oggetto posseduto -> la borsa ha un oggetto in meno
	@Test
	public void testEsegui_posaOggetto_laBorsaHaUnOggettoInMeno() {
		final int numAttrezziBorsa = this.borsa.getNumAttrezzi();
		this.borsa.addAttrezzo(new Attrezzo("eucalipto", 0));
		this.comando.setParametro("eucalipto");
		this.comando.esegui(this.partita);
		assertSame(numAttrezziBorsa, this.borsa.getNumAttrezzi());
	}
	
	// Posa oggetto posseduto -> la stanza corrente ha un oggetto in più
	@Test
	public void testEsegui_posaOggetto_laStanzaCorrenteHaUnOggettoInPiu() {
		final int numAttrezziStanza = this.partita.getStanzaCorrente().getNumAttrezzi();
		this.borsa.addAttrezzo(new Attrezzo("eucalipto", 0));
		this.comando.setParametro("eucalipto");
		this.comando.esegui(this.partita);
		assertSame(numAttrezziStanza+1, this.partita.getStanzaCorrente().getNumAttrezzi());
	}
}
