package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	@Override
	public void setParametro(String parametro) {}
	
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
	
	@Override
	public String getParametro() {
		return "";
	}
}
