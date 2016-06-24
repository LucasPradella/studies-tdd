package br.com.estudies.tdd.nfe;

import java.util.List;

public class GeradorDeNotaFiscal {

	private final List<AcaoPosGerarNota> acoes;
	private final Relogio relogio;
	private final Tabela tabela;

	
	//um contrutor com relogio e tabela
	public GeradorDeNotaFiscal(List<AcaoPosGerarNota> acoes, Relogio relogio, Tabela tabela) {
		this.acoes = acoes;
		this.relogio = relogio;
		this.tabela = tabela;
		
	}
	
	// outro contrutor sem relogio, para não influenciar nas outras funcionalidades do sistema
	public GeradorDeNotaFiscal(List<AcaoPosGerarNota> acoes) {
		this(acoes, new RelogioDoSistema(), new TabelaDoGoverno());
	}
	
	
	

	public NotaFiscal gera(Pedido pedido) {
		NotaFiscal nf = new NotaFiscal(pedido.getCliente(),
				pedido.getValorTotal() * tabela.paraValor(pedido.getValorTotal()),
				relogio.hoje());

		for (AcaoPosGerarNota acaoPosGerarNota : acoes) {
			acaoPosGerarNota.executaAcao(nf);
		}

		return nf;
	}
	
}
