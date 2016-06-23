package br.com.estudies.tdd.calculadora;

import br.com.estudies.domain.Funcionario;

public class DezOuVintePorCento implements RegraDeCalculo{

	
	public double calcula(Funcionario funcionario) {
		if (funcionario.getSalario() >=  3000) {
			return funcionario.getSalario() * 0.8;
		}

		return funcionario.getSalario() * 0.9;

	}

}
