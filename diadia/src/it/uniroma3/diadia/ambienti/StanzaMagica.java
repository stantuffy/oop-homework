package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	private int numeroAttrezziPosati;
	private int sogliaMagica;
	
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.sogliaMagica = soglia;
		this.numeroAttrezziPosati = 0;
	}
	
	
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder sb = new StringBuilder(attrezzo.getNome());
		sb.reverse();
		
		attrezzo.setPeso(attrezzo.getPeso() * 2);
		return attrezzo;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(!super.addAttrezzo(attrezzo))
			return false;
		this.numeroAttrezziPosati ++;
		if (this.numeroAttrezziPosati >= this.sogliaMagica) 
			modificaAttrezzo(attrezzo);
		
		return true;
	}
 }