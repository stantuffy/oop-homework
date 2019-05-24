package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe ha la responsabilità di creare il labirinto, 
 * di memorizzare la stanza iniziale (entrata) e quella finale (uscita).
 * 
 * @author albertoubuntu & roberto
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
    	final Attrezzo lanterna = new Attrezzo("lanterna",3);
		final Attrezzo osso = new Attrezzo("osso",1);
		final Attrezzo gesso = new Attrezzo("gesso",0);
		final Attrezzo piedeDiPorco = new Attrezzo("piede di porco",9);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza aulaStudio = new Stanza("Aula studio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza bagno = new StanzaBuia("Bagno");
		Stanza aulaN1 = new StanzaBloccata("Aula N1", Direzione.Nord);
		
		/* collega le stanze */
		
		bagno.impostaStanzaAdiacente(Direzione.Est, aulaN11);
		
		aulaN1.impostaStanzaAdiacente(Direzione.Sud, atrio);
		aulaN1.impostaStanzaAdiacente(Direzione.Ovest, aulaStudio);
		
		atrio.impostaStanzaAdiacente(Direzione.Nord, biblioteca);
		atrio.impostaStanzaAdiacente(Direzione.Est, aulaN11);
		atrio.impostaStanzaAdiacente(Direzione.Sud, aulaN10);
		atrio.impostaStanzaAdiacente(Direzione.Ovest, laboratorio);
		
		aulaN11.impostaStanzaAdiacente(Direzione.Est, laboratorio);
		aulaN11.impostaStanzaAdiacente(Direzione.Ovest, atrio);
		
		aulaN10.impostaStanzaAdiacente(Direzione.Nord, atrio);
		aulaN10.impostaStanzaAdiacente(Direzione.Est, aulaN11);
		aulaN10.impostaStanzaAdiacente(Direzione.Ovest, laboratorio);
		
		laboratorio.impostaStanzaAdiacente(Direzione.Est, atrio);
		laboratorio.impostaStanzaAdiacente(Direzione.Ovest, aulaN11);
		
		biblioteca.impostaStanzaAdiacente(Direzione.Sud, atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN11.addAttrezzo(lanterna);
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
        this.stanzaCorrente = atrio;  
		this.stanzaVincente = biblioteca;
	}
}
