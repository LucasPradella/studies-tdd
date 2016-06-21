package br.com.estudies.tdd;

import br.com.estudies.domain.Funcionario;

public class CalculadoraDeSalario {

	public double calculaSalario(Funcionario funcionario) {
		return funcionario.getSalario() * 0.9;
	}

	
	
}
