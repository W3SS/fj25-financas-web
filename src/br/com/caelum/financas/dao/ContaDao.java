package br.com.caelum.financas.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
@Stateless
public class ContaDao {
	//@PersistenceContext
	@Inject//TROQUEI POR INJECT PORQUE AGORA O CDI JA ME MANDA UM MANAGER ABERTO, COLOCAMOS UM NIVEL ACIMA A CRIAÇÃO DELE
	EntityManager manager;

	public void adiciona(Conta conta) {
		this.manager.persist(conta);
	}

	public Conta busca(Integer id) {
		return this.manager.find(Conta.class, id);
	}

	public List<Conta> lista() {
		return this.manager.createQuery("select c from Conta c", Conta.class)
				.getResultList();
	}

	public void remove(Conta conta) {
		Conta contaParaRemover = this.manager.find(Conta.class, conta.getId());
		this.manager.remove(contaParaRemover);
	}
	
	public void altera(Conta conta){
		System.out.println("Alterando a conta");
		
		this.manager.merge(conta);
		
		System.out.println("Conta alterada [" + conta.toString());
	}
	
}




