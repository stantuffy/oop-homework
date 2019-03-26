package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			System.out.println("Comando sconosciuto");
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}
	
	/**
	 * Comando "prendi". Il giocatore prende un attrezzo nella
	 * stanza  e lo mette in borsa.
	 * 
	 * @param nomeAttrezzo
	 */
	private void prendi(String nomeAttrezzo) {
		// Controllo se l'attrezzo esiste nella stanza
		if(! this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			System.out.println("Non puoi prendere l'oggetto " + nomeAttrezzo + ".");
			return;
		}
		
		// Controllo se il giocatore ha spazio nella borsa
		Attrezzo attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(! this.partita.getGiocatore().prendi(attrezzo)) {
			System.out.println("Non hai più spazio nella borsa.");
			return;
		}
		
		if(! this.partita.getStanzaCorrente().removeAttrezzo(attrezzo.getNome())) {
			System.out.println("Impossibile raccogliere l'oggetto");
			return;
		}
		
		// Rimuovo l'attrezzo dalla stanza
		System.out.println(nomeAttrezzo + " aggiunto alla borsa.");
	}
	
	/**
	 * Comando "posa". Un attrezzo viene rimosso dalla borsa del giocatore
	 * e viene posato nella stanza corrente.
	 * 
	 * @param nomeAttrezzo
	 */
	private void posa(String nomeAttrezzo) {
		// Controllo se tale attrezzo esiste nella borsa
		Attrezzo attrezzo = this.partita.getGiocatore().posa(nomeAttrezzo);
		if(attrezzo == null) {
			System.out.println("Non possiedi un oggetto con quel nome.");
			return;
		}
		
		// Controllo se nella stanza c'è spazio a sufficienza.
		if(! this.partita.getStanzaCorrente().addAttrezzo(attrezzo)) {
			System.out.println("Non c'è abbastanza spazio nella stanza.");
			
			// Ripristino l'attrezzo nella borsa del giocatore.
			this.partita.getGiocatore().prendi(attrezzo);
			return;
		}
		
		System.out.println("Hai lasciato cadere " + nomeAttrezzo);
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}