package it.uniroma3.diadia.attrezzi;

import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
public class Attrezzo implements Comparable<Attrezzo> {

	private String nome;
	private int peso;

	/**
	 * Crea un attrezzo
	 * @param nome il nome che identifica l'attrezzo
	 * @param peso il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}

	/**
	 * Restituisce il nome identificatore dell'attrezzo
	 * @return il nome identificatore dell'attrezzo
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce il peso dell'attrezzo
	 * @return il peso dell'attrezzo
	 */
	public int getPeso() {
		return this.peso;
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode() + this.getPeso();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		
		Attrezzo that = (Attrezzo)o;
		
		return this.getNome().equals(that.getNome()) && this.getPeso() == that.getPeso();
	}

	/**
	 * Restituisce una rappresentazione stringa di questo attrezzo
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}

	/**
	 * Compara per peso. A parità di peso, compara per nome.
	 */
	@Override
	public int compareTo(Attrezzo that) {
		int cmp = this.getPeso() - that.getPeso();
		if(cmp == 0)
			cmp = this.getNome().compareTo(that.getNome());
		
		return cmp;
	}

}