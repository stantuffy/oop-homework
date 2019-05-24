package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private static final String LANTERNA = "lanterna";
	
	public StanzaBuia(String nome) {
		super(nome);
	}
	
	@Override
	public String toString() {
		if (hasAttrezzo(LANTERNA))
			return "Qui c'è un buio pesto!";
		else
			return super.toString();
	}	
}
