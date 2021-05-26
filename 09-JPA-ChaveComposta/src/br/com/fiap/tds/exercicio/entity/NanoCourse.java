package br.com.fiap.tds.exercicio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_NANO_COURSE")
@SequenceGenerator(name="nano", sequenceName = "SQ_TB_NANO_COURSE", allocationSize = 1)
public class NanoCourse {
	
	@Id
	@Column(name="cd_course")
	@GeneratedValue(generator = "nano", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_course", nullable = false, length = 80)
	private String nome;

	public NanoCourse() {}
	
	public NanoCourse(String nome) {
		this.nome = nome;
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
	
}
