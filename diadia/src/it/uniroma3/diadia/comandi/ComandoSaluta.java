package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.Personaggio;

public class ComandoSaluta extends AbstractComando {
	private final static String MESSAGGIO_PERSONAGGIO_NON_TROVATO = "Non c'è nessuno qui...";

	@Override
	public String getNome() {
		return "saluta";
	}

	@Override
	public void esegui(Partita partita) {
		Personaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		
		if(personaggio == null) {
			System.out.println(MESSAGGIO_PERSONAGGIO_NON_TROVATO);
			return;
		}
		
		System.out.println(personaggio.saluta());
	}

}
