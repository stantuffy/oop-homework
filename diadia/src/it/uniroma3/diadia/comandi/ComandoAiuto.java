package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando implements Comando {
	
	@Override
	public void esegui(Partita partita) {
		StringBuilder s = new StringBuilder("");
		for(String comando: FabbricaDiComandiFisarmonica.ELENCO_COMANDI) {
			s.append(comando + " ");
		}
		System.out.println(s);
	}

	@Override
	public String getNome() {
		return "aiuto";
	}
}
