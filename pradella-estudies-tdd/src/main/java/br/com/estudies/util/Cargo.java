package br.com.estudies.util;

import br.com.estudies.tdd.calculadora.DezOuVintePorCento;
import br.com.estudies.tdd.calculadora.QuinzeOuVinteECincoPorCento;
import br.com.estudies.tdd.calculadora.RegraDeCalculo;

public enum Cargo {
	DESENVOLVEDOR (new DezOuVintePorCento()),
	DBA (new QuinzeOuVinteECincoPorCento()),
	TESTADOR (new QuinzeOuVinteECincoPorCento()) ;
	
	
	
	private final RegraDeCalculo regra;

	Cargo(RegraDeCalculo regra) {
		this.regra = regra;
	}

	public RegraDeCalculo getRegra() {
		return regra;
	}
}
