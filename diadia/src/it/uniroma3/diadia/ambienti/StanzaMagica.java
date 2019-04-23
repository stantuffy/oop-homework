package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	private static final int SOGLIA_MAGICA_DEFAULT = 5;
	private int sogliaMagica;
	private int contatoreAttrezziPosati;
	
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.sogliaMagica = soglia;
		this.contatoreAttrezziPosati = 0;
	}
	
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	public int getSogliaMagica() {
		return this.sogliaMagica;
	}
	
	public int getContatoreAttrezziPosati() {
		return this.contatoreAttrezziPosati;
	}
	
	// Raddoppia il peso dell'attrezzo passato come parametro
	// e ne inverte il nome.
	// Restituisce l'attrezzo modificato.
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder sb = new StringBuilder(attrezzo.getNome());
		sb.reverse();
		attrezzo.setNome(sb.toString());
		attrezzo.setPeso(attrezzo.getPeso() * 2);
		return attrezzo;
	}
	
	/**
	 * Aggiunge un oggetto alla stanza. 
	 * Ne inverte il nome e ne raddoppia il peso 
	 * se il numero di oggetti posati supera la soglia impostata.
	 * @see it.uniroma3.diadia.ambienti.Stanza#addAttrezzo(it.uniroma3.diadia.attrezzi.Attrezzo)
	 * @return True se l'attrezzo viene aggiunto correttamente, False altrimenti.
	 */
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(!super.addAttrezzo(attrezzo))
			return false;
		
		if(this.contatoreAttrezziPosati >= this.sogliaMagica)
			this.modificaAttrezzo(attrezzo);
		
		this.contatoreAttrezziPosati ++;
		
		return true;
	}
}
