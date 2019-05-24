package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {
	private static final String _ISTRUZIONE_NON_VALIDA = "non esiste";
	private static final String _ISTRUZIONE_VAI_VALIDA = "vai nord";
	private static final String _ISTRUZIONE_VAI_NON_VALIDA = "vai ";
	private FabbricaDiComandiFisarmonica factory;
	
	@Before
	public void setUp() {
		this.factory = new FabbricaDiComandiFisarmonica();
	}
	
	@Test
	public void testCreaComandoIstruzioneInesistente() {
		assertEquals("", this.factory.creaComando(_ISTRUZIONE_NON_VALIDA).getNome());
		assertEquals("", this.factory.creaComando(_ISTRUZIONE_NON_VALIDA).getParametro());
	}
	
	@Test
	public void testCreaComandoVaiParametroValido() {
		Comando comando = this.factory.creaComando(_ISTRUZIONE_VAI_VALIDA);
		assertEquals("vai", comando.getNome());
		assertEquals("nord", comando.getParametro());
	}
	
	@Test
	public void testCreaComandoVaiParametroNonValido() {
		Comando comando = this.factory.creaComando(_ISTRUZIONE_VAI_NON_VALIDA);
		assertEquals("vai", comando.getNome());
		assertEquals("", comando.getParametro());
	}
	
	// Aiuto -> il suo nome è "aiuto"
	@Test
	public void testCreaComandoAiutoNomeCorretto() {
		Comando comandoAiuto = this.factory.creaComando("aiuto");
		assertEquals("aiuto", comandoAiuto.getNome());
	}
	
	// Aiuto -> il suo parametro è ""
	@Test
	public void testCreaComandoAiutoSenzaParametro() {
		Comando comandoAiuto = this.factory.creaComando("aiuto");
		assertEquals("", comandoAiuto.getParametro());
	}
	
	
//	// Aiuto con parametro -> il suo parametro è ""
//	@Test
//	public void testCreaComandoAiutoConParametro() {
//		Comando comandoAiuto = this.factory.creaComando("aiuto parametro");
//		assertEquals("", comandoAiuto.getParametro());
//	}
//	
//	// Fine con parametro -> il suo parametro è ""
//	@Test
//	public void testCreaComandoFineConParametro() {
//		Comando comandoFine = this.factory.creaComando("fine parametro");
//		assertEquals("", comandoFine.getParametro());
//	}
	
	// Fine -> il suo parametro è la stringa vuota
	@Test
	public void testCreaComandoFineSenzaParametro() {
		Comando comandoFine = this.factory.creaComando("fine");
		assertEquals("", comandoFine.getParametro());
	}
	
	// Fine -> il suo nome è "fine"
	@Test
	public void testCreaComandoFineNomeCorretto() {
		Comando comandoFine = this.factory.creaComando("fine");
		assertEquals("fine", comandoFine.getNome());
	}
	
	// Guarda -> il suo nome è "guarda"
	@Test
	public void testCreaComandoGuardaNomeCorretto() {
		Comando comandoGuarda = this.factory.creaComando("guarda");
		assertEquals("guarda", comandoGuarda.getNome());
	}
	
	// Guarda -> il suo parametro è ""
	@Test
	public void testCreaComandoGuardaSenzaParametro() {
		Comando comandoGuarda = this.factory.creaComando("guarda");
		assertEquals("", comandoGuarda.getParametro());
	}
	
	// Guarda con parametro -> il suo parametro è ""
	@Test
	public void testCreaComandoGuardaConParametro() {
		Comando comandoGuarda = this.factory.creaComando("guarda parametro");
		assertEquals("", comandoGuarda.getParametro());
	}
	
	// Posa -> il nome è "posa"
	@Test
	public void testCreaComandoPosaNomeCorretto() {
		Comando comandoPosa = this.factory.creaComando("posa");
		assertEquals("posa", comandoPosa.getNome());
	}
	
	// Posa senza parametro -> il parametro è ""
	@Test
	public void testCreaComandoPosaSenzaParametro() {
		Comando comandoPosa = this.factory.creaComando("posa");
		assertEquals("", comandoPosa.getParametro());
	}
	
	// Posa con parametro $p -> il parametro è $p
	@Test
	public void testCreaComandoPosaConParametro() {
		Comando comandoPosa = this.factory.creaComando("posa parametro");
		assertEquals("parametro", comandoPosa.getParametro());
	}

	// Prendi -> il nome è "prendi"
	@Test
	public void testCreaComandoPrendiNomeCorretto() {
		Comando comandoPrendi = this.factory.creaComando("prendi");
		assertEquals("prendi", comandoPrendi.getNome());
	}
	
	// Prendi senza parametro -> il parametro è ""
	@Test
	public void testCreaComandoPrendiSenzaParametro() {
		Comando comandoPrendi = this.factory.creaComando("prendi");
		assertEquals("", comandoPrendi.getParametro());
	}
	
	// Prendi con parametro $p -> il parametro è $p
	@Test
	public void testCreaComandoPrendiConParametro() {
		Comando comandoPrendi = this.factory.creaComando("prendi parametro");
		assertEquals("parametro", comandoPrendi.getParametro());
	}
}
