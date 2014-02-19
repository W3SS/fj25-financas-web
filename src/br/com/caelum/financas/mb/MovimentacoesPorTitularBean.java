package br.com.caelum.financas.mb;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Movimentacao;

@Model
public class MovimentacoesPorTitularBean {

	private List<Movimentacao> movimentacoes;
	private String titular;
	
	//DEPENDENCIAS
	@Inject
	MovimentacaoDao movimentacaoDao;

	public void lista() {
		System.out.println("Buscando as movimentacoes pelo titular da conta " + this.titular);
		movimentacoes = movimentacaoDao.buscaTodasMovimentacoesDaConta(getTitular());
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

}
