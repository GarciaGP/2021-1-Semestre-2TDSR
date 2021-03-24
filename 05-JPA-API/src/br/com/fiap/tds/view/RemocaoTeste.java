package br.com.fiap.tds.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Veiculo;

public class RemocaoTeste {

	public static void main(String[] args) {
		//Obter uma fabrica e um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Pequisar um veiculo
		Veiculo veiculo = em.find(Veiculo.class, 4);
		
		//Remover o veiculo
		em.remove(veiculo);
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println("Veiculo removido!");
		
		System.out.println(veiculo);
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
