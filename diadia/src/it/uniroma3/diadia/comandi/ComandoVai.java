package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private Direzione direzione;
	
	@Override
	public void setParametro(String parametro) {
		if (parametro == null)
			return;
		
		if (parametro.equals("nord"))
			this.direzione = Direzione.Nord;
		else if (parametro.equals("sud"))
			this.direzione = Direzione.Sud;
		else if (parametro.equals("est"))
			this.direzione = Direzione.Est;
		else if (parametro.equals("ovest"))
			this.direzione = Direzione.Ovest;
		else
			this.direzione = Direzione.Nessuna;
	}
	
	@Override
	public void esegui(Partita partita) {
		if(this.direzione == Direzione.Nessuna)
			System.out.println("Dove vuoi andare?");
		Stanza prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(this.direzione);
		if(prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			System.out.println(prossimaStanza.getDescrizione());
			partita.setStanzaCorrente(prossimaStanza);
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(cfu - 1);
		}
	}
	
	@Override
	public String getNome() {
		return "vai";
	}
	
	@Override
	public String getParametro() {
		return this.direzione.toString();
	}
}
