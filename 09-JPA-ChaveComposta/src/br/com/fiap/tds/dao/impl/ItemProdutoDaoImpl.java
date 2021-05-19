package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.ItemProdutoDao;
import br.com.fiap.tds.entity.ItemProduto;
import br.com.fiap.tds.entity.ItemProdutoPK;

public class ItemProdutoDaoImpl 
			extends GenericDaoImpl<ItemProduto, ItemProdutoPK> implements ItemProdutoDao {

	public ItemProdutoDaoImpl(EntityManager em) {
		super(em);
	}

}
