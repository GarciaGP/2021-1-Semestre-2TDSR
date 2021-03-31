package br.com.fiap.tds.dao;

import br.com.fiap.tds.entity.Veiculo;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.VeiculoNotFoundException;

// View - Controller (VeiculoDao) - DAO - Banco

public interface VeiculoDao {

	void add(Veiculo veiculo);
	
	Veiculo read(int codigo) throws VeiculoNotFoundException;
	
	void update(Veiculo veiculo);
	
	void delete(int codigo) throws VeiculoNotFoundException;
	
	void commit() throws CommitException;
	
}