package br.com.estudies.boleto;

public class Pagamento {

	private MeioPagamento meioPagamento;
	private double valor;

	
	
	
	
	public Pagamento(double valor, MeioPagamento meioPagamento) {
		this.valor = valor;
		this.meioPagamento = meioPagamento;
	}

	
	
	
	public MeioPagamento getMeioPagamento() {
		return meioPagamento;
	}

	public void setMeioPagamento(MeioPagamento meioPagamento) {
		this.meioPagamento = meioPagamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
