package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	
	private static final Attrezzo CASCO = new Attrezzo("casco",2);
	private static final Attrezzo MAZZA = new Attrezzo("mazza",3);
	private static final Attrezzo FORCHETTA = new Attrezzo("forchetta",0);
	private static final Attrezzo ELEFANTE = new Attrezzo("elefante",100);
	private static final Attrezzo RIGHELLO = new Attrezzo("righello",1);
	
	@Test
	public void testAddAttrezzo_pieno() {
		Borsa borsa = new Borsa(100);
		borsa.addAttrezzo(new Attrezzo("elefante", 101));
		
		assertFalse(borsa.hasAttrezzo("elefante"));
	}
	
	@Test
	public void testPesoMax() {
		Borsa borsa = new Borsa(23);	
		assertEquals(23, borsa.getPesoMax());
	}
	
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
	
	@Test
	public void testGetAttrezzo_nonPresente() {
		Borsa borsa = new Borsa(30);
		
		assertNull(
				"E' stato trovato un oggetto inesistente nella borsa", 
				borsa.getAttrezzo("Non presente"));
	}
	
	@Test
	public void testEmpty_borsaNonVuota() {
		Borsa borsa = new Borsa(10);
		
		Attrezzo attr = new Attrezzo("Cocconcino", 2);
		borsa.addAttrezzo(attr);
		
		
		assertFalse("Un attrezzo è stato messo nella borsa, " + "ma continua a risultare vuota",borsa.isEmpty());
		assertTrue(borsa.getNumeroAttrezzi() == 1);
	}
	
	@Test
	public void testEmpty_borsaVuota() {
		Borsa borsa = new Borsa(1);
		
		assertTrue(
				"Borsa non vuota al momento della sua creazione", 
				borsa.isEmpty());
	}
	
	@Test
	public void testRemoveAttrezzo_nonPresente() {
		Borsa borsa = new Borsa(10);
		
		Attrezzo attr = new Attrezzo("Pallone", 0);
		borsa.addAttrezzo(attr);
	
		assertNull(borsa.removeAttrezzo("Spada"));
	}
	
	@Test
	public void testRemoveAttrezzo_null() {
		Borsa borsa = new Borsa(10);
		
		assertNull(
				"E' stato rimosso null dalla borsa",
				borsa.removeAttrezzo(null));
	}
	
	@Test
	public void testRemoveAttrezzo_presente() {
		Borsa borsa = new Borsa(10);
		
		Attrezzo attr = new Attrezzo("Spada", 10);
		borsa.addAttrezzo(attr);
		
		assertNotNull(
				"Non è stato possibile rimuovere un elemento esistente dalla borsa",
				borsa.removeAttrezzo("Spada"));
	}
	
	@Test
	public void testHasAttrezzo_nonPresente() {
		Borsa borsa = new Borsa(10);
		
		assertFalse("La borsa vuota dice che possiede un attrezzo", 
				borsa.hasAttrezzo("Pasta"));
	}
	
	@Test
	public void testHasAttrezzo_null() {
		Borsa borsa = new Borsa(10);
		
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
	
	@Test
	public void testGetPeso_onInit() {
		Borsa borsa = new Borsa(10);
		
		assertEquals(
				"La borsa appena creata pesa più di zero",
				0, borsa.getPesoAttuale());
	}
	
	@Test
	public void testGetPeso() {
		Borsa borsa = new Borsa(30);
		
		Attrezzo[] attr = new Attrezzo[5];
		
		attr[0] = new Attrezzo("Porchetta", 9);
		attr[1] = new Attrezzo("Guanciale", 2);
		attr[2] = new Attrezzo("Pasta", 3);
		attr[3] = new Attrezzo("Piatto", 4);
		attr[4] = new Attrezzo("Uova", 10);
		
		for(int i=0; i<5; i++)
			borsa.addAttrezzo(attr[i]);
		
		assertFalse(30 == borsa.getPesoAttuale());
		assertEquals(28, borsa.getPesoAttuale());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		Borsa b = new Borsa(20);
		b.addAttrezzo(CASCO);
		b.addAttrezzo(MAZZA);
		b.addAttrezzo(FORCHETTA);
		
		assertTrue(b.getContenutoOrdinatoPerPeso().indexOf(FORCHETTA) == 0);
		assertFalse(b.getContenutoOrdinatoPerPeso().indexOf(MAZZA) == 1);
		
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		Borsa b = new Borsa(20);
		b.addAttrezzo(CASCO);
		b.addAttrezzo(MAZZA);
		b.addAttrezzo(FORCHETTA);
		
		assertTrue(b.getContenutoOrdinatoPerNome().first().equals(CASCO));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Borsa b = new Borsa(20);
		b.addAttrezzo(CASCO);
		b.addAttrezzo(ELEFANTE);
		b.addAttrezzo(FORCHETTA);
		b.addAttrezzo(MAZZA);
		b.addAttrezzo(RIGHELLO);
		
		assertTrue(b.getContenutoRaggruppatoPerPeso().get(1).contains(RIGHELLO));
		assertTrue(b.getContenutoRaggruppatoPerPeso().get(1).size() == 1);
		assertTrue(b.getContenutoRaggruppatoPerPeso().get(20).size() == 0);
	}
}
