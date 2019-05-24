package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {
	private String parametro;
	
	public AbstractComando(String parametro) {
		this.parametro = parametro;
	}
	
	public abstract void esegui(Partita partita);
	
	public abstract String getNome();
	
	public abstract String getParametro();
}
