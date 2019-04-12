package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	
	@Override
	public void setParametro(String parametro) {}
	
	@Override
	public void esegui(Partita partita) {
		System.out.println("Grazie per aver giocato!");
		partita.setFinita();
	}
	
	@Override
	public String getNome() {
		return "fine";
	}
	
	@Override
	public String getParametro() {
		return "";
	}
}
