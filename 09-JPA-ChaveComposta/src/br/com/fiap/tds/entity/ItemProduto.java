package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Define qual classe que mapeia as chaves da tabela
@IdClass(ItemProdutoPK.class)

@Entity
@Table(name="TB_ITEM_PRODUTO")
@SequenceGenerator(name="item", sequenceName = "SQ_TB_ITEM_PRODUTO", allocationSize = 1)
public class ItemProduto {
	
	@Id
	@Column(name="cd_item_produto")
	@GeneratedValue(generator = "item", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cd_produto")
	private Produto produto;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cd_carrinho")
	private CarrinhoCompra carrinho;
	
	@Column(name="vl_item", nullable = false)
	private Double valor;
	
	@Column(name="qt_item", nullable = false)
	private Integer quantidade;
	
	public ItemProduto() {}
	
	public ItemProduto(Produto produto, CarrinhoCompra carrinho, Double valor, Integer quantidade) {
		super();
		this.produto = produto;
		this.carrinho = carrinho;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public CarrinhoCompra getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoCompra carrinho) {
		this.carrinho = carrinho;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
