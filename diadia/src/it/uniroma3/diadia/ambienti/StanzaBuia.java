package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private final static String BLIND_DESCRIZIONE = "Qui c'è un buio pesto.";
	private String nomeAttrezzoIlluminante;

	public StanzaBuia(String nome, String nomeAttrezzoIlluminante) {
		super(nome);
		this.nomeAttrezzoIlluminante = nomeAttrezzoIlluminante;
	}
	
	public String getNomeAttrezzoIlluminante() {
		return this.nomeAttrezzoIlluminante;
	}
	
	public String getBlindDescrizione() {
		return BLIND_DESCRIZIONE;
	}
	
	@Override
	public String getDescrizione() {
		if(!super.hasAttrezzo(this.nomeAttrezzoIlluminante))
			return this.getBlindDescrizione();
		else
			return super.getDescrizione();
	}

}
