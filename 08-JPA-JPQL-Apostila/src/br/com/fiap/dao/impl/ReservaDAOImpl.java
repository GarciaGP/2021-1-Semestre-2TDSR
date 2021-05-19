package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Reserva> buscarPorNomeCliente(String nome) {
		return em.createNamedQuery("Reserva.PorNomeCliente", Reserva.class)
				.setParameter("pNome", "%"+ nome + "%")
				.getResultList();
	}

	@Override
	public List<Reserva> buscarPorPrecoPacote(float preco1, float preco2) {
		return em.createNamedQuery("Reserva.PorPrecoPacote", Reserva.class)
				.setParameter("p1", preco1)
				.setParameter("p2", preco2)
				.getResultList();
	}

}
