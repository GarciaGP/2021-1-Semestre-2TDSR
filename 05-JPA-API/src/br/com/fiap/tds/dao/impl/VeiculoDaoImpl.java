package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.VeiculoDao;
import br.com.fiap.tds.entity.Veiculo;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.VeiculoNotFoundException;

// View - Controller - DAO - Banco

public class VeiculoDaoImpl implements VeiculoDao {

	private EntityManager em;
	
	public VeiculoDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void add(Veiculo veiculo) {
		em.persist(veiculo);
	}

	@Override
	public Veiculo read(int codigo) throws VeiculoNotFoundException {
		Veiculo veiculo = em.find(Veiculo.class, codigo);
		if (veiculo == null)
			throw new VeiculoNotFoundException();
		return veiculo;
	}

	@Override
	public void update(Veiculo veiculo) {
		em.merge(veiculo);
	}

	@Override
	public void delete(int codigo) throws VeiculoNotFoundException {
		Veiculo veiculo = read(codigo);
		em.remove(veiculo);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}
	
}