package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class MagoTest {

	private Mago mago;
	private Partita partita;
	private Borsa borsa;
	private final static Attrezzo ATTREZZO = new Attrezzo("piuma", 1);

	@Before
	public void setUp() throws Exception {
		this.mago = new Mago("mago", "", ATTREZZO);
		this.partita = new Partita();
		this.borsa = this.partita.getGiocatore().getBorsa();
	}
	
	//(se possiede un attrezzo) quando ci interagisci per la prima volta, il contenuto della borsa aumenta di uno
	@Test
	public void testInteragisci_primaVolta_contenutoBorsaAumentaDiUno() {
		final int numAttrezzi = this.borsa.getNumAttrezzi();
		this.mago.interagisci(partita);
		assertSame(numAttrezzi+1, this.borsa.getNumAttrezzi());
	}
	
	// (se possiede un attrezzo) quando ci interagisci per la prima volta, se la borsa è piena, il mago ha ancora l'attrezzo
	@Test
	public void testInteragisci_primaVolta_borsaPiena_magoMantieneAttrezzo() {
		Attrezzo ATTREZZO_PESANTISSIMO = new Attrezzo("pesantissimo", this.borsa.getPesoMax());
		this.borsa.addAttrezzo(ATTREZZO_PESANTISSIMO);
		this.mago.interagisci(this.partita);
		
		assertTrue(this.mago.haUnAttrezzo());
	}
	
	// quando ci interagisci per la prima volta, dopo non ha più un attrezzo
	@Test
	public void testInteragisci_primaVolta_magoPerdeAttrezzo() {
		this.mago.interagisci(this.partita);
		assertFalse(this.mago.haUnAttrezzo());
	}
	
	//(se possiede un attrezzo) quando ci interagisci per la prima volta, la borsa contiene l'attrezzo che aveva il mago
	@Test
	public void testInteragisci_primaVolta_borsaContieneNuovoAttrezzo() {
		this.mago.interagisci(partita);
		assertTrue(this.borsa.hasAttrezzo(ATTREZZO.getNome()));
	}
	
	// quando ci interagisci per la seconda volta, il contenuto della borsa resta invariato
	@Test
	public void testInteragisci_dopoPrimaVolta_contenutoBorsaInvariato() {
		this.mago.interagisci(partita);
		final int numAttrezzi = this.borsa.getNumAttrezzi();
		this.mago.interagisci(partita);
		assertSame(numAttrezzi, this.borsa.getNumAttrezzi());
	}
}
