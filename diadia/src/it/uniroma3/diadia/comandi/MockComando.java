package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * 
 * @author albertoubuntu
 * Classe che ha il solo scopo di istanziare concretamente AbstractComando,
 * ai fini di rendere testabile AbstractComando.
 */

public class MockComando extends AbstractComando {

	public MockComando() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub

	}

}
