package br.com.fiap.revisao.main;

import br.com.fiap.revisao.bean.Funcionario;
import br.com.fiap.revisao.bean.Gerente;

public class TesteMetodos {

	public static void main(String args[]) {
		
		//Instanciar um funcionário
		Funcionario funcionario = new Funcionario();
		
		//Chamar o método receberBonificacao
		funcionario.receberBonificacao(); // Funcionario
		
		//Instanciar um gerente
		Gerente gerente = new Gerente();
		
		//Chamar o método receberBonificacao	
		gerente.receberBonificacao(); // Gerente
		
		Funcionario f = new Gerente();
		
		f.receberBonificacao(); // Gerente
		
		//Gerente g = new Funcionario(); // Não compila
		
	}
	
}