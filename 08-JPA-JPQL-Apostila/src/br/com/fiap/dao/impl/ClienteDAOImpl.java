package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) {
		TypedQuery<Cliente> query = 
				em.createQuery("from Cliente c where c.nome like :n", Cliente.class);
		query.setParameter("n", "%" + nome + "%");
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(String estado) {
		TypedQuery<Cliente> query = 
			em.createQuery("from Cliente c where c.endereco.cidade.uf = :es", Cliente.class);
		query.setParameter("es", estado);
		return query.getResultList();
		
	}

	@Override
	public List<Cliente> buscarPorDiasReserva(int dias) {
		//TypedQuery<Cliente> query = em.createQuery("select r.cliente from Reserva r where r.numeroDias = :d", Cliente.class);
		//query.setParameter("d", dias);
		//return query.getResultList();
		return em.createQuery(
				"select r.cliente from Reserva r where r.numeroDias = :d",Cliente.class)
				.setParameter("d", dias)
				.getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		return em.createQuery("from Cliente c where c.nome like :n and c.endereco.cidade.nome like :cid", Cliente.class)
				.setParameter("n", "%" + nome + "%")
				.setParameter("cid", "%" + cidade + "%")
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstados(List<String> estados) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf in :es", Cliente.class)
				.setParameter("es", estados)
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorNome2(String nome) {
		return em.createQuery("from Cliente c where lower(c.nome) like lower(:n) order by c.nome", Cliente.class)
				.setParameter("n", "%" + nome + "%")
				.getResultList();
	}

	@Override
	public long contarPorEstado(String estado) {
		return em.createQuery("select count(c) from Cliente c where lower(c.endereco.cidade.uf) = lower(:pEstado)", Long.class)
				.setParameter("pEstado", estado)
				.getSingleResult();
	}

}






