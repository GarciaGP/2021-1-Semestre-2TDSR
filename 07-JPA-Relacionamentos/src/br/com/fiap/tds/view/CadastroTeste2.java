package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.ProjetoChallengeDao;
import br.com.fiap.tds.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.tds.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.ProjetoChallenge;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste2 {

	//Utiliza o grupo para cadastrar o projeto
	public static void main(String[] args) {
		//Obter o Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um GrupoChallengeDao e ProjetoChallengeDao
		GrupoChallengeDao grupoDao = new GrupoChallengeDaoImpl(em);
		ProjetoChallengeDao projetoDao = new ProjetoChallengeDaoImpl(em);
		
		//Instanciar um Grupo
		GrupoChallenge grupo = new GrupoChallenge("Bugs4ever");
		
		//Instanciar um Projeto
		ProjetoChallenge projeto = new ProjetoChallenge("IOT para salvar vidas", 
				new GregorianCalendar(2021, Calendar.OCTOBER, 10), null,  "Saúde", grupo);
		
		//setar o projeto do grupo
		grupo.setProjeto(projeto);
		
		//Cadastrar um grupo
		grupoDao.create(grupo);
		
		//Cadastrar um projeto
		//projetoDao.create(projeto);
		
		try {
			//Commit
			projetoDao.commit();
			System.out.println("Grupo e projeto cadastrados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
