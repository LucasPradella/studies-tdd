package br.com.estudies.calculadora;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.estudies.domain.Funcionario;
import br.com.estudies.tdd.calculadora.CalculadoraDeSalario;
import br.com.estudies.util.Cargo;


public class CalculadoraDeSalarioTest {

	CalculadoraDeSalario calculadora;
	
	@Before
	public void setUp() throws Exception {
	     this.calculadora =  new CalculadoraDeSalario();
	}

	
	
	
	
	@Test
	public void deveCalcularSalarioDosDesenvolvedoresQueResebemMenosQue1500() {
		Funcionario desenvolvedor = new Funcionario("Mauricio", 1500.0, Cargo.DESENVOLVEDOR);
		double salario = calculadora.calculaSalario(desenvolvedor);

		assertEquals(1500.0 * 0.9, salario, 0.00001);
	}

	

	@Test
	public void deveCalcularSalarioDosDesenvolvedoresQueResebemMaisQue3000() {
		Funcionario desenvolvedor = new Funcionario("Snow", 3000.0, Cargo.DESENVOLVEDOR);
		double salario = calculadora.calculaSalario(desenvolvedor);

		assertEquals(3000.0 * 0.8, salario, 0.00001);
	}


	
	@Test
	public void deveCalcularSalarioDoDBAComSalarioAbaixoDoLimite() {
		Funcionario dba = new Funcionario("Jose", 1500.0, Cargo.DBA);
		double salario = calculadora.calculaSalario(dba);

		assertEquals(1500.0 * 0.95, salario, 0.00001);
	}

	
	@Test
	public void deveCalcularSalarioDoDBAComSalarioAcimaDoLimite() {
		Funcionario dba = new Funcionario("Stark", 3000.0, Cargo.DBA);
		double salario = calculadora.calculaSalario(dba);

		assertEquals(3000.0 * 0.85, salario, 0.00001);
	}

}
