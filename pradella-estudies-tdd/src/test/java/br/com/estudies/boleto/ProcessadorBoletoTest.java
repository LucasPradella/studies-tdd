package br.com.estudies.boleto;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class ProcessadorBoletoTest {

	@InjectMocks
	 private ProcessadorBoleto processador;
	
	@Before
	public void setUp() throws Exception {
		initMocks(this);
	}
	
	
	

		
	@Test
	public void deveProcessarBoletoViaPagamentoUnico() {
		Fatura fatura = new Fatura("Cliente", 150.0);
		
		Boleto b1 = new Boleto(150.0);
				
		List<Boleto> boletos = Arrays.asList(b1);
		
		processador.processa(boletos, fatura);
		
		
		assertEquals(1, fatura.getPagamentos().size());
		assertEquals(150.0, fatura.getPagamentos().get(0).getValor(), 0.00001);
			
	}
	
	
	@Test
	public void deveProcessarPagamentoViaBoletosMultiplos(){
		Fatura fatura = new Fatura("Cliente", 300.0);
		
		Boleto b1 = new Boleto(150.0);
		Boleto b2 = new Boleto(150.0);
		List<Boleto> boletos = Arrays.asList(b1, b2);
		
		processador.processa(boletos, fatura);
		
		assertEquals(2, fatura.getPagamentos().size());
		assertEquals(150.0, fatura.getPagamentos().get(0).getValor(), 0.00001);
		assertEquals(150.0, fatura.getPagamentos().get(1).getValor(), 0.00001);		
	}

}
