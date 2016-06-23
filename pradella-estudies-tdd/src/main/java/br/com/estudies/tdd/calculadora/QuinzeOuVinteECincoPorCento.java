package br.com.estudies.tdd.calculadora;

import br.com.estudies.domain.Funcionario;

public class QuinzeOuVinteECincoPorCento implements RegraDeCalculo{

	
	public double calcula(Funcionario funcionario) {
		if (funcionario.getSalario() >= 3000) {
			return funcionario.getSalario() * 0.85;
		}
		return funcionario.getSalario() * 0.95;
		
	}

}
