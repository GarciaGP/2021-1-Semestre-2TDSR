package br.com.fiap.tds.exercicio.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@IdClass(AlunoCoursePK.class)

@Entity
@Table(name="TB_ALUNO_COURSE")
public class AlunoCourse {
	
	@Id
	@ManyToOne
	@JoinColumn(name="nr_rm")
	private Aluno aluno;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cd_course")
	private NanoCourse nano;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_matricula", nullable = false)
	private Calendar dataMatricula;
	
	@Column(name="vl_nota")
	private Float nota;
	
	public AlunoCourse() {}

	public AlunoCourse(Aluno aluno, NanoCourse nano, Calendar dataMatricula, Float nota) {
		this.aluno = aluno;
		this.nano = nano;
		this.dataMatricula = dataMatricula;
		this.nota = nota;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public NanoCourse getNano() {
		return nano;
	}

	public void setNano(NanoCourse nano) {
		this.nano = nano;
	}

	public Calendar getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Calendar dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}

}
