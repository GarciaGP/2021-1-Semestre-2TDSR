package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="TB_DISCIPLINA")
@SequenceGenerator(name="dis", sequenceName = "SQ_TB_DISCIPLINA", allocationSize = 1)
public class Disciplina {
	
	@Id
	@Column(name="cd_disciplina")
	@GeneratedValue(generator = "dis", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_disciplina", nullable = false, length = 50)
	private String nome;
	
	@Column(name="ds_ementa")
	private String ementa;
	
	@CreationTimestamp
	@Column(name="dt_cadastro", updatable = false)
	private Calendar dataCadastro;
	
	@Column(name="nr_horas")
	private Integer horas;
	
	public Disciplina() {}

	public Disciplina(String nome, String ementa, Integer horas) {
		this.nome = nome;
		this.ementa = ementa;
		this.horas = horas;
	}

	public Disciplina(int codigo, String nome, String ementa, Integer horas) {
		this(nome, ementa, horas);
		this.codigo = codigo;
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

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
}
