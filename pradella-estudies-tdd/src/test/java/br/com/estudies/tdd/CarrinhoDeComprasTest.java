package br.com.estudies.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.estudies.domain.Item;

public class CarrinhoDeComprasTest {

	
	private CarrinhoDeCompras carrinho;

	
	@Before
	public void setUp() throws Exception {
		this.carrinho = new CarrinhoDeCompras();
	}
	
		

	@Test
	public void deveRetornar0SeOCarrinhoTiverVazio() {
		assertEquals(0.0, carrinho.maiorValor(), 0.0001);
	}
	
	
	@Test
	public void deveRetornarValorDoItemCaso1ItemAdicionado() {
		carrinho.adiciona(new Item("Geladeira", 1, 900.0));
			
		assertEquals(900.0, carrinho.maiorValor(), 0.0001);
	}
	
	
	@Test
	public void deveRetornarValorDoMaiorItemQuandoAdicionadoVarios() {
		carrinho.adiciona(new Item("Geladeira", 1, 900.0));
		carrinho.adiciona(new Item("Tv Led", 1, 1900.0));
		carrinho.adiciona(new Item("Fogao", 1, 500.0));
		
		
		assertEquals(1900.0, carrinho.maiorValor(), 0.0001);
	}

}
