package br.com.caelum.financas.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Categoria;

public class CategoriaDao {
	//DEPENDENCIA
	//@PersistenceContext
	@Inject//TROQUEI POR INJECT PORQUE AGORA O CDI JA ME MANDA UM MANAGER ABERTO, COLOCAMOS UM NIVEL ACIMA A CRIAÇÃO DELE
	EntityManager manager;
	
	public Categoria procura(Integer id){
		return this.manager.find(Categoria.class, id);
	}
	
	public List<Categoria> lista(){
		String jpql = "select c from Categoria c";
		TypedQuery<Categoria> query = this.manager.createQuery(jpql, Categoria.class);
		
		return query.getResultList();
	}
	
}
