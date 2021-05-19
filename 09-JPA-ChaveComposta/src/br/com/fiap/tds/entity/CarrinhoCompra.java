package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_CARRINHO_COMPRA")
@SequenceGenerator(name="carrinho", sequenceName = "SQ_TB_CARRINHO_COMPRA", allocationSize = 1)
public class CarrinhoCompra {

	@Id
	@Column(name="cd_carrinho")
	@GeneratedValue(generator = "carrinho", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_carrinho", nullable = false)
	private Calendar data;
	
	@OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
	private List<ItemProduto> itens;
	
	public void addItem(ItemProduto item) {
		if (itens == null)
			itens = new ArrayList<>();
		itens.add(item);
		item.setCarrinho(this);
	}

	public CarrinhoCompra() {}
	
	public CarrinhoCompra(Calendar data) {
		this.data = data;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<ItemProduto> getItens() {
		return itens;
	}

	public void setItens(List<ItemProduto> itens) {
		this.itens = itens;
	}
	
}
