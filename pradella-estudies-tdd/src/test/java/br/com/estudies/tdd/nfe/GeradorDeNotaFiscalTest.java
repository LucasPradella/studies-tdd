package br.com.estudies.tdd.nfe;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GeradorDeNotaFiscalTest {

	
	
	@Before
	public void setUp() throws Exception {

	}

	
	  @Test
		public void devemInvocarAcoesPosteriores() {
		AcaoPosGerarNota acoes1 = mock(AcaoPosGerarNota.class);
		AcaoPosGerarNota acoes2 = mock(AcaoPosGerarNota.class);

		List<AcaoPosGerarNota> acoes = Arrays.asList(acoes1, acoes2);

		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes);

		Pedido pedido = new Pedido("Arya Stark", 1000, 1);
		NotaFiscal nf = gerador.gera(pedido);

		verify(acoes1).executaAcao(nf);
		verify(acoes2).executaAcao(nf);
	}
		
	
	
	  @Test
	public void deveGerarNFEComValorDeImpostoDescontado() {
		AcaoPosGerarNota naoTemAcoes = mock(AcaoPosGerarNota.class);
		 List<AcaoPosGerarNota> acoes = Arrays.asList(naoTemAcoes);
		
		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes);

		
		
		Pedido pedido = new Pedido("Jow Snow", 1000, 1);
		NotaFiscal nf = gerador.gera(pedido);

		assertEquals(1000 * 0.2, nf.getValor(), 0.00001);
	}
	  

	  
		@Test
		public void deveExecutarUmaAcao() {
			AcaoPosGerarNota acao = mock(AcaoPosGerarNota.class);
			
			List<AcaoPosGerarNota> acoes = Arrays.asList(acao);
			
			GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes);
			
			Pedido pedido = new Pedido("Arya Stark", 1000, 1);
			NotaFiscal nf = gerador.gera(pedido);

			// Usando o Verify para verificar a chamada do metodo
			verify(acao).executaAcao(nf);
		
		}
		

		@Test
		public void deveLerATabelaParaCalcularOImposto() {
		
			//Mock Tabela
			Tabela tabela = mock(Tabela.class);
			
			//Mock Relogio para usar esse contrutor
			Relogio relogio = mock(Relogio.class);
			
			//Criando tabela e metodo, pos teste
			when(tabela.paraValor(1000)).thenReturn(0.2);
			
			
			//mesmos condigos repetidos, poderiamos isolar,  ou usar Anotacoes
			AcaoPosGerarNota acao = mock(AcaoPosGerarNota.class);
			List<AcaoPosGerarNota> acoes = Arrays.asList(acao);
			
	
			
			GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes, relogio, tabela);
			Pedido pedido = new Pedido("Mae dos Dragoes", 1000, 1);
			
			
			NotaFiscal nf = gerador.gera(pedido);
			
			verify(tabela).paraValor(1000.0);
			assertEquals(1000.0 * 0.2, nf.getValor(), 0.00001);

			
		}
		

		
		
}
