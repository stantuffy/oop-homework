package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractComandoTest {
	private AbstractComando comando;

	@Before
	public void setUp() throws Exception {
		this.comando = new MockComando();
	}

	@Test
	public void testSetParametro_funzionaCorrettamente() {
		this.comando.setParametro("param");
		assertEquals("param", this.comando.getParametro());
	}

}
