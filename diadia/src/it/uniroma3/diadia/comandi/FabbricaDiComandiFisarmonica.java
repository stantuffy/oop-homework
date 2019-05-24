package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	public static final String[] ELENCO_COMANDI = {"vai", "prendi", "posa", "aiuto", "guarda", "fine"};
	
	@Override
	public Comando creaComando(String istruzione) {
		Scanner s = new Scanner(istruzione);
		String nomeComando = "";
		String parametro = "";
		Comando comando = new ComandoNonValido();
		
		if(s.hasNext())
			nomeComando = s.next();
		if(s.hasNext())
			parametro = s.next();
		
		s.close();
		
		if(nomeComando.equals("aiuto")) {
			comando = new ComandoAiuto();
		}
		else if(nomeComando.equals("fine")) {
			comando = new ComandoFine();
		}
		else if(nomeComando.equals("guarda")) {
			comando = new ComandoGuarda();
		}
		else if(nomeComando.equals("posa")) {
			comando = new ComandoPosa();
		}
		else if(nomeComando.equals("prendi")) {
			comando = new ComandoPrendi();
		}
		else if(nomeComando.equals("vai")) {
			comando = new ComandoVai();
		}
		
		comando.setParametro(parametro);
		return comando;
	}
}
