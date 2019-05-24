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
	
	@Test
	public void testCreaComandoAiutoNomeCorretto() {
		Comando comandoAiuto = this.factory.creaComando("aiuto");
		assertEquals("aiuto", comandoAiuto.getNome());
	}
	
	@Test
	public void testCreaComandoAiutoSenzaParametro() {
		Comando comandoAiuto = this.factory.creaComando("aiuto");
		assertEquals("", comandoAiuto.getParametro());
	}
	
	@Test
	public void testCreaComandoAiutoConParametro() {
		Comando comandoAiuto = this.factory.creaComando("aiuto parametro");
		assertEquals("", comandoAiuto.getParametro());
	}
	
	@Test
	public void testCreaComandoFineConParametro() {
		Comando comandoFine = this.factory.creaComando("fine parametro");
		assertEquals("", comandoFine.getParametro());
	}
	
	@Test
	public void testCreaComandoFineSenzaParametro() {
		Comando comandoFine = this.factory.creaComando("fine");
		assertEquals("", comandoFine.getParametro());
	}
	
	@Test
	public void testCreaComandoFineNomeCorretto() {
		Comando comandoFine = this.factory.creaComando("fine");
		assertEquals("fine", comandoFine.getNome());
	}
	
	@Test
	public void testCreaComandoGuardaNomeCorretto() {
		Comando comandoGuarda = this.factory.creaComando("guarda");
		assertEquals("guarda", comandoGuarda.getNome());
	}
	
	@Test
	public void testCreaComandoGuardaSenzaParametro() {
		Comando comandoGuarda = this.factory.creaComando("guarda");
		assertEquals("", comandoGuarda.getParametro());
	}

	@Test
	public void testCreaComandoGuardaConParametro() {
		Comando comandoGuarda = this.factory.creaComando("guarda parametro");
		assertEquals("", comandoGuarda.getParametro());
	}
	
	@Test
	public void testCreaComandoPosaNomeCorretto() {
		Comando comandoPosa = this.factory.creaComando("posa");
		assertEquals("posa", comandoPosa.getNome());
	}
	
	@Test
	public void testCreaComandoPosaSenzaParametro() {
		Comando comandoPosa = this.factory.creaComando("posa");
		assertEquals("", comandoPosa.getParametro());
	}
	
	@Test
	public void testCreaComandoPosaConParametro() {
		Comando comandoPosa = this.factory.creaComando("posa parametro");
		assertEquals("parametro", comandoPosa.getParametro());
	}

	@Test
	public void testCreaComandoPrendiNomeCorretto() {
		Comando comandoPrendi = this.factory.creaComando("prendi");
		assertEquals("prendi", comandoPrendi.getNome());
	}
	
	@Test
	public void testCreaComandoPrendiSenzaParametro() {
		Comando comandoPrendi = this.factory.creaComando("prendi");
		assertEquals("", comandoPrendi.getParametro());
	}
	
	@Test
	public void testCreaComandoPrendiConParametro() {
		Comando comandoPrendi = this.factory.creaComando("prendi parametro");
		assertEquals("parametro", comandoPrendi.getParametro());
	}
}
