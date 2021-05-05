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
	
}
