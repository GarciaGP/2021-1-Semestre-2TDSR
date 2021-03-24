package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="TAB_PRODUTO")
@SequenceGenerator(sequenceName = "SEQ_TAB_PRODUTO", name="produto",
														allocationSize = 1)
//sequenceName -> nome da sequence no Banco de dados
//name -> nome da sequence no java, utilizado no generator
//allocationSize -> incremento
public class Produto {

	@Id
	@Column(name="cd_produto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	private int codigo;
	
	@Column(name="nm_produto", length = 80, nullable = false)
	private String nome;
	
	@Column(name="vl_produto")
	private double valor;
	
	@Temporal(TemporalType.DATE)  //Determina o que será persistido (data)
	@Column(name="dt_entrada", nullable = false)
	private Calendar dataEntrada;
	
	//Atributo que não é uma coluna no banco de dados
	@Transient
	private int tempo;
	
	@Lob //Campo BLOB no oracle, para armazenar arquivos 
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Column(name="ds_categoria")
	@Enumerated(EnumType.STRING) // Grava a constante e não a posição
	private Categoria categoria;
	
	//CTRL + 3 -> ggas

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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}