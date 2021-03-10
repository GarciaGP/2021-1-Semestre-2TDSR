package br.com.fiap.main;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoInsuficienteException;

public class Exercicio06 {

	//@SuppressWarnings("all")
	public static void main(String[] args) {
		
		//Instanciar uma conta corrente
		ContaCorrente cc = new ContaCorrente(
			1, 324, Calendar.getInstance(), 100, TipoConta.COMUM);
		
		//Instanciar uma conta poupança
		ContaPoupanca cp = new ContaPoupanca(
			1, 1231, new GregorianCalendar(2021, Calendar.APRIL, 1), 200, 1);
				
		//Chamar o método retirar
		try {
			cc.retirar(300);
			System.out.println("Saque efetuado!");
		} catch(SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		
	}//main
	
}//classe