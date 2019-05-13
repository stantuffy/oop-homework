package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private String nomeDirezioneBloccata;
	private String nomeAttrezzoSbloccante;

	public StanzaBloccata(String nomeStanza, String nomeDirezione, String nomeAttrezzo) {
		super(nomeStanza);
		this.nomeDirezioneBloccata = nomeDirezione;
		this.nomeAttrezzoSbloccante = nomeAttrezzo;
	}
	
	public String getNomeDirezioneBloccata() {
		return this.nomeDirezioneBloccata;
	}
	
	public String getNomeAttrezzoSbloccante() {
		return this.nomeAttrezzoSbloccante;
	}
	
	@Override
	public Stanza getStanzaAdiacente(DirezioneStanza direzione) {
		if(direzione.equals(this.nomeDirezioneBloccata)
			&& !super.hasAttrezzo(this.nomeAttrezzoSbloccante)) 
				return this;
		
		return super.getStanzaAdiacente(direzione);
	}

}
