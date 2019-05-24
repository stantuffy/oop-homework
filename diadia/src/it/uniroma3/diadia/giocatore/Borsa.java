package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.*;
import java.util.*;


public class Borsa {
	private HashMap<String,Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int pesoAttuale;
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.pesoAttuale = 0;
		this.numeroAttrezzi = 0;
		this.attrezzi = new HashMap<String,Attrezzo>();
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (pesoAttuale <= pesoMax && attrezzo.getPeso() <= pesoMax) {
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
			pesoAttuale += attrezzo.getPeso();
			numeroAttrezzi++;
			return true;
		}
		return false;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public int getPesoAttuale() {
		return pesoAttuale;
	}
	
	public int getNumeroAttrezzi() {
		return attrezzi.size();
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo daRimuovere = this.attrezzi.remove(nomeAttrezzo);
		if (daRimuovere != null)
			numeroAttrezzi--;
		return daRimuovere;
		
			
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> ordinata = new ArrayList<>(this.getNumeroAttrezzi());
		
		for (Attrezzo a : this.attrezzi.values()) 
			ordinata.add(a);
		
		Collections.sort(ordinata, new ComparatoreAttrezziPerPeso());
		return ordinata;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> ordinato = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerNome());
		ordinato.addAll(this.attrezzi.values());
		return ordinato;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer,Set<Attrezzo>> raggruppato = new HashMap<>(this.getPesoMax());
		
		for (int i=0; i<=this.getPesoMax(); i++) {
			raggruppato.put(i, getSetAttrezzoPerPeso(i));
		}
		return raggruppato;
	}
	
	public Set<Attrezzo> getSetAttrezzoPerPeso(int peso) {
		Set<Attrezzo> set = new TreeSet<>();
		for (Attrezzo a : this.attrezzi.values()) {
			if (a.getPeso() == peso)
				set.add(a);
		}
		return set;
	}
	
	public String getDescrizione() {
		return this.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if(!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPesoAttuale() + "kg/" + this.getPesoMax() + "kg): ");
			for(Attrezzo a : this.attrezzi.values())
				s.append(a.toString() + " ");
		}
		else
			s.append("Borsa vuota");
		
		return s.toString();
	}
}
