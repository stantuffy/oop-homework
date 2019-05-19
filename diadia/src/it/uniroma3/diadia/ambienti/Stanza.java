package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	// static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	// static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
    private HashMap<String, Attrezzo> attrezzi;
    // private int numeroAttrezzi;
    private HashMap<DirezioneStanza, Stanza> stanzeAdiacenti;
    // private int numeroStanzeAdiacenti;
	// private String[] direzioni;
	// private Attrezzo attrezzoVuoto;
	
	/// Crea un attrezzo non valido ai fini del gioco.
	/// Tale oggetto serve unicamente per evitare che
	/// il container degli attrezzi contenga elementi con valore null.
	/*
	private Attrezzo creaAttrezzoVuoto() {
		return new Attrezzo("", 0);
	}
	*/
	
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        // this.numeroStanzeAdiacenti = 0;
        // this.numeroAttrezzi = 0;
        // this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new HashMap<String, Attrezzo>();
        
        /**
        this.attrezzoVuoto = this.creaAttrezzoVuoto();
        
        for(int i=0; i<NUMERO_MASSIMO_ATTREZZI; i++)
        	this.attrezzi[i] = this.attrezzoVuoto;
        **/
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public Stanza impostaStanzaAdiacente(DirezioneStanza direzione, Stanza stanza) {
    	return this.stanzeAdiacenti.put(direzione, stanza);
    	
    	/*
        boolean aggiornato = false;
    	for(int i=0; i<this.direzioni.length; i++)
        	if (direzione.equals(this.direzioni[i])) {
        		this.stanzeAdiacenti[i] = stanza;
        		aggiornato = true;
        	}
    	
    	if (!aggiornato)
    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
    			this.direzioni[numeroStanzeAdiacenti] = direzione;
    			this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
    		    this.numeroStanzeAdiacenti++;
    		}
    	*/
    }
    
    public Stanza impostaStanzaAdiacente(String direzione, Stanza stanza) {
    	return this.impostaStanzaAdiacente(DirezioneStanza.fromString(direzione), stanza);
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(DirezioneStanza direzione) {
		return this.stanzeAdiacenti.get(direzione);
		
		/*
        Stanza stanza = null;
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
        	if (this.direzioni[i].equals(direzione))
        		stanza = this.stanzeAdiacenti[i];
        return stanza;
		*/
	}
	
	public Stanza getStanzaAdiacente(String direzione) {
		return this.getStanzaAdiacente(DirezioneStanza.fromString(direzione));
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public HashMap<String, Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	return this.attrezzi.put(attrezzo.getNome(), attrezzo) == null;
    }
    
    /**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
    public boolean removeAttrezzo(String nomeAttrezzo) {
    	return this.attrezzi.remove(nomeAttrezzo) == null;
    	
    	/**
    	boolean rimosso = false;
    	
    	if(nomeAttrezzo == null)
    		return rimosso;
    	
    	int i;
    	for(i=0; i<this.numeroAttrezzi; i++) {
    		if(this.attrezzi[i] != null && this.attrezzi[i].getNome().contentEquals(nomeAttrezzo)) {
    			rimosso = true;
    			this.attrezzi[i] = null;
    			break;
    		}
    	}
    	
    	if(rimosso) {
    		i++;
    		for(; i<this.numeroAttrezzi; i++)
    			this.attrezzi[i-1] = this.attrezzi[i];
    		this.numeroAttrezzi --;
    	}
    	return rimosso;
    	*/
    }

   

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
		
		/*
		boolean trovato = false;
		
		for (Attrezzo attrezzo : this.attrezzi.values())
			if (attrezzo.getNome().equals(nomeAttrezzo))
				trovato = true;
			
		return trovato;
		*/
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
		
		/**
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo))
				attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;	
		*/
	}
	
	/**
	 * @return Ritorna il numero di attrezzi presenti nella stanza.
	 */
	public int getNumAttrezzi() {
		return this.getAttrezzi().size();
	}


	public Set<DirezioneStanza> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
		
		/*
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
	    for(int i=0; i<this.numeroStanzeAdiacenti; i++)
	    	direzioni[i] = this.direzioni[i];
	    return direzioni;
    	*/
    }
	
	@Override
    public int hashCode() {
    	return this.nome.hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
    	if(o == null)
    		return false;
    	
    	Stanza that = (Stanza)o;
    	return this.getNome().equals(that.getNome());
    }
	
	/**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	
    	Iterator<DirezioneStanza> direzioneIt = this.getDirezioni().iterator();
    	while(direzioneIt.hasNext())
    		risultato.append(" " + direzioneIt.next().toString());
    	
    	risultato.append("\nAttrezzi nella stanza: ");
    	Iterator<Attrezzo> it = this.attrezzi.values().iterator();
    	while(it.hasNext()) {
    		risultato.append(it.next().toString() + " ");
    	}
    	return risultato.toString();
    }
}