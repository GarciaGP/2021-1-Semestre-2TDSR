package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_PESSOA_FISICA")
public class PessoaFisica extends Pessoa {

	@Column(name="nr_cpf", length = 16)
	private String cpf;
	
	@Column(name="nr_rg", length = 20)
	private String rg;
	
	public PessoaFisica() {}
	
	public PessoaFisica(String nome, String endereco, String cpf, String rg) {
		super(nome, endereco);
		this.cpf = cpf;
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
}
