package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;

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
}
