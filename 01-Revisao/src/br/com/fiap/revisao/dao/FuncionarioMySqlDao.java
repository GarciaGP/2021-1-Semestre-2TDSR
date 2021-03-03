package br.com.fiap.revisao.dao;

import java.util.List;

import br.com.fiap.revisao.bean.Funcionario;

public class FuncionarioMySqlDao implements FuncionarioDao {

	@Override
	public void cadastrar(Funcionario funcionario) {
		System.out.println("Cadastrando no MySql");
	}

	@Override
	public List<Funcionario> listar() {
		System.out.println("Pesquisando do MySql");
		return null;
	}

}
