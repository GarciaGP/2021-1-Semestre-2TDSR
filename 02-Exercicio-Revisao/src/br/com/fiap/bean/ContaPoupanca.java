package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

//CTRL + 1
public class ContaPoupanca extends Conta implements ContaInvestimento {

	private float taxa;
	
	//Constante
	//final: na classe -> não pode ser herdada
	// no método e no atributo -> não permite a sobrescrita
	//static: o elemento passa a ser da classe e não do objeto
	public static final float RENDIMENTO = 0.04f;
	
	@Override
	public double calculaRetornoInvestimento() {
		return saldo * RENDIMENTO;
	}

//	@Override
//	public void depositar(double valor) {
//		saldo += valor;
//	}

	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		if (valor + taxa > saldo) {
			throw new SaldoInsuficienteException(saldo);
		}
		saldo -= valor + taxa;
	}

	//CTRL + 3 -> gcuf
	public ContaPoupanca() {}

	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}