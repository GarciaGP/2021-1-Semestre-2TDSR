package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.PessoaDao;
import br.com.fiap.tds.dao.impl.PessoaDaoImpl;
import br.com.fiap.tds.entity.Pessoa;
import br.com.fiap.tds.entity.PessoaFisica;
import br.com.fiap.tds.entity.PessoaJuridica;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//Cadastrar uma pessoa, pessoa fisica e pessoa juridica
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar o PessoaDao
		PessoaDao dao = new PessoaDaoImpl(em);
		
		//Instanciar uma pessoa, pessoa fisica e pessoa juridica
		Pessoa pessoa = new Pessoa("Sálvio", "Av lins de vasconcelos");
		PessoaFisica pf = new PessoaFisica("Rita", "Av Paulista", "123412312", "9892343");
		PessoaJuridica pj = new PessoaJuridica("FIAP", "Av Olimpiadas", "3252356342", "9279342");
		
		try {
			//Cadastrar
			dao.create(pessoa);
			dao.create(pf);
			dao.create(pj);
			dao.commit();
			//Commit
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}
