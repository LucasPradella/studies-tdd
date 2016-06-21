package br.com.estudies.tdd;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;

import br.com.estudies.domain.Funcionario;
import br.com.estudies.util.Cargo;


public class CalculadoraDeSalarioTest {


	
	@Before
	public void setUp() throws Exception {
		initMocks(this);
	}

	
	CalculadoraDeSalario calculadoraDeSalario =  new CalculadoraDeSalario();
	
	
	@Test
	public void deveCalcularSalarioDosDesenvolvedoresQueResebemMenosQue1500() {
		Funcionario desenvolvedor = new Funcionario("Mauricio", 1500.0, Cargo.DESENVOLVEDOR);
		double salario = calculadoraDeSalario.calculaSalario(desenvolvedor);

		assertEquals(1500.0 * 0.9, salario, 0.00001);
	}

}
