package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		
		// Controllo se l'attrezzo esiste nella stanza
		if(! stanzaCorrente.hasAttrezzo(this.nomeAttrezzo)) {
			System.out.println("Non puoi prendere l'oggetto " + this.nomeAttrezzo + ".");
			return;
		}
		
		// Controllo se il giocatore ha spazio nella borsa
		Attrezzo attrezzo = stanzaCorrente.getAttrezzo(this.nomeAttrezzo);
		if(! partita.getGiocatore().prendi(attrezzo)) {
			System.out.println("Non hai più spazio nella borsa.");
			return;
		}
		
		if(! stanzaCorrente.removeAttrezzo(this.nomeAttrezzo)) {
			System.out.println("Impossibile raccogliere l'oggetto");
			return;
		}
		
		// Rimuovo l'attrezzo dalla stanza
		System.out.println(this.nomeAttrezzo + " aggiunto alla borsa.");
	}
	
	@Override
	public String getNome() {
		return "prendi";
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
