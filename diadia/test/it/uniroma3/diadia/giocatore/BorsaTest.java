package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
//	/**
//	 * Verifica che non è possibile aggiungere oltre 10 attrezzi.
//	 */
//	@Test
//	public void testAddAttrezzo_pieno() {
//		Borsa borsa = new Borsa();
//		
//		Attrezzo attr = new Attrezzo("", 0);
//		for(int i=0; i<10; i++)
//			assertTrue("Attrezzo non inserito", borsa.addAttrezzo(attr));
//		
//		assertFalse("Nella borsa c'è più spazio di 10 elementi", borsa.addAttrezzo(attr));
//	}
	
	private Borsa borsa;
	private final Attrezzo piuma = new Attrezzo("piuma", 0);
	private final Attrezzo fazzoletto = new Attrezzo("fazzoletto", 0);
	private final Attrezzo masso = new Attrezzo("masso", 10);
	
	private List<Attrezzo> list(Attrezzo... attrezzi) {
		return Arrays.asList(attrezzi);
	}
	
	private SortedSet<Attrezzo> sortedSet(Attrezzo...attrezzi) {
		return new TreeSet<>(Arrays.asList(attrezzi));
	}
	
	@Before 
	public void setUp() {
		this.borsa = new Borsa();
	}
	
	@Test
	public void testPesoMax() {
		Borsa borsa = new Borsa(23);	
		assertEquals(23, borsa.getPesoMax());
	}
	
	/**
	 * Verifica che non sia possibile aggiungere un attrezzo
	 * con peso superiore al massimo specificato.
	 */
	@Test
	public void testAddAttrezzo_troppoPesante() {
		Borsa borsa = new Borsa(10);
		
		Attrezzo attr = new Attrezzo("", 11);
		assertFalse(borsa.addAttrezzo(attr));
	}
	
	@Test
	public void testGetAttrezzo_presente() {
		Borsa borsa = new Borsa(10);
		
		Attrezzo attr = new Attrezzo("Scarpa", 2);
		borsa.addAttrezzo(attr);
		
		Attrezzo trovato = borsa.getAttrezzo("Scarpa");
		assertNotNull(
				"Oggetto non trovato nella borsa,"
				+ " anche se è stato appena inserito", trovato);
		assertEquals("Scarpa", trovato.getNome());
		assertEquals(2, trovato.getPeso());
	}
	
	/**
	 * verifica che il metodo getAttrezzo restituisca null
	 * se viene passato come argomento il nome di un attrezzo
	 * non presente in borsa.
	 */
	@Test
	public void testGetAttrezzo_nonPresente() {
		Borsa borsa = new Borsa();
		
		assertNull(
				"E' stato trovato un oggetto inesistente nella borsa", 
				borsa.getAttrezzo("Non presente"));
	}
	
	/**
	 * verifica che, se la borsa contiene almeno un attrezzo,
	 * il metodo isEmpty() ritorni false
	 */
	@Test
	public void testEmpty_borsaNonVuota() {
		Borsa borsa = new Borsa();
		
		Attrezzo attr = new Attrezzo("Cocconcino", 2);
		borsa.addAttrezzo(attr);
		
		assertFalse(
				"Un attrezzo è stato messo nella borsa, "
				+ "ma continua a risultare vuota",
				borsa.isEmpty());
	}
	
	/**
	 * verifica che una borsa appena creata sia vuota.
	 */
	@Test
	public void testEmpty_borsaVuota() {
		Borsa borsa = new Borsa();
		
		assertTrue(
				"Borsa non vuota al momento della sua creazione", 
				borsa.isEmpty());
	}
	
	/**
	 * Verifica che l'invocazione di removeAttrezzo 
	 * su un attrezzo non presente in borsa restituisca null.
	 */
	@Test
	public void testRemoveAttrezzo_nonPresente() {
		Borsa borsa = new Borsa();
		
		Attrezzo attr = new Attrezzo("Pallone", 0);
		borsa.addAttrezzo(attr);
		
		assertNull(
				"La rimozione dalla borsa di un attrezzo inesistente non è fallito", 
				borsa.removeAttrezzo("Spada"));
	}
	
	/**
	 * Verifica che l'invocazione di removeAttrezzo
	 * passando argomento null non faccia crashare il programma.
	 * Inoltre tale metodo deve ritornare null.
	 */
	@Test
	public void testRemoveAttrezzo_null() {
		Borsa borsa = new Borsa();
		
		assertNull(
				"E' stato rimosso null dalla borsa",
				borsa.removeAttrezzo(null));
	}
	
	/**
	 * Verifica che la rimozione di un attrezzo
	 * presente in borsa riesca con successo.
	 */
	@Test
	public void testRemoveAttrezzo_presente() {
		Borsa borsa = new Borsa(10);
		
		Attrezzo attr = new Attrezzo("Spada", 10);
		borsa.addAttrezzo(attr);
		
		assertNotNull(
				"Non è stato possibile rimuovere un elemento esistente dalla borsa",
				borsa.removeAttrezzo("Spada"));
	}
	
	/**
	 * Verifica che se invoco hasAttrezzo sul nome
	 * di un attrezzo non esistente, ritorna false.
	 */
	@Test
	public void testHasAttrezzo_nonPresente() {
		Borsa borsa = new Borsa();
		
		assertFalse("La borsa vuota dice che possiede un attrezzo", 
				borsa.hasAttrezzo("Pasta"));
	}
	
	/**
	 * Verifica che se invoco hasAttrezzo passando una stringa null
	 * il programma non crasha. Inoltre deve ritornare false.
	 */
	@Test
	public void testHasAttrezzo_null() {
		Borsa borsa = new Borsa();
		
		assertFalse("La borsa dispone dell'oggetto con nome null", 
				borsa.hasAttrezzo(null));
	}
	
	@Test
	public void testHasAttrezzo_presente() {
		Borsa borsa = new Borsa(10);
		
		Attrezzo attr = new Attrezzo("Pasta", 1);
		borsa.addAttrezzo(attr);
		
		assertTrue(
				"Ho aggiunto un attrezzo, ma la borsa dice che non dispone di esso",
				borsa.hasAttrezzo("Pasta"));
	}
	
	/**
	 * Verifica che, al momento della creazione della borsa,
	 * il suo peso è pari a zero.
	 */
	@Test
	public void testGetPeso_onInit() {
		Borsa borsa = new Borsa();
		
		assertEquals(
				"La borsa appena creata pesa più di zero",
				0, borsa.getPeso());
	}
	
	/**
	 * Verifica che, aggiungendo un numero di attrezzi,
	 * il peso della borsa sia dato dalla somma dei pesi
	 * dei singoli attrezzi.
	 */
	@Test
	public void testGetPeso() {
		Borsa borsa = new Borsa(30);
		
		Attrezzo[] attr = new Attrezzo[5];
		
		attr[0] = new Attrezzo("Forchetta", 9);
		attr[1] = new Attrezzo("Guanciale", 2);
		attr[2] = new Attrezzo("Pasta", 3);
		attr[3] = new Attrezzo("Piatto", 4);
		attr[4] = new Attrezzo("Uova", 10);
		
		for(int i=0; i<5; i++)
			borsa.addAttrezzo(attr[i]);
		
		assertEquals(
				"Il peso della borsa non corrisponde alla somma dei pesi dei singoli attrezzi",
				28, borsa.getPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_borsaVuota() {
		assertTrue(this.borsa.getContenutoOrdinatoPerPeso().isEmpty());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_unAttrezzo() {
		this.borsa.addAttrezzo(this.piuma);
		assertSame(1, this.borsa.getContenutoOrdinatoPerPeso().size());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_unAttrezzoListaAttesa() {
		this.borsa.addAttrezzo(this.piuma);
		assertEquals(list(this.piuma), this.borsa.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_dueAttrezziOrdinatiCorrettamente() {
		this.borsa.addAttrezzo(this.masso);
		this.borsa.addAttrezzo(this.piuma);
		assertEquals(this.piuma, this.borsa.getContenutoOrdinatoPerPeso().get(0));
		assertEquals(this.masso, this.borsa.getContenutoOrdinatoPerPeso().get(1));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_stessoAttrezzoInseritoPiuVolte() {
		this.borsa.addAttrezzo(this.piuma);
		this.borsa.addAttrezzo(this.piuma);
		assertSame(1, this.borsa.getContenutoOrdinatoPerPeso().size());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_dueAttrezziListaAttesa() {
		this.borsa.addAttrezzo(this.masso);
		this.borsa.addAttrezzo(this.piuma);
		assertEquals(list(this.piuma, this.masso), this.borsa.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_dueAttrezziPesiUgualiListaAttesa() {
		this.borsa.addAttrezzo(this.piuma);
		this.borsa.addAttrezzo(this.fazzoletto);
		assertEquals(list(this.fazzoletto, this.piuma), this.borsa.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_piuOggetti() {
		this.borsa.addAttrezzo(this.masso);
		this.borsa.addAttrezzo(this.fazzoletto);
		this.borsa.addAttrezzo(this.piuma);
		assertEquals(list(this.fazzoletto,this.piuma, this.masso), this.borsa.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_borsaVuota() {
		assertTrue(this.borsa.getContenutoOrdinatoPerNome().isEmpty());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_unAttrezzo() {
		this.borsa.addAttrezzo(this.piuma);
		assertSame(1, this.borsa.getContenutoOrdinatoPerNome().size());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_unAttrezzoListaAttesa() {
		this.borsa.addAttrezzo(this.piuma);
		assertEquals(sortedSet(this.piuma), this.borsa.getContenutoOrdinatoPerNome());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_stessoAttrezzoInseritoPiuVolte() {
		this.borsa.addAttrezzo(this.piuma);
		this.borsa.addAttrezzo(this.piuma);
		assertSame(1, this.borsa.getContenutoOrdinatoPerNome().size());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_attrezziStessoPeso() {
		this.borsa.addAttrezzo(this.piuma);
		this.borsa.addAttrezzo(this.fazzoletto);
		assertEquals(this.fazzoletto, this.borsa.getContenutoOrdinatoPerNome().first());
		assertEquals(this.piuma, this.borsa.getContenutoOrdinatoPerNome().last());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_piuAttrezzi() {
		this.borsa.addAttrezzo(this.masso);
		this.borsa.addAttrezzo(this.piuma);
		Iterator<Attrezzo> it = this.borsa.getContenutoOrdinatoPerNome().iterator();
		assertEquals(this.masso, it.next());
		assertEquals(this.piuma, it.next());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso_borsaVuota() {
		assertTrue(this.borsa.getContenutoRaggruppatoPerPeso().isEmpty());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso_unAttrezzo_esisteChiave() {
		this.borsa.addAttrezzo(this.piuma);
		assertTrue(this.borsa.getContenutoRaggruppatoPerPeso().containsKey(this.piuma.getPeso()));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso_unAttrezzo_dimensioneCorrettaMap() {
		this.borsa.addAttrezzo(this.piuma);
		assertSame(1, this.borsa.getContenutoRaggruppatoPerPeso().size());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso_unAttrezzo_dimensioneCorrettaSet() {
		this.borsa.addAttrezzo(this.piuma);
		assertSame(1, this.borsa.getContenutoRaggruppatoPerPeso().get(this.piuma.getPeso()).size());
	}
	
	// 2attrezzi stesso peso -> solo 1 chiave
	@Test
	public void testGetContenutoRaggruppatoPerPeso_piuAttrezziStessoPeso_unicaChiave() {
		this.borsa.addAttrezzo(this.fazzoletto);
		this.borsa.addAttrezzo(this.piuma);
		assertSame(1, this.borsa.getContenutoRaggruppatoPerPeso().size());
	}
	
	// 2attrezzi stesso peso -> set dim = 2
	@Test
	public void testGetContenutoRaggruppatoPerPeso_piuAttrezziStessoPeso_dimensioneSet() {
		this.borsa.addAttrezzo(this.fazzoletto);
		this.borsa.addAttrezzo(this.piuma);
		assertSame(2, this.borsa.getContenutoRaggruppatoPerPeso().get(this.piuma.getPeso()).size());
	}
	
	// 2attrezzi stesso peso -> la map contiene entrambi gli oggetti
	@Test
	public void testGetContenutoRaggruppatoPerPeso_piuAttrezziStessoPeso_attrezziGiusti() {
		this.borsa.addAttrezzo(this.fazzoletto);
		this.borsa.addAttrezzo(this.piuma);
		assertTrue(this.borsa.getContenutoRaggruppatoPerPeso().get(this.piuma.getPeso()).contains(this.piuma));
		assertTrue(this.borsa.getContenutoRaggruppatoPerPeso().get(this.piuma.getPeso()).contains(this.fazzoletto));
	}
	
	// 2attrezzi nome uguale -> set dim = 1
	@Test
	public void testGetContenutoRaggruppatoPerPeso_piuAttrezziNomeUguale_dimensioneSet() {
		Attrezzo piuma2 = new Attrezzo(this.piuma.getNome(), this.piuma.getPeso());
		this.borsa.addAttrezzo(this.piuma);
		this.borsa.addAttrezzo(piuma2);
		assertSame(1, this.borsa.getContenutoRaggruppatoPerPeso().get(this.piuma.getPeso()).size());
	}
	
	// 2attrezzi nome uguale peso diverso -> solo 1 chiave
	@Test
	public void testGetContenutoRaggruppatoPerPeso_piuAttrezziNomeUguale_dimensioneMap() {
		Attrezzo piuma2 = new Attrezzo(this.piuma.getNome(), this.piuma.getPeso());
		this.borsa.addAttrezzo(this.piuma);
		this.borsa.addAttrezzo(piuma2);
		assertSame(1, this.borsa.getContenutoRaggruppatoPerPeso().size());
	}
	
	// 2attrezzi peso diverso -> 2 chiavi
	@Test
	public void testGetContenutoRaggruppatoPerPeso_piuAttrezziDiversi_dimensioneMap() {
		this.borsa.addAttrezzo(this.piuma);
		this.borsa.addAttrezzo(this.masso);
		assertSame(2, this.borsa.getContenutoRaggruppatoPerPeso().size());
	}
	
	// 2 attrezzi peso diverso -> gli attrezzi nella map sono quelli desiderati
	@Test
	public void testGetContenutoRaggruppatoPerPeso_piuAttrezziDiversi_contenutiCorrettamente() {
		this.borsa.addAttrezzo(this.piuma);
		this.borsa.addAttrezzo(this.masso);
		assertTrue(this.borsa.getContenutoRaggruppatoPerPeso().get(this.piuma.getPeso()).contains(this.piuma));
		assertTrue(this.borsa.getContenutoRaggruppatoPerPeso().get(this.masso.getPeso()).contains(this.masso));
	}
	
	// 2attrezzi peso diverso -> set dim = 1 in entrambi i set
	@Test
	public void testGetContenutoRaggruppatoPerPeso_piuAttrezziDiversi_dimensioneSet() {
		this.borsa.addAttrezzo(this.piuma);
		this.borsa.addAttrezzo(this.masso);
		assertSame(1, this.borsa.getContenutoRaggruppatoPerPeso().get(this.piuma.getPeso()).size());
		assertSame(1, this.borsa.getContenutoRaggruppatoPerPeso().get(this.masso.getPeso()).size());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_borsaVuota() {
		assertTrue(this.borsa.getSortedSetOrdinatoPerPeso().isEmpty());
	}
	
	// 2 attrezzi con lo stesso peso -> size = 2
	@Test
	public void testGetSortedSetOrdinatoPerPeso_pesoUguale_dimensioneSet() {
		this.borsa.addAttrezzo(this.piuma);
		this.borsa.addAttrezzo(this.fazzoletto);
		assertSame(2, this.borsa.getSortedSetOrdinatoPerPeso().size());
	}
	
	// 2 attrezzi con lo stesso peso -> ordinati per nome
	@Test
	public void testGetSortedSetOrdinatoPerPeso_pesoUguale_ordinatiPerNome() {
		this.borsa.addAttrezzo(this.piuma);
		this.borsa.addAttrezzo(this.fazzoletto);
		assertSame(this.fazzoletto, this.borsa.getSortedSetOrdinatoPerPeso().first());
		assertSame(this.piuma, this.borsa.getSortedSetOrdinatoPerPeso().last());
	}
	
	// 2 attrezzi con nome diverso -> contenuti nel set
	@Test
	public void testGetSortedSetOrdinatoPerPeso_diversoNome_contenutiNelSet() {
		this.borsa.addAttrezzo(this.piuma);
		this.borsa.addAttrezzo(this.fazzoletto);
		assertTrue(this.borsa.getSortedSetOrdinatoPerPeso().contains(this.piuma));
		assertTrue(this.borsa.getSortedSetOrdinatoPerPeso().contains(this.fazzoletto));
	}
	
	// 2 attrezzi con nome uguale e peso diverso -> il set ha dimensione 1
	@Test
	public void testGetSortedSetOrdinatoPerPeso_nomeUgualePesoDiverso_dimensioneSet() {
		this.borsa.addAttrezzo(this.piuma);
		Attrezzo piuma2 = new Attrezzo("piuma", 1);
		this.borsa.addAttrezzo(piuma2);
		assertSame(1, this.borsa.getSortedSetOrdinatoPerPeso().size());
	}
	
	// 2 attrezzi con pesi diversi -> ordinati per peso
	@Test
	public void testGetSortedSetOrdinatoPerPeso_ordinatiCorrettamente() {
		this.borsa.addAttrezzo(this.masso);
		this.borsa.addAttrezzo(this.piuma);
		assertSame(this.piuma, this.borsa.getSortedSetOrdinatoPerPeso().first());
		assertSame(this.masso, this.borsa.getSortedSetOrdinatoPerPeso().last());
	}
}
