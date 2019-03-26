package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	/**
	 * Verifica che non è possibile aggiungere oltre 10 attrezzi.
	 */
	@Test
	public void testAddAttrezzo_pieno() {
		Borsa borsa = new Borsa();
		
		Attrezzo attr = new Attrezzo("", 0);
		for(int i=0; i<10; i++)
			assertTrue("Attrezzo non inserito", borsa.addAttrezzo(attr));
		
		assertFalse("Nella borsa c'è più spazio di 10 elementi", borsa.addAttrezzo(attr));
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
}
