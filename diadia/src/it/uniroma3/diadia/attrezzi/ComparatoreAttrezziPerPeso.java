package it.uniroma3.diadia.attrezzi;
import java.util.Comparator;

public class ComparatoreAttrezziPerPeso implements Comparator<Attrezzo> {
	
	@Override
	public int compare(Attrezzo a1, Attrezzo a2) {
		return a1.getPeso() - a2.getPeso();
	}
}
