package br.com.fiap.tds.view;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AlunoCourseDao;
import br.com.fiap.tds.dao.impl.AlunoCourseDaoImpl;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.exercicio.entity.Aluno;
import br.com.fiap.tds.exercicio.entity.AlunoCourse;
import br.com.fiap.tds.exercicio.entity.AlunoCoursePK;
import br.com.fiap.tds.exercicio.entity.NanoCourse;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Exercicio {

	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um AlunoCourseDao
		AlunoCourseDao dao = new AlunoCourseDaoImpl(em);
		
		//Instanciar um curso
		NanoCourse nano = new NanoCourse("PHP");
		
		//Instanciar um aluno
		Aluno aluno = new Aluno("Maria");
		
		//Instanciar um AlunoCourse com o curso e aluno
		AlunoCourse alunoCourse = new AlunoCourse(aluno, nano, Calendar.getInstance(), null);
		
		//Cadastrar o AlunoCourse
		try {
			dao.create(alunoCourse);
			dao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pequisar o AlunoCourse pelo código
		try {
			AlunoCoursePK pk = new AlunoCoursePK(1, 1);
			alunoCourse = dao.read(pk);
			System.out.println(alunoCourse.getAluno().getNome()
								+ " " + alunoCourse.getNano().getNome());	
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}