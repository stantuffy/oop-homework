package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class Mago extends Personaggio {
	
	private final static String MESSAGGIO_SCUSE = "Pulciaro! Ti ho già dato tutto quello che avevo!";
	private final static String MESSAGGIO_INTERAZIONE = "Toh, poraccio! Ti regalo un bel dildo.";
	private final static String MESSAGGIO_INTERAZIONE_FALLITA = "Ue patacca! Se non lo vuoi me lo tengo, pheega.";
	
	private Attrezzo attrezzo;

	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	
	public boolean haUnAttrezzo() {
		return this.attrezzo != null;
	}

	@Override
	public String interagisci(Partita partita) {
		if(this.attrezzo == null)
			return MESSAGGIO_SCUSE;
		
		Borsa borsa = partita.getGiocatore().getBorsa();
		if(!borsa.addAttrezzo(this.attrezzo))
			return MESSAGGIO_INTERAZIONE_FALLITA;
		
		this.attrezzo = null;
		return MESSAGGIO_INTERAZIONE;
	}

}
