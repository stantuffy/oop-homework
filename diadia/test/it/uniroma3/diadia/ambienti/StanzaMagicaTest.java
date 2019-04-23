package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	
	private static final int SOGLIA_MAGICA = 5;
	private static final String NOME_STANZA = "Stanza";
	private static final String NOME_ATTREZZO = "Attrezzo";
	private String nomeAttrezzoReverse;
	private static final int PESO_ATTREZZO = 3;
	private StanzaMagica stanza;
	private Attrezzo attrezzo;
	
	// Aggiunge alla stanza un numero di attrezzi pari a sogliaMagica.
	// NB: L'attrezzo aggiunto è sempre lo stesso oggetto.
	private void addAttrezziSottoSogliaMagica() {
		for(int i=0; i<SOGLIA_MAGICA; i++)
			this.stanza.addAttrezzo(this.attrezzo);
	}
	
	// Aggiunge alla stanza un numero di attrezzi pari a (sogliaMagica + 1).
	private void addAttrezziSopraSogliaMagica() {
		this.addAttrezziSottoSogliaMagica();
		this.stanza.addAttrezzo(this.attrezzo);
	}

	@Before
	public void setUp() throws Exception {
		this.attrezzo = new Attrezzo(NOME_ATTREZZO, PESO_ATTREZZO);
		this.stanza = new StanzaMagica(NOME_STANZA, SOGLIA_MAGICA);
		
		StringBuilder sb = new StringBuilder(NOME_ATTREZZO);
		this.nomeAttrezzoReverse = sb.reverse().toString();
	}
	
	@Test
	public void testGetNomeOnInit() {
		assertEquals(NOME_STANZA, this.stanza.getNome());
	}
	
	@Test
	public void testGetSogliaMagicaOnInit() {
		assertSame(SOGLIA_MAGICA, this.stanza.getSogliaMagica());
	}
	
	@Test
	public void testGetContatoreAttrezziPosatiZeroOnInit() {
		assertSame(0, this.stanza.getContatoreAttrezziPosati());
	}
	
	@Test
	public void testAddAttrezzoPrimo() {
		assertTrue(this.stanza.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testAddAttrezzoPrimoImmutato() {
		this.stanza.addAttrezzo(this.attrezzo);
		assertEquals(NOME_ATTREZZO, this.attrezzo.getNome());
		assertSame(PESO_ATTREZZO, this.attrezzo.getPeso());
	}
	
	@Test
	public void testAddAttrezziImmutatiSottoSogliaMagica() {
		this.addAttrezziSottoSogliaMagica();
		assertEquals(NOME_ATTREZZO, this.attrezzo.getNome());
		assertSame(PESO_ATTREZZO, this.attrezzo.getPeso());
	}
	
	@Test
	public void testAddAttrezzoMutatoNomeInverso() {
		this.addAttrezziSopraSogliaMagica();
		assertEquals(this.nomeAttrezzoReverse, this.attrezzo.getNome());
	}
	
	@Test
	public void testAddAttrezzoMutatoPesoRaddoppiato() {
		this.addAttrezziSopraSogliaMagica();
		assertSame(PESO_ATTREZZO * 2, this.attrezzo.getPeso());
	}
}
