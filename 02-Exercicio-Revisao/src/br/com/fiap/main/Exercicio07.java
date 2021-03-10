package br.com.fiap.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;

public class Exercicio07 {

	public static void main(String[] args) {
		//Criar uma lista de conta corrente
		List<ContaCorrente> lista = new ArrayList<>();
		
		//Adicionar 3 contas na lista
		lista.add(new ContaCorrente(1, 2, Calendar.getInstance(), 120, TipoConta.COMUM));
		lista.add(new ContaCorrente(23,53,Calendar.getInstance(), 9000, TipoConta.PREMIUM));
		lista.add(new ContaCorrente(23,443, Calendar.getInstance(), 800, TipoConta.COMUM));
		
		//Exibir os saldos da conta
		for (ContaCorrente c : lista) {
			System.out.println(c.getSaldo());
		}
		
	}//main
	
}//classe
