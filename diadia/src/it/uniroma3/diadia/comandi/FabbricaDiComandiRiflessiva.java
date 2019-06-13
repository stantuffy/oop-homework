package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {

	@Override
	public Comando creaComando(String istruzione) {
		if(istruzione == null)
			return new ComandoNonValido();
		
		Scanner scanner = new Scanner(istruzione);
		String nomeComando = "";
		String parametro = "";
		
		if(scanner.hasNext())
			nomeComando = scanner.next();
		if(scanner.hasNext())
			parametro = scanner.next();
		scanner.close();
		
		if(nomeComando.length() < 1)
			return new ComandoNonValido();
		
		Comando comando;
		StringBuilder sb = new StringBuilder("");
		sb.append(nomeComando.toUpperCase().charAt(0));
		sb.append(nomeComando.substring(1));
		nomeComando = sb.toString();
		
		try {
			comando = 
					(Comando)Class.forName("it.uniroma3.diadia.comandi.Comando" + nomeComando)
					.newInstance();
		} catch(Exception e) {
			
			comando = new ComandoNonValido();
		}
		
		comando.setParametro(parametro);
		return comando;
	}

}
