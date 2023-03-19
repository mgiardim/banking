package br.com.marco.banking.entities.base;

import java.util.Random;

public abstract class ContaPrimitiva implements Conta {
    private String cpf;
    private double saldo;
    private String numConta;
    private String numAgencia;

    public ContaPrimitiva(String cpf, String numAgencia) {
        this.cpf = cpf;
        this.numAgencia = numAgencia;
        saldo = 0;
        numConta = String.valueOf(getRandomNumberInRange(1000, 9999));
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumAgencia() {
        return numAgencia;
    }

    public String getNumConta() {
        return numConta;
    }

    public String getCpf() {
        return cpf;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo = saldo - valor;
        } else {
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
        } else {
            throw new RuntimeException("Valor do deposito invalido");
        }
    }

    public boolean mesmaConta(Conta conta) {
        String origemAgenciaConta = this.getNumAgencia() + this.getNumConta();
        String destinoAgenciaConta = conta.getNumAgencia() + conta.getNumConta();
        return origemAgenciaConta.equals(destinoAgenciaConta);
    }

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();
    }
}
