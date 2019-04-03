package it.uniroma3.diadia;

public interface Comando {
	public void setParametro(String parametro);
	
	public void esegui(Partita partita);
}
