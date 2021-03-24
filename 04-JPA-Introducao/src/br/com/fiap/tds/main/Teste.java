package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		
		// Gerenciador de Entidades - EntityManager
		
		//Obter uma instância da fabrica de Entity Manager
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		
		//Obter uma instância do EntityManager
		EntityManager em = fabrica.createEntityManager();
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}