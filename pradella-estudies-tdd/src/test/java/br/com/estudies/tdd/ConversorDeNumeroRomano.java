package br.com.estudies.tdd;

import java.util.HashMap;
import java.util.Map;

public class ConversorDeNumeroRomano {

	public int converter(String numeroRomano) {
		int acumulador = 0;
		for (int i = 0; i < numeroRomano.length(); i++) {
			acumulador += tabela.get(numeroRomano.charAt(i) + "");
		}
		return acumulador;
	}
	
	
	@SuppressWarnings("serial")
	private static Map<String, Integer> tabela =
			new HashMap<String, Integer>() {{
			put("I", 1);
			put("V", 5);
			put("X", 10);
			put("L", 50);
			put("C", 100);
			put("D", 500);
			put("M", 1000);
			}};
		
	

}
