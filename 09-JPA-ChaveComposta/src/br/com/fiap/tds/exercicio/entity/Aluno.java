package br.com.fiap.tds.exercicio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ALUNO")
@SequenceGenerator(name="aluno", sequenceName = "SQ_TB_ALUNO", allocationSize = 1)
public class Aluno {
	
	@Id
	@Column(name="nr_rm")
	@GeneratedValue(generator = "aluno", strategy = GenerationType.SEQUENCE)
	private int rm;
	
	@Column(name="nm_aluno", nullable = false, length = 80)
	private String nome;
	
	public Aluno() {}

	public Aluno(String nome) {
		this.nome = nome;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
