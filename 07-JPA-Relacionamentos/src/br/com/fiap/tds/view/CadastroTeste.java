package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.ProjetoChallengeDao;
import br.com.fiap.tds.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.tds.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.NanoCourse;
import br.com.fiap.tds.entity.NivelCurso;
import br.com.fiap.tds.entity.ProjetoChallenge;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	//Utiliza o projeto para cadastrar o grupo
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
		
		//Cadastrar um grupo
		//grupoDao.create(grupo);
		
		//Instanciar 3 alunos e adiciona-los no grupo
		Aluno aluno1 = new Aluno("Helouise", new GregorianCalendar(2002, Calendar.JULY, 4), Genero.FEMININO);
		Aluno aluno2 = new Aluno("Luis Felipe", new GregorianCalendar(2001, Calendar.AUGUST, 8), Genero.MASCULINO);
		Aluno aluno3 = new Aluno("Daniel", new GregorianCalendar(2001, Calendar.DECEMBER, 25), Genero.MASCULINO);
		
		grupo.addAluno(aluno1);
		grupo.addAluno(aluno2);
		grupo.addAluno(aluno3);
		
		//Cadastrar 2 cursos relacionados com os alunos
		//Instanciar 2 cursos
		NanoCourse nano1 = new NanoCourse("Java", 10, NivelCurso.AVANCADO);
		NanoCourse nano2 = new NanoCourse("Negociação", 5, NivelCurso.INTERMEDIARIO);
		
		//Instanciar uma lista de curso e adicionar os cursos na lista
		List<NanoCourse> cursos = new ArrayList<>();
		cursos.add(nano1);
		cursos.add(nano2);
		
		//Setar a lista de curso no aluno
		aluno1.setCursos(cursos);
		aluno2.setCursos(cursos);
		
		//Cadastrar um projeto
		projetoDao.create(projeto);
		
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
