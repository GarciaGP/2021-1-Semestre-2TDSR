package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.fiap.tds.entity.Combustivel;
import br.com.fiap.tds.entity.Veiculo;

public class CadastroTeste {

	public static void main(String[] args) {
		//Obter uma instância da fabrica e do entity manager
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um veiculo sem o código (Estado : novo, não gerenciado)
		Veiculo veiculo = new Veiculo("FIAT", "Prata", 
				new GregorianCalendar(2021, Calendar.APRIL, 1), 
				Combustivel.FLEX, false);
		
		//Cadastrar o veiculo
		//Passar o objeto veiculo para o entity manager gerenciar
		em.persist(veiculo);
		
		//Começar uma transação
		em.getTransaction().begin();
		//Finalizar a transação com commit
		em.getTransaction().commit();
		
//		veiculo.setCor("Branco");
//		
//		em.getTransaction().begin();
//		em.getTransaction().commit();
		
		System.out.println("Veiculo registrado!");
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
