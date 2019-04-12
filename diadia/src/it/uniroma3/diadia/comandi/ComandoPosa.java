package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public void esegui(Partita partita) {
		Giocatore giocatore = partita.getGiocatore();
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		
		// Controllo se tale attrezzo esiste nella borsa
		Attrezzo attrezzo = giocatore.posa(nomeAttrezzo);
		if(attrezzo == null) {
			System.out.println("Non possiedi un oggetto con quel nome.");
			return;
		}
		
		// Controllo se nella stanza c'è spazio a sufficienza.
		if(! stanzaCorrente.addAttrezzo(attrezzo)) {
			System.out.println("Non c'è abbastanza spazio nella stanza.");
			
			// Ripristino l'attrezzo nella borsa del giocatore.
			giocatore.prendi(attrezzo);
			return;
		}
		
		System.out.println("Hai lasciato cadere " + nomeAttrezzo);
	}
	
	@Override
	public String getNome() {
		return "posa";
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
