package br.com.caelum.financas.mb;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.dto.ValorPorMesEAno;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@Model
public class MesesComMovimentacaoBean {

	private Conta conta = new Conta();
	private List<ValorPorMesEAno> valoresPorMesEAno;
	private TipoMovimentacao tipoMovimentacao;
	
	@Inject
	MovimentacaoDao movimentacaoDao;
	
	public void lista() {
		System.out.println("Listando as contas pelos valores movimentados no mes");
		valoresPorMesEAno = movimentacaoDao.listaMesesComMovimentacoes(conta, tipoMovimentacao); 
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Conta getConta() {
		return conta;
	}

	public List<ValorPorMesEAno> getvaloresPorMesEAno() {
		return valoresPorMesEAno;
	}

	public void setvaloresPorMesEAno(List<ValorPorMesEAno> valoresPorMesEAno) {
		this.valoresPorMesEAno = valoresPorMesEAno;
	}
	
	

}
