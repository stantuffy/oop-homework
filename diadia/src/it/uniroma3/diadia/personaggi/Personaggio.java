package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

public abstract class Personaggio {
	
	private String nome;
	private String presentazione;
	private boolean haSalutato;
	
	public Personaggio(String nome, String presentazione) {
		this.nome = nome;
		this.presentazione = presentazione;
		this.haSalutato = false;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDescrizione() {
		return this.presentazione;
	}
	
	public String saluta() {
		StringBuilder risposta = new StringBuilder("Ciao, io sono ");
		risposta.append(this.getNome() + ".\n");
		
		if(this.haSalutato())
			risposta.append("Piacere di conoscerti!\n");
		else
			risposta.append("Ci siamo già presentati.\n");
		
		this.haSalutato = true;
		return risposta.toString();
	}
	
	public boolean haSalutato() {
		return this.haSalutato;
	}
	
	public abstract String interagisci(Partita partita);

	@Override
	public String toString() {
		return this.getNome();
	}
}
