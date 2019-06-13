package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

public class Cane extends Personaggio {
	
	private final static String MESSAGGIO_MORSO = "Il cane ti ha morso! Hai perso 1 CFU...";

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String interagisci(Partita partita) {
		int cfu = partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(cfu - 1);
		return MESSAGGIO_MORSO;
	}

}
