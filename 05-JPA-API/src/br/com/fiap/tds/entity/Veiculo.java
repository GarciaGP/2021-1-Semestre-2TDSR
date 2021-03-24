package br.com.fiap.tds.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="TB_VEICULO")
@SequenceGenerator(name="veiculo", sequenceName = "SQ_TB_VEICULO", allocationSize = 1)
public class Veiculo {

	@Id
	@Column(name="cd_veiculo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo")
	private int codigo;
	
	@Column(name="ds_marca", length = 60, nullable = false)
	private String marca;
	
	@Column(name="ds_cor", length = 20)
	private String cor;
	
	@Column(name="dt_venda")
	@Temporal(TemporalType.DATE)
	private Calendar dataVenda;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_combustivel", nullable = false, length = 40)
	private Combustivel combustivel;
	
	@CreationTimestamp //Atribui a data de cadastro automáticamente
	@Column(name="dt_cadastro", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;
	
	@Column(name="st_novo")
	private boolean novo;
	
	public Veiculo() {}
	
	public Veiculo(String marca, String cor, Calendar dataVenda, Combustivel combustivel, boolean novo) {
		super();
		this.marca = marca;
		this.cor = cor;
		this.dataVenda = dataVenda;
		this.combustivel = combustivel;
		this.novo = novo;
	}
	
	public Veiculo(int codigo, String marca, String cor, Calendar dataVenda, Combustivel combustivel, boolean novo) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.cor = cor;
		this.dataVenda = dataVenda;
		this.combustivel = combustivel;
		this.novo = novo;
	}

	//CTRL + 3 -> gcuf
	@PostPersist //Antes do persist
	public void teste() {
		System.out.println("Antes de cadastrar..");
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		return "Código: " + codigo + "\nMarca: " + marca + "\nCor: "
				+ cor + "\nCombustível: " + combustivel + "\nNovo: " 
				+ novo + "\nData Venda: " + sdf.format(dataVenda.getTime())
				+ "\nData Cadastro: " + sdf.format(dataCadastro.getTime());
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public boolean isNovo() {
		return novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	}
	
}
