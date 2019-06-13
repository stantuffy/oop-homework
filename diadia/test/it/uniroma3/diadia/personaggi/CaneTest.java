package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;

public class CaneTest {

	private Cane cane;
	private Partita partita;

	@Before
	public void setUp() throws Exception {
		this.cane = new Cane("cane", "");
		this.partita = new Partita();
	}

	// Quando ci interagisci, il giocatore si ritrova con un cfu in meno.
	@Test
	public void testInteragisci_cfuRidottoDiUno() {
		final int cfu = this.partita.getGiocatore().getCfu();
		this.cane.interagisci(partita);
		assertSame(cfu-1, this.partita.getGiocatore().getCfu());
	}

}
