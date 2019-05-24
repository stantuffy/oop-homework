package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	Direzione direzioneBloccata;
	String attrezzoChiave;
	
	public StanzaBloccata(String nome, Direzione direzione) {
		super(nome);
		this.direzioneBloccata = direzione;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if (!hasAttrezzo(attrezzoChiave) && direzione == direzioneBloccata) 
			return this;
		else
			return super.getStanzaAdiacente(direzione);
	}
}
