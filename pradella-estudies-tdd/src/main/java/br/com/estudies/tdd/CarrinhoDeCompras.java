package br.com.estudies.tdd;

import java.util.Collections;
import java.util.List;

import br.com.estudies.domain.Item;

public class CarrinhoDeCompras {
	
	private List<Item> itens;

	public CarrinhoDeCompras(List<Item> itens) {
		this.itens = itens;
	}
	

	public List<Item> getitens(){
		return Collections.unmodifiableList(itens);
	}
	
	
	
	

}
