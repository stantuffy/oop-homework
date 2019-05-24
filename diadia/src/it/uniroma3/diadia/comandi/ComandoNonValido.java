package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando implements Comando {
	
	@Override
	public String getNome() {
		return "";
	}

	@Override
	public void esegui(Partita partita) {
		System.out.println("Comando non riconosciuto.");
	}
}
