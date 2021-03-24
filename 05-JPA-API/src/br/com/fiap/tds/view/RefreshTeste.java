package br.com.fiap.tds.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Veiculo;

public class RefreshTeste {

	//Atualiza o objeto com os dados do banco
	public static void main(String[] args) {
		//Obter a fabrica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar um veiculo de código 1
		Veiculo veiculo = em.find(Veiculo.class, 1);
		
		//Exibir os dados do veículo
		System.out.println(veiculo);
		
		//Alterar a marca e cor no objeto
		veiculo.setMarca("Ford");
		veiculo.setCor("Amarelo");
		
		//Exibir os dados do veículo
		System.out.println(veiculo);
		
		//Realizar o refresh
		em.refresh(veiculo);
		
		//Exibir os dados do veículo
		System.out.println(veiculo);
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
