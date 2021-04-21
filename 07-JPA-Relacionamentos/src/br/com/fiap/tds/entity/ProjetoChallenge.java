package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PROJETO_CHALLENGE")
@SequenceGenerator(name="projeto", sequenceName = "SQ_TB_PROJETO_CHALLENGE", allocationSize = 1)
public class ProjetoChallenge {
	
	@Id
	@Column(name="cd_projeto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projeto")
	private int codigo;
	
	@Column(name="nm_projeto", nullable = false, length = 80)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_entrega", nullable = false)
	private Calendar dataEntrega;
	
	@Column(name="vl_nota")
	private Float nota;
	
	@Column(name="ds_setor", length = 100)
	private String setor;
	
	//Mapear o relacionamento um-para-um
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="cd_grupo", nullable = false, unique = true)
	private GrupoChallenge grupo;
	
	public ProjetoChallenge() {}

	public ProjetoChallenge(String nome, Calendar dataEntrega, Float nota, String setor, GrupoChallenge grupo) {
		this.nome = nome;
		this.dataEntrega = dataEntrega;
		this.nota = nota;
		this.setor = setor;
		this.grupo = grupo;
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

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public GrupoChallenge getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoChallenge grupo) {
		this.grupo = grupo;
	}
	
}
