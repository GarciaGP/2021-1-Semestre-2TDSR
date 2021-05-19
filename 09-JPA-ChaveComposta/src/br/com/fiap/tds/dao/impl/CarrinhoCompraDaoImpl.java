package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.CarrinhoCompraDao;
import br.com.fiap.tds.entity.CarrinhoCompra;

public class CarrinhoCompraDaoImpl 
			extends GenericDaoImpl<CarrinhoCompra, Integer> implements CarrinhoCompraDao {

	public CarrinhoCompraDaoImpl(EntityManager em) {
		super(em);
	}

}