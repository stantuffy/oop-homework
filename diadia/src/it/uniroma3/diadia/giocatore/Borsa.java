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
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String, Attrezzo>();
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
	}
	
	public int getPeso() {
		int peso = 0;
		
		for(Attrezzo attr: this.attrezzi.values()) {
			peso += attr.getPeso();
		}
		
		return peso;
	}
	
	public boolean isEmpty() {
		return this.getNumAttrezzi() == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(nomeAttrezzo);
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
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		return new TreeSet<Attrezzo>(this.attrezzi.values());
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
