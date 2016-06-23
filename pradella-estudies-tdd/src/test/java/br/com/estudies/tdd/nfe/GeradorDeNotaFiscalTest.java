package br.com.estudies.tdd.nfe;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GeradorDeNotaFiscalTest {

	
	GeradorDeNotaFiscal gerador;
	NFDao dao;
	SAP sap;
	
	@Before
	public void setUp() throws Exception {
		// criando um mock
		this.dao = Mockito.mock(NFDao.class);
		this.sap = Mockito.mock(SAP.class);
		this.gerador = new GeradorDeNotaFiscal(dao, sap);
	}

	
	
	
	@Test
	public void deveGerarNFEComValorDeImpostoDescontado() {
		Pedido pedido = new Pedido("Jow Snow", 1000, 1);
		NotaFiscal nf = gerador.gera(pedido);
		
		assertEquals(1000 * 0.94, nf.getValor(), 0.00001);
	}
	
	@Test
	public void devePersistirNFGerada() {
			
		Pedido pedido = new Pedido("Arya Stark", 1000, 1);
		NotaFiscal nf = gerador.gera(pedido);

		// Usando o Verify para verificar a chamada do metodo
		verify(dao).persiste(nf);
	
	}

	
	
	@Test
	public void deveEnviarNFGerada() {
			
		Pedido pedido = new Pedido("Tony Stark", 1000, 1);
		NotaFiscal nf = gerador.gera(pedido);

		
		verify(sap).envia(nf);
	
	}

}
