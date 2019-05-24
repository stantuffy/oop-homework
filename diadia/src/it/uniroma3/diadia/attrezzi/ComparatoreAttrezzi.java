package it.uniroma3.diadia.attrezzi;
import java.util.Comparator;

public class ComparatoreAttrezzi implements Comparator<Attrezzo> {
	
	@Override
	public int compare(Attrezzo a1, Attrezzo a2) {
		int output = a1.getPeso() - a2.getPeso();
		if (output == 0)
			return a1.getNome().compareTo(a2.getNome());
		return output;
	}
}
