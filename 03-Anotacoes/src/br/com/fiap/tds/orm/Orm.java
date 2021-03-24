package br.com.fiap.tds.orm;

import br.com.fiap.tds.annotation.Tabela;

public class Orm {

	public String gerarPesquisa(Object object) {
		//Obter a anotação @Tabela da classe
		Tabela anotacao = object.getClass().getAnnotation(Tabela.class);
		//Recuperar o parâmetro "nome" da anotação
		String nome = anotacao.nome();
		return "SELECT * FROM " + nome;
	}
	
}
