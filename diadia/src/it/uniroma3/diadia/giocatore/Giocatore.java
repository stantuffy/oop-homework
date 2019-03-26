package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	private int cfu;
	Borsa borsa;

	public Giocatore() {
		this(0);
	}
	
	public Giocatore(int cfu) {
		this.borsa = new Borsa();
		this.cfu = cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public boolean prendi(Attrezzo attrezzo) {
		return this.borsa.addAttrezzo(attrezzo);
	}
	
	public Attrezzo posa(String nomeAttrezzo) {
		return this.borsa.removeAttrezzo(nomeAttrezzo);
	}
}
