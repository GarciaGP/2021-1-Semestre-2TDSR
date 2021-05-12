package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;
import br.com.fiap.util.DataUtil;

public class TestePesquisa {

	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar uma CidadeDAO
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		
		//Pesquisar as cidades
		List<Cidade> cidades = cidadeDao.listar();
		
		//Exibir todas as cidades
		System.out.println("Listar todas as cidades:");
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome() + " - " + cidade.getUf());
		}
		
		//Exibir todas as cidades que possuem mais do que 1000 habitantes
		cidades = cidadeDao.buscarPorNumeroHabitantesMaior(10000);
		
		System.out.println("Pesquisar por habitantes:");
		for (Cidade cidade: cidades) {
			System.out.println(cidade.getNome() + " - " + cidade.getNrHabitantes());
		}
		
		//Instanciar um ClienteDAO
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		//Listar os clientes
		List<Cliente> clientes = clienteDao.listar();
		
		//Exibir todos os clientes
		System.out.println("Listar os clientes:");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Pesquisar os clientes por parte do nome
		clientes = clienteDao.buscarPorNome("Le");
		
		//Exibir os clientes
		System.out.println("Buscar por parte do nome:");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		
		//Instanciar um TransporteDAO e PacoteDAO
		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		
		//Pesquisar um transporte pelo código
		Transporte transporte = transporteDao.pesquisar(2);
		
		//Buscar os pacotes pelo transporte
		List<Pacote> pacotes = pacoteDao.buscarPorTransporte(transporte);
		
		//Exibir os pacotes e o nome da empresa do transporte
		System.out.println("Buscar pacotes por transporte:");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " - " + p.getTransporte().getEmpresa()));
		
		//Pesquisar os clientes por estado
		clientes = clienteDao.buscarPorEstado("BA");
		
		//Exibir o nome do cliente e o estado
		System.out.println("Buscar clientes por estado:");
		clientes.forEach(c -> System.out.println(c.getNome() + " - " 
													+ c.getEndereco().getCidade().getUf()));
		
		//Pesquisar os clientes que possuem 10 dias de reserva
		clientes = clienteDao.buscarPorDiasReserva(10);
		
		//Exibir os clientes
		System.out.println("Buscar clientes por dias de reserva:");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Listar os clientes informando a primeira posição e o máximo de resultados (paginando)
		clientes = clienteDao.listar(1, 10);
		
		//Exibir os clientes
		System.out.println("Listar os clientes com paginação");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Pesquisar pacotes por preço, retornando a descrição e a qtd de dias (Object[])
		List<Object[]> listaObjetos = pacoteDao.buscarPorPrecoMenor(10000);
		System.out.println("Buscar por pacotes por preço menor, retornando um Object[]");
		listaObjetos.forEach(vetor -> System.out.println(vetor[0] + " " + vetor[1]));
		
		//Pesquisar pacotes por preço, retornando a descrição e a qtd de dias (Pacote)
		pacotes = pacoteDao.buscarPorPrecoMenor2(10000);
		//Exibir a descrição, qtd de dias e preco
		System.out.println("Buscar por pacotes por preço menor, retornando o objeto pacote");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getQtdDias() + " " + p.getPreco()));
		
		//Pesquisar pacotes por preço, retornando a descrição em uma lista de String
		List<String> listaString = pacoteDao.buscarPorPrecoMenor3(2500);
		//Exibir a descrição
		System.out.println("Buscar por pacotes por preço menor, retornando Strings");
		listaString.forEach(p -> System.out.println(p));
		
		//Pesquisar pacotes por data de saída
		Calendar inicio = new GregorianCalendar(2021, Calendar.JANUARY, 1);
		Calendar fim = new GregorianCalendar(2021, Calendar.DECEMBER, 1);
		pacotes = pacoteDao.buscarPorDatas(inicio, fim);
		
		//Exibir a descrição e a data de saída dos pacotes
		System.out.println("Buscar pacotes por data de saída");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + DataUtil.formatar(p.getDataSaida())));
		
		//Pesquisar clientes por parte do nome e parte do nome da cidade
		clientes = clienteDao.buscar("a", "Sal");
		System.out.println("Buscar clientes por parte do nome e parte do nome da cidade");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getNome()));
		
		//Pesquisar clientes por estados
		List<String> estados = new ArrayList<>();
		estados.add("SP");
		estados.add("BA");
		clientes = clienteDao.buscarPorEstados(estados);
		System.out.println("Buscar clientes por estados:");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf()));
		
		//Buscar cliente por nome sem case sensitive
		clientes = clienteDao.buscarPorNome2("a");
		System.out.println("Buscar cliente por nome sem case sensitive, ordenado por nome");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main
}//classe