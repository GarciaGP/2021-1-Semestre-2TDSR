package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Inheritance(strategy = InheritanceType.JOINED)

//SINGLE_TABLE
//Configurar a coluna que armazena o tipo de objeto gravado
//@DiscriminatorColumn(name = "ds_tipo")
//@DiscriminatorValue("P")

@Entity
@Table(name="TB_PESSOA")
@SequenceGenerator(name="pessoa", sequenceName = "SQ_TB_PESSOA", allocationSize = 1)
public class Pessoa {
	
	@Id
	@Column(name="cd_pessoa")
	@GeneratedValue(generator = "pessoa", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_pessoa", nullable = false, length = 80)
	private String nome;
	
	@Column(name="ds_endereco", nullable = false, length = 100)
	private String endereco;
	
	public Pessoa() {}

	public Pessoa(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
