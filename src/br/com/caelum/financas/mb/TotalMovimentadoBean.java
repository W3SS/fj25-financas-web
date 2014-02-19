package br.com.caelum.financas.mb;

import java.math.BigDecimal;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@Model
public class TotalMovimentadoBean {
	
	private BigDecimal total;
	private Conta conta = new Conta();
	private TipoMovimentacao tipoMovimentacao;
	
	//DEPENDENCIAS
	@Inject
	MovimentacaoDao movimentacaoDao;

	public void calcula() {
		total = movimentacaoDao.CalculaTotalMovimentado(getConta(),getTipoMovimentacao());
	}

	public BigDecimal getTotal() {
		return total;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

}
