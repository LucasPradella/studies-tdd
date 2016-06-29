package br.com.estudies.boleto;

import java.util.List;

public class ProcessadorBoleto {
	
	public void processa(List<Boleto> boletos, Fatura fatura) {
		for (Boleto boleto : boletos) {
			Pagamento pagamento = new Pagamento(boleto.getValor(), MeioPagamento.BOLETO);
			
			fatura.adicionaPagamento(pagamento);
		}
	}

}
