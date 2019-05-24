package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoGuarda implements Comando {
	
	@Override
	public void setParametro(String parametro) {}
	
	@Override
	public void esegui(Partita partita) {
		Giocatore giocatore = partita.getGiocatore();
		Borsa borsa = giocatore.getBorsa();
		
		System.out.println("=======================================");
		System.out.println("Al momento hai " + giocatore.getCfu() + " cfu.");
		System.out.println(partita.getStanzaCorrente().getDescrizione());
		System.out.println(borsa.getDescrizione());
		System.out.println("=======================================");
	}
	
	@Override
	public String getNome() {
		return "guarda";
	}
	
	@Override
	public String getParametro() {
		return "";
	}
}
