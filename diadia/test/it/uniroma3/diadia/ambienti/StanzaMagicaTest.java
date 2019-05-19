package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	/**
	 * 
	 * @param size Specifica la dimensione della lista di attrezzi che si vuole ottenere.
	 * @return Lista i cui elementi sono attrezzi, ognuno con un nome diverso dagli altri. Tutti gli attrezzi pesano 0.
	 */
	private static List<Attrezzo> listNomiDiversiPesoZero(int size) {
		String nome = "Attrezzo";
		List<Attrezzo> res = new ArrayList<>();
		
		for(int i=0; i<size; i++) {
			StringBuilder sb = new StringBuilder(nome);
			sb.append(i);
			res.add(new Attrezzo(sb.toString(), 0));
		}
		
		return res;
	}
	
	/**
	 * Aggiunge (n=quanti) attrezzi alla stanza di test.
	 * NB: Gli attrezzi sono creati invocando il metodo listNomiDiversiPesoZero(quanti)
	 * @param quanti Numero di attrezzi che si vogliono aggiungere alla stanza di test.
	 */
	private void addAttrezziConNomiDiversi(int quanti) {
		List<Attrezzo> attrezzi = listNomiDiversiPesoZero(quanti);
		for(Attrezzo a: attrezzi) {
			this.stanza.addAttrezzo(a);
		}
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
		this.addAttrezziConNomiDiversi(SOGLIA_MAGICA-1);
		this.stanza.addAttrezzo(this.attrezzo);
		
		assertEquals(NOME_ATTREZZO, this.attrezzo.getNome());
		assertSame(PESO_ATTREZZO, this.attrezzo.getPeso());
	}
	
	@Test
	public void testAddAttrezzoMutatoNomeInverso() {
		this.addAttrezziConNomiDiversi(SOGLIA_MAGICA);
		this.stanza.addAttrezzo(this.attrezzo);
		
		assertEquals(this.nomeAttrezzoReverse, this.attrezzo.getNome());
	}
	
	@Test
	public void testAddAttrezzoMutatoPesoRaddoppiato() {
		this.addAttrezziConNomiDiversi(SOGLIA_MAGICA);
		this.stanza.addAttrezzo(this.attrezzo);
		
		assertSame(PESO_ATTREZZO * 2, this.attrezzo.getPeso());
	}
	
	@Test
	public void testAddAttrezzo_numAttrezziMutato() {
		this.stanza.addAttrezzo(attrezzo);
		assertSame(1, this.stanza.getNumAttrezzi());
	}
	
	@Test
	public void testAddAttrezzo_nonInserisceDoppioni() {
		Attrezzo copia = new Attrezzo(this.attrezzo.getNome(), this.attrezzo.getPeso());
		this.stanza.addAttrezzo(this.attrezzo);
		assertFalse(this.stanza.addAttrezzo(copia));
	}
	
	@Test
	public void testGetNumAttrezzi_doppioneNonCambiaNumAttrezzi() {
		this.stanza.addAttrezzo(this.attrezzo);
		this.stanza.addAttrezzo(this.attrezzo);
		assertSame(1, this.stanza.getNumAttrezzi());
	}
}
