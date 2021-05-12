package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Reserva;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	//2 - Pesquisar o cliente por parte do nome
	List<Cliente> buscarPorNome(String nome);
	
	//4 - Pesquisar clientes por estado
	List<Cliente> buscarPorEstado(String estado);
	
	//5 - Pesquisar clientes por qtd de dias de reserva
	List<Cliente> buscarPorDiasReserva(int dias);
	
	//7 - Pesquisar por parte do nome e parte do nome da cidade
	List<Cliente> buscar(String nome, String cidade);
	
	//8 - Pesquisar por estados
	List<Cliente> buscarPorEstados(List<String> estados);
	
	//10- Buscar por parte do nome, sem diferenciar as maiúsculas e minúsculas, ordenando por nome
	List<Cliente> buscarPorNome2(String nome);
	
	//11 - Contar a qtd por estado
	long contarPorEstado(String estado);
	
}
