package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.AlunoCourseDao;
import br.com.fiap.tds.exercicio.entity.AlunoCourse;
import br.com.fiap.tds.exercicio.entity.AlunoCoursePK;

public class AlunoCourseDaoImpl 
			extends GenericDaoImpl<AlunoCourse, AlunoCoursePK>
														implements AlunoCourseDao {

	public AlunoCourseDaoImpl(EntityManager em) {
		super(em);
	}

}
