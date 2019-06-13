package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

/**
 * 
 * @author albertoubuntu
 * Classe che ha l'unico scopo di concretizzare Personaggio,
 * affinchè possa essere testata.
 */
public class MockPersonaggio extends Personaggio {

	public MockPersonaggio(String nome, String presentazione) {
		super(nome, presentazione);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String interagisci(Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}

}
