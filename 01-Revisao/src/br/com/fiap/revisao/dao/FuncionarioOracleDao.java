package br.com.fiap.revisao.dao;

import java.util.List;

import br.com.fiap.revisao.bean.Funcionario;

public class FuncionarioOracleDao implements FuncionarioDao {

	@Override
	public void cadastrar(Funcionario funcionario) {
		System.out.println("Cadastrando no oracle");
		//sysout -> CTRL + Space
	}

	@Override
	public List<Funcionario> listar() {
		System.out.println("Pesquisando no oracle");
		return null;
	}

}
