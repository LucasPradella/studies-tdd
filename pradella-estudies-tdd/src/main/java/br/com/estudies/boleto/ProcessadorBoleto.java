package br.com.estudies.boleto;

import java.util.List;

public class ProcessadorBoleto {

	
	public void processa(List<Boleto> boletos, Fatura fatura) {
		double valorTotal = 0;
		
		for (Boleto boleto : boletos) {
			Pagamento pagamento = new Pagamento(boleto.getValor(), MeioPagamento.BOLETO);
			fatura.getPagamentos().add(pagamento);
	
			valorTotal += boleto.getValor();
			}
		
		if (valorTotal >= fatura.getValor()) {
			fatura.setPago(true);
		}
	}

}
