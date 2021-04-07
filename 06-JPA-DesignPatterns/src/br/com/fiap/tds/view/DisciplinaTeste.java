package br.com.fiap.tds.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Disciplina;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class DisciplinaTeste {

	public static void main(String[] args) {
		
		//Obter o Entity Manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Obter uma instância do Generic Dao para a Disciplina 
		GenericDao<Disciplina, Integer> dao = 
								new GenericDaoImpl<Disciplina, Integer>(em){};
				
		//Cadastrar e pesquisar
		Disciplina disciplina = new Disciplina("Mobile", "Android e IOS", null);
		
		try {
			dao.create(disciplina);
			dao.commit();
			System.out.println("Disciplina cadastrada!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			disciplina = dao.read(1);
			System.out.println(disciplina.getNome() + " " + disciplina.getEmenta());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
