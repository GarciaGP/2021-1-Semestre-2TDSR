package br.com.fiap.revisao.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.revisao.bean.Funcionario;

public class TesteColecao {

	public static void main(String[] args) {
		
		//Instanciar uma lista de Funcionario
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		//Adicionar dois funcionários na lista
		lista.add(new Funcionario(1, "Gabriel"));
		
		Funcionario func = new Funcionario(2, "Daniel");
		lista.add(func);
		
		//Exibir os funcionários da lista
		for (int i=0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getId() + " " + 
												lista.get(i).getNome());
		}
		
		//Foreach
		for (Funcionario f : lista) {
			System.out.println(f);
			//System.out.println(f.getId() + " " + f.getNome());
		}
		
		//Mapa <Chave,Valor>
		Map<String, Funcionario> mapa = new HashMap<String, Funcionario>();
		
		//Adicionar dois funcionários no mapa
		mapa.put("f1", new Funcionario(1, "Jessica"));
		mapa.put("f2", new Funcionario(2, "Helouise"));
		
		//Recuperar o funcionário da chave "f1"
		func = mapa.get("f2");
		System.out.println(func.getId() + " " + func.getNome());
		
	}
	
}