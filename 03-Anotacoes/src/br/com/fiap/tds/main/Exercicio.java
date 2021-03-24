package br.com.fiap.tds.main;

import br.com.fiap.tds.bean.Aluno;
import br.com.fiap.tds.bean.Pedido;
import br.com.fiap.tds.orm.Orm;

public class Exercicio {

	public static void main(String[] args) {
		//Instanciar um Aluno
		Aluno aluno = new Aluno();
		Pedido pedido = new Pedido();
		
		//Instanciar um Orm
		Orm orm = new Orm();
		
		//Exibir o resultado do método gerarPequisa passando o aluno
		System.out.println(orm.gerarPesquisa(aluno));
		System.out.println(orm.gerarPesquisa(pedido));
	}
	
}
