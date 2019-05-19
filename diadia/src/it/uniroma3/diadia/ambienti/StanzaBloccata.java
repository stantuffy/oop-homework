package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private DirezioneStanza direzioneBloccata;
	private String nomeAttrezzoSbloccante;

	public StanzaBloccata(String nomeStanza, String nomeDirezione, String nomeAttrezzo) {
		super(nomeStanza);
		this.direzioneBloccata = DirezioneStanza.fromString(nomeDirezione);
		this.nomeAttrezzoSbloccante = nomeAttrezzo;
	}
	
	public DirezioneStanza getDirezioneBloccata() {
		return this.direzioneBloccata;
	}
	
	public String getNomeAttrezzoSbloccante() {
		return this.nomeAttrezzoSbloccante;
	}
	
	@Override
	public Stanza getStanzaAdiacente(DirezioneStanza direzione) {
		if(direzione.equals(this.direzioneBloccata)
			&& !super.hasAttrezzo(this.nomeAttrezzoSbloccante)) 
				return this;
		
		return super.getStanzaAdiacente(direzione);
	}
}
