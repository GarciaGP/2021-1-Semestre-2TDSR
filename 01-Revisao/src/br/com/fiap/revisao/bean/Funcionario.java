package br.com.fiap.revisao.bean;

public class Funcionario {
	
	// Modificadores de acessos:
	// public -> todos;
	// private -> somente a própria classe;
	// protected -> classes filhas, classes no mesmo pacote;
	// default (package) -> classes no mesmo pacote;
	
	// Tipos primitivos: boolean, byte, short, int, long, char, float, double
	// Valor padrão: números = 0, boolean = false
	
	// Tipos de referência: String, Funcionario, Empresa
	// Valor padrão: null
	
	//Atributos
	private int id;
	
	private String nome;
	
	private int anoNascimento;
	
	//CTRL + 1
	private Genero genero;
	
	//Construtores
	public Funcionario(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Funcionario() {}
	
	@Override
	public String toString() {
		return id + " - " + nome;
	}
	
	//Métodos
	public void trabalhar() {
		System.out.println("Funcionário trabalhando...");
	}
	
	public void receberBonificacao() {
		System.out.println("Funcionário recebendo bônus");
	}
	
	//Sobrecarga -> mesmo método com parâmetros diferentes
	public void trabalhar(int horas) {
		System.out.println("Trabalhando " + horas);
	}
	
	public void trabalhar(int horas, boolean extra) {
		System.out.println("Trabalhando " + horas + " extra: " + extra);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getAnoNascimento() {
		return anoNascimento;
	}
	
	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}