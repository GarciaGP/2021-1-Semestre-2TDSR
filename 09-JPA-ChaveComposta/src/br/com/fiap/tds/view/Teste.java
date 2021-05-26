package br.com.fiap.tds.view;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.CarrinhoCompraDao;
import br.com.fiap.tds.dao.ItemProdutoDao;
import br.com.fiap.tds.dao.ProdutoDao;
import br.com.fiap.tds.dao.impl.CarrinhoCompraDaoImpl;
import br.com.fiap.tds.dao.impl.ItemProdutoDaoImpl;
import br.com.fiap.tds.dao.impl.ProdutoDaoImpl;
import br.com.fiap.tds.entity.CarrinhoCompra;
import br.com.fiap.tds.entity.ItemProduto;
import br.com.fiap.tds.entity.ItemProdutoPK;
import br.com.fiap.tds.entity.Produto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//Cadastrar um produto, carrinho de compra e item
		//Obter um EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um ProdutoDao e CarrinhoCompraDao
		ProdutoDao produtoDao = new ProdutoDaoImpl(em);
		CarrinhoCompraDao carrinhoDao = new CarrinhoCompraDaoImpl(em);
		
		//Instanciar um produto
		Produto produto = new Produto("Caderno");
		
		//Instanciar um ItemProduto (tirar o carrinho de compras do construtor ou deixar null)
		ItemProduto item = new ItemProduto(produto, null, 10.0, 2);
		
		//Instanciar um Carrinho de compras
		CarrinhoCompra carrinho = new CarrinhoCompra(Calendar.getInstance());
		
		//Adicionar o item no carrinho de compra
		carrinho.addItem(item);
		
		try {
			//Cadastrar um produto
			produtoDao.create(produto);
			//Cadastrar o carrinho de compras (O item produto vai em cascata)
			carrinhoDao.create(carrinho);
			produtoDao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar um item pela PK
		try {
			ItemProdutoDao itemDao = new ItemProdutoDaoImpl(em);
			ItemProdutoPK pk = new ItemProdutoPK(1, 21, 1);
			ItemProduto item2 =  itemDao.read(pk);
			System.out.println(item2.getProduto().getNome() + " " + item2.getValor());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
