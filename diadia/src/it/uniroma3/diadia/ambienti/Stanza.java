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
	
	private String nome;
    private HashMap<String, Attrezzo> attrezzi;
    private HashMap<DirezioneStanza, Stanza> stanzeAdiacenti;
	
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new HashMap<String, Attrezzo>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public Stanza impostaStanzaAdiacente(DirezioneStanza direzione, Stanza stanza) {
    	return this.stanzeAdiacenti.put(direzione, stanza);
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
    	return this.attrezzi.remove(nomeAttrezzo) != null;
    }

   
    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
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
	
	/**
	 * @return Ritorna il numero di attrezzi presenti nella stanza.
	 */
	public int getNumAttrezzi() {
		return this.getAttrezzi().size();
	}


	public Set<DirezioneStanza> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
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
    	
    	for(DirezioneStanza direzione: this.getDirezioni())
    		risultato.append(" " + direzione.toString());
    	
    	risultato.append("\nAttrezzi nella stanza: ");
    	for(Attrezzo attrezzo: this.attrezzi.values())
    		risultato.append(attrezzo.toString() + " ");
    		
    	return risultato.toString();
    }
}