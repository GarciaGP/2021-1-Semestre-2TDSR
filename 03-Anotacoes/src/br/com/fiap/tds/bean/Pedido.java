package br.com.fiap.tds.bean;

import br.com.fiap.tds.annotation.Coluna;
import br.com.fiap.tds.annotation.Tabela;

@Tabela(nome="TAB_PEDIDO")
public class Pedido {
	
	@Coluna(nome="cd_pedido")
	private int codigo;
	
	@Coluna(nome="vl_pedido")
	private double valor;
	
	@Coluna(nome="ds_pedido", tamanho = 100)
	private String descricao;
	
	//CTRL + 3 -> ggas

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
