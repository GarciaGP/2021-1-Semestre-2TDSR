package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ALUNO")
@SequenceGenerator(name="aluno",sequenceName = "SQ_TB_ALUNO",allocationSize = 1)
public class Aluno {

	@Id
	@Column(name="cd_aluno")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno")
	private int codigo;
	
	@Column(name="nm_aluno", length = 80, nullable = false)
	private String nome;
	
	@Column(name="ds_turma", length = 50, nullable = false)
	private String turma;
	
	public Aluno() {}

	public Aluno(String nome, String turma) {
		this.nome = nome;
		this.turma = turma;
	}
	
	public Aluno(int codigo, String nome, String turma) {
		this.codigo = codigo;
		this.nome = nome;
		this.turma = turma;
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

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}
	
}
