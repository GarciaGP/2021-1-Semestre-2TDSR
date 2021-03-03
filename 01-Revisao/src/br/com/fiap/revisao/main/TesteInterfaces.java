package br.com.fiap.revisao.main;

import br.com.fiap.revisao.bean.Funcionario;
import br.com.fiap.revisao.dao.FuncionarioDao;
import br.com.fiap.revisao.dao.FuncionarioMySqlDao;

public class TesteInterfaces {

	public static void main(String[] args) {
		//Instanciar um objeto do tipo FuncionarioDao
		FuncionarioDao dao = new FuncionarioMySqlDao();
		dao.cadastrar(new Funcionario());
	}
	
}