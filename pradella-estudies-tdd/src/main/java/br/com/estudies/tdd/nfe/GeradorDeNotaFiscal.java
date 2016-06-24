package br.com.estudies.tdd.nfe;

import java.util.List;

public class GeradorDeNotaFiscal {

	private final List<AcaoPosGerarNota> acoes;
	private final Relogio relogio;

	
	//um contrutor com relogio
	public GeradorDeNotaFiscal(List<AcaoPosGerarNota> acoes, Relogio relogio) {
		this.acoes = acoes;
		this.relogio = relogio;
	}
	
	// outro contrutor sem relogio, para não influenciar nas outras funcionalidades do sistema
	public GeradorDeNotaFiscal(List<AcaoPosGerarNota> acoes) {
		this(acoes, new RelogioDoSistema());
	}
	
	
	

	public NotaFiscal gera(Pedido pedido) {
		NotaFiscal nf = new NotaFiscal(pedido.getCliente(), pedido.getValorTotal() * 0.94, relogio.hoje());

		for (AcaoPosGerarNota acaoPosGerarNota : acoes) {
			acaoPosGerarNota.executaAcao(nf);
		}

		return nf;
	}
	
}
