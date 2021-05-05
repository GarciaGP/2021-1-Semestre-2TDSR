package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.entity.Cidade;

public interface CidadeDAO extends GenericDAO<Cidade,Integer>{

	//Buscar por todas as cidades
	List<Cidade> listar();
	
	//Buscar por todas as cidades que possuem o número de habitantes maior que
	List<Cidade> buscarPorNumeroHabitantesMaior(int numeroHabitantes);
	
}