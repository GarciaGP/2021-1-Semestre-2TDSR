package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Combustivel;
import br.com.fiap.tds.entity.Veiculo;

public class AtualizacaoTeste {

	public static void main(String[] args) {
		//Obter uma fabrica e um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um objeto veiculo com um código (Estado : detached)
		Veiculo veiculo = new Veiculo(1, "Hyundai", "Preto", 
				new GregorianCalendar(2021, Calendar.MAY, 9), 
				Combustivel.ELETRICO, true);
		
		//Atualizar 
		//Merge retorna o objeto gerenciado pelo Entity manager (cópia)
		Veiculo veiculoGerenciado = em.merge(veiculo);
		
		//veiculoGerenciado.setNovo(false);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
