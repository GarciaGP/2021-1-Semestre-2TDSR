package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.SistemaDao;
import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.entity.CasoTeste;
import br.com.fiap.tds.entity.ItemTeste;
import br.com.fiap.tds.entity.Sistema;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Pesquisa {

	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um SistemaDao
		SistemaDao dao = new SistemaDaoImpl(em);
		
		try {
			//Pesquisar um sistema pelo código
			Sistema sistema = dao.read(1);
			
			//Exibir o nome do sistema
			System.out.println("Sistema: " + sistema.getNome());
			
			//Exibir os nomes e descrições dos casos de teste
			for (CasoTeste caso : sistema.getCasosTeste()) {
				System.out.println("\nCaso de teste: " + caso.getNome() + " - " + caso.getDescricao());
				
				//Exibir a descrição dos itens de teste de cada caso de teste
				System.out.println("\nItens de teste:");
				for (ItemTeste item : caso.getItensTeste()) {
					System.out.println(item.getDescricao());
					
					//Exibir os usuários responsáveis pelo teste dos itens
					System.out.println("Usuários:");
					for (Usuario usuario : item.getUsuarios()) {
						System.out.println(usuario.getNome());
					}
				}
			}
			
		} catch (EntityNotFoundException e) {
			System.out.println("Sistema não encontrado");
		}
		
	}//main
	
}//classe
