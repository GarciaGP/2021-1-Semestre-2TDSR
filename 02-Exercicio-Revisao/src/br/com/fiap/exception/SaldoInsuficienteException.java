package br.com.fiap.exception;

@SuppressWarnings("all")
public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException() {}

	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
	
	public SaldoInsuficienteException(double saldo) {
		super("Saldo insuficiente, limite disponível: " + saldo);
	}
	
}