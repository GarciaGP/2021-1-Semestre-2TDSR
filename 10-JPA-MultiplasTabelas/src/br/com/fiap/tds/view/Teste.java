package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.FuncionarioDao;
import br.com.fiap.tds.dao.impl.FuncionarioDaoImpl;
import br.com.fiap.tds.entity.Funcionario;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {
	
	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um FuncionarioDao
		FuncionarioDao dao = new FuncionarioDaoImpl(em);
		
		//Instanciar um funcionario
		Funcionario f = new Funcionario("Allen", 
				new GregorianCalendar(2010, Calendar.JANUARY, 10), 20000.0, 123123, 314);
		
		try {
			//Cadastrar um funcionario
			dao.create(f);
			dao.commit();
			System.out.println("Funcionário cadastrado!");
			
			//Pesquisar um funcionario por código
			Funcionario func = dao.read(1);
			System.out.println(func.getNome() + " " + func.getSalario());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
}
