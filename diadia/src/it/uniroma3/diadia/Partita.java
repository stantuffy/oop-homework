package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 20;

	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	public Partita(){
		this.finita = false;
		this.giocatore = new Giocatore(CFU_INIZIALI);
		this.labirinto = new Labirinto();
	}
	
	public Stanza getStanzaCorrente() {
		return this.labirinto.getStanzaCorrente();
	}
	
	public void setStanzaCorrente(Stanza stanza) {
		this.labirinto.setStanzaCorrente(stanza);
	}
	
	public Stanza getStanzaVincente() {
		return this.labirinto.getStanzaVincente();
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return (
			this.getStanzaCorrente() == 
			this.getStanzaVincente()
		);
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() <= 0);
	}
 
	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}
}
