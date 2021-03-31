package br.com.fiap.tds.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.dao.VeiculoDao;
import br.com.fiap.tds.dao.impl.VeiculoDaoImpl;
import br.com.fiap.tds.entity.Combustivel;
import br.com.fiap.tds.entity.Veiculo;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.VeiculoNotFoundException;

public class VeiculoDaoTeste {

	public static void main(String[] args) {
		
		//Obter um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um VeiculoDao
		VeiculoDao dao = new VeiculoDaoImpl(em);
		
		//Cadastrar um veículo
		Veiculo veiculo = new Veiculo("Toyota", "Branco", 
								Calendar.getInstance(), Combustivel.ELETRICO, true);
		
		try {
			dao.add(veiculo);
			dao.commit();
			System.out.println("Veiculo registrado!");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar um veículo e exibir os dados
		try {
			veiculo = dao.read(1);
			System.out.println(veiculo);
		} catch(VeiculoNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Atualizar um veiculo
		veiculo = new Veiculo(1, "FIAT", "Preto", 
				Calendar.getInstance(), Combustivel.FLEX, false);
		
		try {
			dao.update(veiculo);
			dao.commit();
			System.out.println("Veículo atualizado!");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Remover um veiculo
		try {
			dao.delete(1);
			dao.commit();
			System.out.println("Veículo removido!");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		} catch(VeiculoNotFoundException e) {
			System.out.println("Veículo não existe para remover");
		}
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
