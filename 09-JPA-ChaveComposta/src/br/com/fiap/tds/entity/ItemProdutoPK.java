package br.com.fiap.tds.entity;

import java.io.Serializable;

//Classe que mapeia a chave composta da tabela TB_ITEM_PRODUTO
//Possui os atributos que formam a chave (possuem o mesmo nome dos atributos da classe)

public class ItemProdutoPK implements Serializable {

	private int codigo;
	
	private int produto;
	
	private int carrinho;
	
	public ItemProdutoPK() {}	
	
	public ItemProdutoPK(int codigo, int produto, int carrinho) {
		this.codigo = codigo;
		this.produto = produto;
		this.carrinho = carrinho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carrinho;
		result = prime * result + codigo;
		result = prime * result + produto;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemProdutoPK other = (ItemProdutoPK) obj;
		if (carrinho != other.carrinho)
			return false;
		if (codigo != other.codigo)
			return false;
		if (produto != other.produto)
			return false;
		return true;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getProduto() {
		return produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}

	public int getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(int carrinho) {
		this.carrinho = carrinho;
	}
	
	
	
}
