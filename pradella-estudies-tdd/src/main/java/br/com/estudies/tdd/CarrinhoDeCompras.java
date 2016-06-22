package br.com.estudies.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.estudies.domain.Item;

public class CarrinhoDeCompras {
	
	private List<Item> itens;

	
	public CarrinhoDeCompras() {
		this.itens = new ArrayList<Item>();
	}
	

	public List<Item> getitens(){
		return Collections.unmodifiableList(itens);
	}


	public void adiciona(Item item) {
		this.itens.add(item);
	}
	
	
	
	
	
	public double maiorValor() {
		if (itens.size() == 0) return 0.0;
		
		double maior =  itens.get(0).getValorUnitario();
		
		for (Item item : itens) {
			if (maior < item.getValorUnitario()) {
				maior = item.getValorUnitario() ; 
			}
		}
		
		return maior ;
	}
	
	
	
	

}
