package br.com.estudies.tdd.calculadora;

import br.com.estudies.domain.Funcionario;

public class CalculadoraDeSalario {

	public double calculaSalario(Funcionario funcionario) {
		return funcionario.getCargo().getRegra().calcula(funcionario);
	}

}
