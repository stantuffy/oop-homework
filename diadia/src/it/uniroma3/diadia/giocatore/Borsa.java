package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNome;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	// private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String, Attrezzo>();
		// this.numeroAttrezzi = 0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo == null)
			return false;
		
		if(this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return this.attrezzi.containsKey(attrezzo.getNome()) &&
				this.attrezzi.get(attrezzo.getNome()).equals(attrezzo);
	}
	
	public int getNumAttrezzi() {
		return this.attrezzi.size();
	}

	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
				
//		Attrezzo a = null;
//		for(int i=0; i<this.numeroAttrezzi; i++)
//			if(this.attrezzi[i].getNome().contentEquals(nomeAttrezzo))
//				a = attrezzi[i];
//		
//		return a;
	}
	
	public int getPeso() {
		int peso = 0;
		
//		for(int i=0; i<this.numeroAttrezzi; i++)
//			peso += this.attrezzi[i].getPeso();
		
		for(Attrezzo attr: this.attrezzi.values()) {
			peso += attr.getPeso();
		}
		
		return peso;
	}
	
	public boolean isEmpty() {
//		return this.numeroAttrezzi == 0;
		return this.getNumAttrezzi() == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(nomeAttrezzo);
//		Attrezzo a = null;
//		
//		if(nomeAttrezzo == null)
//			return a;
//		
//		int i;
//		for(i=0; i<this.numeroAttrezzi; i++) {
//			if(this.attrezzi[i].getNome().contentEquals(nomeAttrezzo)) {
//				a = this.attrezzi[i];
//				this.attrezzi[i] = null;
//				break;
//			}
//		}
//		
//		/**
//		 * Se ho rimosso l'attrezzo,
//		 * sposto a sinistra tutti gli attrezzi di una posizione
//		 * in modo tale da avere tutti attrezzi a sinistra
//		 * e tutti null a destra.
//		 */
//		if(a != null) {
//			i++;
//			for(; i<this.numeroAttrezzi; i++)
//				this.attrezzi[i-1] = this.attrezzi[i];
//			this.numeroAttrezzi--;
//		}
//		
//		return a;
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> res = new ArrayList<>(this.attrezzi.values());
		Collections.sort(res);
		return res;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> res = new TreeSet<>(new ComparatorePerNome());
		res.addAll(this.attrezzi.values());
		return res;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer, Set<Attrezzo>> peso2attrezzi = new HashMap<>();
		for(Attrezzo attr: this.attrezzi.values()) {
			Set<Attrezzo> set = peso2attrezzi.get(attr.getPeso());
			if(set == null)
				set = new HashSet<Attrezzo>();
			set.add(attr);
			peso2attrezzi.put(attr.getPeso(), set);
		}
		
		return peso2attrezzi;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if(!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for(Attrezzo attr: this.attrezzi.values())
				s.append(attr.toString() + " ");
		}
		else
			s.append("Borsa vuota");
		
		return s.toString();
	}
}
