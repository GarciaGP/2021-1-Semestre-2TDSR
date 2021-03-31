package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="TB_CURSO")
@SequenceGenerator(name="curso",sequenceName = "SQ_TB_CURSO",allocationSize = 1)
public class Curso {

	@Id
	@Column(name="cd_curso")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso")
	private int codigo;
	
	@Column(name="nm_curso", length = 50, nullable = false)
	private String nome;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cadastro", updatable = false)
	private Calendar dataCadastro;
	
	@Column(name="vl_curso")
	private double valor;
	
	public Curso() {}

	public Curso(String nome, double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	
	public Curso(int codigo, String nome, double valor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
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

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
