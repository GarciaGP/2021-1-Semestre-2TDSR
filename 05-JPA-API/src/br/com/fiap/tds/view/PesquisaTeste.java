package br.com.fiap.tds.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.fiap.tds.entity.Veiculo;

public class PesquisaTeste {

	public static void main(String[] args) {
		//Obter a fabrica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		//Pesquisar um veiculo pela PK (codigo)
		//Retorna um objeto gerenciado ou null
		Veiculo veiculo = em.find(Veiculo.class, 1);
		
		//Exibir os dados do veículo
		System.out.println(veiculo);
		
		veiculo.setCor("Branco");
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
