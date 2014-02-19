package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;

@ManagedBean
@ViewScoped
public class ContasBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

	private Conta conta = new Conta();
	private List<Conta> contas;
	
	//DEPENDENCIAS
	@Inject
	ContaDao contaDao;

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void grava() {
		System.out.println("Gravando/Anterando a conta");
		
		if(this.getConta().getId()==null){
			contaDao.adiciona(this.getConta());
		}else{
			contaDao.altera(this.getConta());
		}
				
		this.contas = this.contaDao.lista();
		limpaFormularioDoJSF();
	}

	public List<Conta> getContas() {
		System.out.println("Listando as contas");
		
		if(this.contas == null){
			this.contas = this.contaDao.lista();
		}

		return contas;
	}

	public void remove() {
		System.out.println("Removendo a conta");
		
		if(this.contaDao.busca(this.getConta().getId())!=null){
			this.contaDao.remove(this.getConta());
			System.out.println("Conta removida" + this.getConta().toString());
		}
		
		limpaFormularioDoJSF();
	}

	/**
	 * Esse metodo apenas limpa o formulario da forma com que o JSF espera.
	 * Invoque-o no momento em que precisar do formulario vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.conta = new Conta();
	}
}
