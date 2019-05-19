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
    	Attrezzo chiave = new Attrezzo("chiave", 1);
		
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new StanzaBloccata("Aula N11", "nord", chiave.getNome());
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza babilonia = new StanzaBuia("Babilonia", lanterna.getNome());
		Stanza bagno = new Stanza("Bagno");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN11.impostaStanzaAdiacente("sud", aulaN10);
		aulaN11.impostaStanzaAdiacente("nord", babilonia);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		laboratorio.impostaStanzaAdiacente("sud", aulaN10);
		laboratorio.impostaStanzaAdiacente("nord", bagno);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		babilonia.impostaStanzaAdiacente("sud", aulaN11);
		babilonia.impostaStanzaAdiacente("est", atrio);
		bagno.impostaStanzaAdiacente("sud", laboratorio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		bagno.addAttrezzo(chiave);

		// il gioco comincia nell'atrio
        this.stanzaCorrente = atrio;  
		this.stanzaVincente = biblioteca;
	}
}
