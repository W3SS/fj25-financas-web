package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.caelum.financas.dao.CategoriaDao;
import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@ManagedBean
@ViewScoped
public class MovimentacoesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Movimentacao> movimentacoes;
	private Movimentacao movimentacao = new Movimentacao();
	private Integer contaId;
	private Integer categoriaId;
	private List<Categoria> categorias;
	
	//DEPENDENCIAS
	@Inject
	MovimentacaoDao movimentacaoDao;
	@Inject
	ContaDao contaDao;
	@Inject
	CategoriaDao categoriaDao;
	
	public void grava() {
		System.out.println("Fazendo a gravacao da movimentacao");
		this.movimentacao.setConta(this.contaDao.busca(this.getContaId()));
		this.movimentacao.getCategorias().add(this.categoriaDao.procura(this.getCategoriaId()));
		this.movimentacaoDao.adiciona(this.movimentacao);
		this.movimentacoes = movimentacaoDao.lista();
		
		limpaFormularioDoJSF();
	}
	

	public void remove() {
		System.out.println("Removendo a movimentacao");
		
		this.movimentacaoDao.remove(this.getMovimentacao());
		
		limpaFormularioDoJSF();
	}

	public List<Movimentacao> getMovimentacoes() {
		if(this.movimentacoes==null){
			this.movimentacoes = this.movimentacaoDao.lista();
		}
		
		return movimentacoes;
	}
	
	public Movimentacao getMovimentacao() {
		if(movimentacao.getData()==null) {
			movimentacao.setData(Calendar.getInstance());
		}
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public Integer getContaId() {
		return contaId;
	}

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}
	

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	public List<Categoria> getCategorias(){
		if(this.categorias == null){
			System.out.println("Listando as categorias");
			this.categorias = this.categoriaDao.lista();
		}
		
		return this.categorias;
	}

	/**
	 * Esse metodo apenas limpa o formulario da forma com que o JSF espera.
	 * Invoque-o no momento manager que precisar do formulario vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.movimentacao = new Movimentacao();
	}

	public TipoMovimentacao[] getTiposDeMovimentacao() {
		return TipoMovimentacao.values();
	}
	
	public void Adicionacategoria(){
		if(this.categoriaId != null && this.categoriaId > 0){
			Categoria categoria = categoriaDao.procura(categoriaId);
			this.movimentacao.getCategorias().add(categoria);
		}
	}
	
}
