package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.SistemaDao;
import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.entity.CasoTeste;
import br.com.fiap.tds.entity.ItemTeste;
import br.com.fiap.tds.entity.Sistema;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Cadastro {

	//Cadastrar todas as entidades relacionadas
	public static void main(String[] args) {
		//Instanciar um sistema com o nome
		Sistema sistema = new Sistema("Vendas online");
		
		//Instanciar 2 casos de teste com o nome e descrição
		CasoTeste caso1 = new CasoTeste("Venda", "Realização de vendas");
		CasoTeste caso2 = new CasoTeste("Troca", "Realização de trocas de produtos");
		
		//Adicionar os casos de teste no sistema
		sistema.addCasoteste(caso1);
		sistema.addCasoteste(caso2);
		
		//Instanciar 3 itens de teste com a descrição
		ItemTeste item1 = new ItemTeste("Venda com sucesso através de cartão de crédito");
		ItemTeste item2 = new ItemTeste("Venda com sucesso através de boleto");
		ItemTeste item3 = new ItemTeste("Troca de produtos dentro do prazo");
		
		//Adicionar 2 itens no primeiro caso e 1 item no segundo
		caso1.addItemTeste(item1);
		caso1.addItemTeste(item2);
		
		caso2.addItemTeste(item3);
		
		//Instanciar 2 usuários com o nome
		Usuario usuario1 = new Usuario("Jonas");
		Usuario usuario2 = new Usuario("Helouíse");
		
		//Criar uma lista de usuários e adicioná-los na lista
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		//Setar a lista de usuário em 2 itens de teste
		item1.setUsuarios(usuarios);
		item3.setUsuarios(usuarios);
		
		//Instanciar um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
				
		//Instanciar um SistemaDao
		SistemaDao dao = new SistemaDaoImpl(em);
		
		try {
			//Cadastrar do sistema
			dao.create(sistema);
			//Commit
			dao.commit();
			System.out.println("Deu bom!");
		} catch (CommitException e) {
			System.out.println("Deu ruim..");
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}