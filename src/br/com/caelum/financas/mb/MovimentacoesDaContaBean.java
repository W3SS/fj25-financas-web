package br.com.caelum.financas.mb;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

@Model
public class MovimentacoesDaContaBean {

	private List<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();
	private Conta conta = new Conta();
	
	@Inject
	MovimentacaoDao movimentacaoDao;
	
	public void lista() {
		movimentacoes = this.movimentacaoDao.listaTodasMovimentacoes(this.getConta());
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
