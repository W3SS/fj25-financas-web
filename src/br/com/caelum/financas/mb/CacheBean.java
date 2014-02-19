package br.com.caelum.financas.mb;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

@Model
public class CacheBean {
	
	@Inject
	EntityManager manager;
	
	private Integer id;
	private Conta conta;
	
	public void pesquisar() {
			System.out.println("Testando cache de primeiro nivel");
			this.conta = this.manager.find(Conta.class, id);
			this.conta = this.manager.find(Conta.class, id);
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Conta getConta() {
		return conta;
	}
}