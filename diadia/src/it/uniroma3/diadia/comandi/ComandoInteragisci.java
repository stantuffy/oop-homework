package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.Personaggio;

public class ComandoInteragisci extends AbstractComando {

	private static final String MESSAGGIO_CON_CHI = "Non c'è nessuno qui...";
	private String messaggio;

	@Override
	public String getNome() {
		return "interagisci";
	}

	@Override
	public void esegui(Partita partita) {
		Personaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		if(personaggio == null) {
			 System.out.println(MESSAGGIO_CON_CHI);
			 return;
		}
		this.messaggio = personaggio.interagisci(partita);
		System.out.println(this.getMessaggio());
	}

	private String getMessaggio() {
		return this.messaggio;
	}
}
