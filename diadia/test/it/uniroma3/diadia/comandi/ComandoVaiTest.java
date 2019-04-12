package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {

	private static final int _CFU = 20;
	private static final String _PARAMETRO_NON_VALIDO = null;
	private static final String _PARAMETRO_OVEST = "ovest";
	private static final String _PARAMETRO_EST = "est";
	private static final String _PARAMETRO_SUD = "sud";
	private static final String _PARAMETRO_NORD = "nord";
	private Partita partita;
	private ComandoVai comando;

	@Before
	public void setUp() {
		this.partita = new Partita();
		this.partita.getGiocatore().setCfu(_CFU);
		this.comando = new ComandoVai();
	}
	
	private void finisciCfu() {
		for(int i=0; i<_CFU; i++) {
			if(i % 2 == 0)
				comando.setParametro(_PARAMETRO_OVEST);
			else
				comando.setParametro(_PARAMETRO_EST);
			comando.esegui(this.partita);
		}
	}
	
	private void vaiInStanzaVincente() {
		this.comando.setParametro(_PARAMETRO_NORD);
		this.comando.esegui(this.partita);
	}
	
	// Se passo un parametro null, rimango nella stessa stanza
	@Test
	public void testEseguiConParametroNull() {
		Stanza stanzaCorrente = this.partita.getStanzaCorrente();
		comando.setParametro(_PARAMETRO_NON_VALIDO);
		comando.esegui(this.partita);
		
		assertSame(stanzaCorrente, this.partita.getStanzaCorrente());
	}
	
	// Se eseguo il comando valido per più volte rispetto ai cfu, il giocatore ha zero cfu
	@Test
	public void testEseguiFinoAZeroCfu() {
		this.finisciCfu();
		
		assertSame(0, this.partita.getGiocatore().getCfu());
	}
	
	// Se eseguo il comando valido per più volte rispetto ai cfu, la partita finisce
	@Test
	public void testEseguiPartitaFinisce() {
		this.finisciCfu();
		
		assertTrue(this.partita.isFinita());
	}
	
	// Se eseguo il comando, passando come parametro una direzione non prevista dalla stanza corrente, rimango nella stessa stanza
	// TODO
	
	// Se eseguo il comando con un parametro non valido, il giocatore non perde cfu
	@Test
	public void testEseguiMantieneCfu() {
		this.comando.setParametro(_PARAMETRO_NON_VALIDO);
		this.comando.esegui(this.partita);
		
		assertSame(_CFU, this.partita.getGiocatore().getCfu());
	}
	
	// Se eseguo il comando valido, la stanza corrente cambia
	@Test
	public void testEseguiCambiaStanza() {
		Stanza stanzaCorrente = this.partita.getStanzaCorrente();
		this.comando.setParametro(_PARAMETRO_SUD);
		this.comando.esegui(this.partita);
		
		assertNotSame(stanzaCorrente, this.partita.getStanzaCorrente());
	}
	
	// Se eseguo il comando valido verso la stanza vincente, la partita risulta vinta
	@Test
	public void testEseguiVinta() {
		this.vaiInStanzaVincente();
		
		assertTrue(this.partita.vinta());
	}
	
	// Se eseguo il comando valido verso la stanza vincente, la stanza corrente è quella vincente
	@Test
	public void testEseguiStanzaVincente() {
		this.vaiInStanzaVincente();
		
		assertSame(this.partita.getStanzaVincente(), this.partita.getStanzaCorrente());
	}
}
