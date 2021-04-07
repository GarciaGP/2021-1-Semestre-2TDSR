package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.AlunoDao;
import br.com.fiap.tds.entity.Aluno;

public class AlunoDaoImpl 
			extends GenericDaoImpl<Aluno, Integer> implements AlunoDao {

	public AlunoDaoImpl(EntityManager em) {
		super(em);
	}

}