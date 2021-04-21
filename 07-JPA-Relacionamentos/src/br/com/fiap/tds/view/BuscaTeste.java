package br.com.fiap.tds.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ProjetoChallengeDao;
import br.com.fiap.tds.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.NanoCourse;
import br.com.fiap.tds.entity.ProjetoChallenge;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {

	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter o ProjetoChallengeDao
		ProjetoChallengeDao dao = new ProjetoChallengeDaoImpl(em);
		
		try {
			//Pesquisar um projeto
			ProjetoChallenge projeto = dao.read(1);
			
			//Exibir o nome do projeto
			System.out.println("Projeto: " + projeto.getNome());
			
			//Exibir o nome do grupo
			System.out.println("Grupo: " + projeto.getGrupo().getNome());
			
			//Exibir o nome dos alunos do grupo
			System.out.println("Alunos:");
			List<Aluno> alunos = projeto.getGrupo().getAlunos();
			for (Aluno aluno : alunos) {
				System.out.println(aluno.getNome());
				//Exibir os cursos relacionados ao aluno
				System.out.println("Cursos realizados:");
				for (NanoCourse nano : aluno.getCursos()) {
					System.out.println(nano.getNome());
				}
			}
			
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
