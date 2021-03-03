package br.com.fiap.revisao.bean;

public class Gerente extends Funcionario {

	//Sobrescrita -> mesmo método na classe filha
	@Override
	public void receberBonificacao() {
		System.out.println("Gerente recebeu super bonus");
	}
	
	
}