package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando implements Comando {
	
	@Override
	public String getNome() {
		return "fine";
	}
	
	@Override
	public void esegui(Partita partita) {
		System.out.println("Grazie per aver giocato!");
		partita.setFinita();
	}
}
