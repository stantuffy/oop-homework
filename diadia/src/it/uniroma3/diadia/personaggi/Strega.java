package it.uniroma3.diadia.personaggi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.DirezioneStanza;

/**
 * 
 * @author albertoubuntu
 * Personaggio del gioco.
 * Trasporta il giocatore in una stanza adiacente, in dipendenza
 * dal fatto se ha salutato oppure no.
 * NB: si assume che la stanza corrente abbia almeno una stanza adiacente.
 */
public class Strega extends Personaggio {

	private static final String MESSAGGIO_INTERAZIONE_POSITIVA = "Che bella persona che sei! Ti sto per portare in un posto bellissimo...";
	private static final String MESSAGGIO_INTERAZIONE_NEGATIVA = "Chi t'ammort a ssorrt VAFANGUL";

	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	/**
	 * 
	 * @param partita Oggetto che rappresenta la partita corrente.
	 * @return Una lista di direzioni adiacenti alla stanza corrente, ordinate in base alla quantità di attrezzi presenti nelle stanze in tale direzione, in maniera crescente.
	 */
	public List<DirezioneStanza> ordinaDirezioniPerQuantitaOggettiStanza(final Partita partita) {
		List<DirezioneStanza> result = new ArrayList<>(partita.getStanzaCorrente().getDirezioni());
		
		Collections.sort(result, new Comparator<DirezioneStanza>() {

			@Override
			public int compare(DirezioneStanza d1, DirezioneStanza d2) {
				final int numAttrezziD1 = 
						partita.getStanzaCorrente().getStanzaAdiacente(d1).getNumAttrezzi();
				
				final int numAttrezziD2 =
						partita.getStanzaCorrente().getStanzaAdiacente(d2).getNumAttrezzi();
				
				return numAttrezziD1 - numAttrezziD2;
			}
			
		});
		
		return result;
	}
	
	@Override
	public String interagisci(Partita partita) {
		final List<DirezioneStanza> direzioniOrdinate =
				this.ordinaDirezioniPerQuantitaOggettiStanza(partita);
		DirezioneStanza direzione;
		String msg;
		
		if(this.haSalutato()) {
			// Se ha salutato, imposta la stanza corrente come quella
			// tra le stanze adiacenti, con più attrezzi.
			direzione = direzioniOrdinate.get(direzioniOrdinate.size() - 1);
			msg = MESSAGGIO_INTERAZIONE_POSITIVA;
		}
		else {
			// Altrimenti, la stanza corrente diventa quella
			// che contiene meno attrezzi tra le stanze adiacenti.
			direzione = direzioniOrdinate.get(0);
			msg = MESSAGGIO_INTERAZIONE_NEGATIVA;
		}
		partita.setStanzaCorrente(
				partita.getStanzaCorrente().getStanzaAdiacente(direzione)
				);
		
		return msg;
	}
}
