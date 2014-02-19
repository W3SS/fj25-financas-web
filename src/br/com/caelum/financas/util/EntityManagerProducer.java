package br.com.caelum.financas.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
@ApplicationScoped//TERA'APENAS UMA INSTANCIA DESTA CLASSE - SINGLETON
public class EntityManagerProducer {
	@PersistenceUnit//SOLICITANDO AO CDI QUE INJETE UM MANAGER PARA MIN
	EntityManagerFactory factory;
	
	@Produces		//ENSINANDO AO CDI COMO ME DAR UMA INSTANCIA DE MANAGER
	@RequestScoped
	public EntityManager getEntityManager() throws Exception{
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
	
	public void close(@Disposes EntityManager manager){//AVISANDO QUE AQUI SE FECHA A TRANSACAO/MANAGER
		manager.close();
	}
	
	@Produces
	@ApplicationScoped
	public Cache getCache(){
		return factory.getCache();
	}

}
