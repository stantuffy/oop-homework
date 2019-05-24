package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando implements Comando {
	
	@Override
	public void esegui(Partita partita) {
		if(super.getParametro() == null) {
			System.out.println("Dove vuoi andare?");
			return;
		}
		
		Stanza prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(super.getParametro());
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
			System.out.println("Direzione " + super.getParametro() + " bloccata");
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
}
