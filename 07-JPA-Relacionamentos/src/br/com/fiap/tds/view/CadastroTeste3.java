package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.ProjetoChallengeDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.tds.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.NanoCourse;
import br.com.fiap.tds.entity.ProjetoChallenge;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste3 {
	
	public static void main(String[] args) {
		//Obter o EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Cadastrar um grupo:
		//Instanciar um GrupoDao
		GrupoChallengeDao grupoDao = new GrupoChallengeDaoImpl(em);
		
		//Instanciar um Grupo
		GrupoChallenge grupo = new GrupoChallenge("Teste grupo");
		
		//Chamar o create do dao e commit
		try {
			grupoDao.create(grupo);
			grupoDao.commit();
			System.out.println("Grupo cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Cadastrar um projeto associado a um grupo que existe no banco:
		//Instanciar um ProjetoDao
		ProjetoChallengeDao projetoDao = new ProjetoChallengeDaoImpl(em);
		
		try {
			//Pesquisar um grupo no banco
			grupo = grupoDao.read(2);
			
			//Instanciar um Projeto com um grupo
			ProjetoChallenge projeto = new ProjetoChallenge("Teste Projeto", Calendar.getInstance(), 
																					null, "Teste", grupo);
			
			//Chamar o create do dao e commit
			projetoDao.create(projeto);
			projetoDao.commit();
			System.out.println("Grupo registrado!");
		
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Cadastrar um aluno associado a um grupo que existe no banco
		//Instanciar um AlunoDao
		GenericDao<Aluno,Integer> alunoDao = new GenericDaoImpl<Aluno,Integer>(em) {};
		
		try {
			//Pesquisar um Grupo
			grupo = grupoDao.read(2);
			
			//Instanciar um Aluno com o grupo
			Aluno aluno = new Aluno("Aline", new GregorianCalendar(2000, Calendar.APRIL, 3), Genero.FEMININO);
			aluno.setGrupo(grupo);
			
			//Chamar o create e commit do AlunoDao
			alunoDao.create(aluno);
			alunoDao.commit();
			System.out.println("Aluno registrado!");
			
		}catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Associar um aluno a um curso que já existem no banco
		//Instanciar um NanoCourseDao
		GenericDao<NanoCourse,Integer> nanoDao = new GenericDaoImpl<NanoCourse,Integer>(em){};
		
		try {
			//Pesquisar dois curso
			NanoCourse nano1 = nanoDao.read(1);
			NanoCourse nano2 = nanoDao.read(2);
			
			//Pesquisar um aluno
			Aluno aluno = alunoDao.read(3);
			
			//Adicionar os cursos na lista de cursos do aluno
			aluno.getCursos().add(nano1);
			aluno.getCursos().add(nano2);
			
			//Update no aluno
			alunoDao.update(aluno);
			alunoDao.commit();
			System.out.println("Aluno matriculado!");
		
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
	}//main

}//classe
