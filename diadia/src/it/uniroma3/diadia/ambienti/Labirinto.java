package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe ha la responsabilità di creare il labirinto, 
 * di memorizzare la stanza iniziale (entrata) e quella finale (uscita).
 * 
 * @author albertoubuntu
 * 
 */

public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	public Labirinto() {
		this.creaStanze();
	}
	
	public void setStanzaCorrente(Stanza stanza) {
		this.stanzaCorrente = stanza;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	private void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente(DirezioneStanza.Nord, biblioteca);
		atrio.impostaStanzaAdiacente(DirezioneStanza.Est, aulaN11);
		atrio.impostaStanzaAdiacente(DirezioneStanza.Sud, aulaN10);
		atrio.impostaStanzaAdiacente(DirezioneStanza.Ovest, laboratorio);
		aulaN11.impostaStanzaAdiacente(DirezioneStanza.Est, laboratorio);
		aulaN11.impostaStanzaAdiacente(DirezioneStanza.Ovest, atrio);
		aulaN10.impostaStanzaAdiacente(DirezioneStanza.Nord, atrio);
		aulaN10.impostaStanzaAdiacente(DirezioneStanza.Est, aulaN11);
		aulaN10.impostaStanzaAdiacente(DirezioneStanza.Ovest, laboratorio);
		laboratorio.impostaStanzaAdiacente(DirezioneStanza.Est, atrio);
		laboratorio.impostaStanzaAdiacente(DirezioneStanza.Ovest, aulaN11);
		biblioteca.impostaStanzaAdiacente(DirezioneStanza.Sud, atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
        this.stanzaCorrente = atrio;  
		this.stanzaVincente = biblioteca;
	}
}
