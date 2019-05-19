package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public void esegui(Partita partita) {
		if(this.direzione == null) {
			System.out.println("Dove vuoi andare?");
			return;
		}
		
		Stanza prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(this.direzione);
		if(prossimaStanza == null) {
			System.out.println("Direzione inesistente");
			return;
		}

		Stanza stanzaPrecedente = partita.getStanzaCorrente();
		partita.setStanzaCorrente(prossimaStanza);

		// Check per la stanza bloccata.
		// Se, dopo aver cambiato stanza, la stanza corrente
		// è rimasta la stessa, allora la direzione percorsa
		// è bloccata. L'utente viene informato e non perde cfu.
		if(stanzaPrecedente == partita.getStanzaCorrente()) {
			System.out.println("Direzione " + this.direzione + " bloccata");
			return;
		}
		
		System.out.println(stanzaPrecedente.getNome() + " -> " + partita.getStanzaCorrente().getNome());

		int cfu = partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(cfu - 1);
		
	}
	
	@Override
	public String getNome() {
		return "vai";
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
	}
}
