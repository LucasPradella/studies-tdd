package br.com.estudies.tdd;
import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;

public class ConversorNumerosRomanosTest {

	
	
	
	@Before
	public void setUp() throws Exception {
		initMocks(this);
	}
	
	
	ConversorDeNumeroRomano  romano = new ConversorDeNumeroRomano();

	@Test
	public void deveEntenderONumeroI() {
		int numero = romano.converter("I");
		assertEquals(1, numero);
		
	}

	
	@Test
	public void deveEntenderONumeroV() {
		int numero = romano.converter("V");
		assertEquals(5, numero);
		
	}
	
	
	@Test
	public void deveEntenderDoisNumeroRomanosII(){
		int numero = romano.converter("II");
		assertEquals(2, numero);
		
	}
	
	@Test
	public void deveEntenderDoisNumeroRomanosXXEMaisDoisII(){
		int numero = romano.converter("XXII");
		assertEquals(22, numero);
		
	}
	
	
	@Test
	public void deveEntenderNumeroMenorAntes(){
		int numero = romano.converter("IX");
		assertEquals(9, numero);
		
	}
	

}
