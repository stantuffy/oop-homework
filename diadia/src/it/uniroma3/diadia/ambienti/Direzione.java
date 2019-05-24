package it.uniroma3.diadia.ambienti;

public enum Direzione {
	Nord,Sud,Est,Ovest,Nessuna;
	
	@Override
	public String toString() {
		String risultato = new String();
		switch(this) {
		case Nord:
			risultato = "nord";
			break;
		case Sud:
			risultato = "sud";
			break;
		case Est:
			risultato = "est";
			break;
		case Ovest:
			risultato = "ovest";
			break;
		default:
			break;
		}
		return risultato;
	}
}
