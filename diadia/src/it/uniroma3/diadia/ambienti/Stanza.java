package it.uniroma3.diadia.ambienti;

import java.util.HashMap;

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
	private String nome;
    protected HashMap<String,Attrezzo> attrezzi;
    protected HashMap<Direzione,Stanza> stanzeAdiacenti;
	
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.attrezzi = new HashMap<String, Attrezzo>();
        this.stanzeAdiacenti = new HashMap<Direzione,Stanza>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
        this.stanzeAdiacenti.put(direzione, stanza);
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(Direzione direzione) {
        return this.stanzeAdiacenti.get(direzione);
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public HashMap<String,Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        this.attrezzi.put(attrezzo.getNome(), attrezzo);
        return true;
    }
    
    /**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
    public boolean removeAttrezzo(String nomeAttrezzo) {
    	if (this.attrezzi.remove(nomeAttrezzo) != null)
    		return true;
    	return false;
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
    	
    	for (Direzione d : this.stanzeAdiacenti.keySet()) {
    		risultato.append(d.toString() + " ");
    	}
    	
    	risultato.append("\nAttrezzi: ");
    	
    	for (Attrezzo a : this.attrezzi.values()) {
    		risultato.append(a.toString());
    	}
    	
    	return risultato.toString();
    }
    
    public String getDescrizione() {
    	return this.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		if (this.attrezzi.get(nomeAttrezzo) == null)
			return false;
		return true;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);	
	}
	
	public int getNumAttrezzi() {
		return this.attrezzi.size();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		Stanza other = (Stanza)o;
		return this.nome.equals(other.nome);
	}
	
	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}
}