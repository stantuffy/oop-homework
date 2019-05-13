package it.uniroma3.diadia.ambienti;

public enum DirezioneStanza {
	Nord, Sud, Est, Ovest;
	
	/**
	 * Input: nome direzione, sotto forma di stringa.
	 * @param direzione
	 * @return enum della direzione, oppure null se la stringa non contiene una direzione valida.
	 */
	public static DirezioneStanza fromString(String direzione) {
		if(direzione == null)
			return null;
		
		for(DirezioneStanza dir: DirezioneStanza.values()) {
			direzione = direzione.toLowerCase();
			boolean check = direzione.equals(dir.toString());
			if(check)
				return dir;
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return this.name().toLowerCase();
	}
}
