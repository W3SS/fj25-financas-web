package br.com.caelum.financas.mb;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.Cache;

import br.com.caelum.financas.modelo.Conta;

@Model
public class CacheInvalidaBean {
	
	private Integer id;
	private Conta conta;
	
	@Inject
	Cache cache;

	public void invalidar() {
		System.out.println("Invalidando o cache programaticamente");
		cache.evict(Conta.class, id);
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
