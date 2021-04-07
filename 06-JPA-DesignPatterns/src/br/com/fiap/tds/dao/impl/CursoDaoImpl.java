package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.CursoDao;
import br.com.fiap.tds.entity.Curso;

public class CursoDaoImpl 
					extends GenericDaoImpl<Curso, Integer> implements CursoDao {

	public CursoDaoImpl(EntityManager em) {
		super(em);
	}

}
