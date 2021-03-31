package br.com.fiap.tds.exception;

public class VeiculoNotFoundException extends Exception {

	public VeiculoNotFoundException() {
		super("Veiculo não encontrado");
	}
	
	public VeiculoNotFoundException(String msg){
		super(msg);
	}
	
}
