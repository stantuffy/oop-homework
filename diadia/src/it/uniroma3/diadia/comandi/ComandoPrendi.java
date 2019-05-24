package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando implements Comando {
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		
		// Controllo se l'attrezzo esiste nella stanza
		if(! stanzaCorrente.hasAttrezzo(super.getParametro())) {
			System.out.println("Non puoi prendere l'oggetto " + super.getParametro() + ".");
			return;
		}
		
		// Controllo se il giocatore ha spazio nella borsa
		Attrezzo attrezzo = stanzaCorrente.getAttrezzo(super.getParametro());
		if(! partita.getGiocatore().prendi(attrezzo)) {
			System.out.println("Non hai più spazio nella borsa.");
			return;
		}
		
		if(! stanzaCorrente.removeAttrezzo(super.getParametro())) {
			System.out.println("Impossibile raccogliere l'oggetto");
			return;
		}
		
		// Rimuovo l'attrezzo dalla stanza
		System.out.println(super.getParametro() + " aggiunto alla borsa.");
	}

	@Override
	public String getNome() {
		return "prendi";
	}
}
