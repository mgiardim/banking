package br.com.marco.banking.entities;

import java.util.Random;

public class Conta {
    private String cpf;
    private double saldo;
    private String numConta;
    private String numAgencia;

    private TipoConta tipoConta;

     Conta(String cpf, String numAgencia) {
        this.cpf = cpf;
        this.numAgencia = numAgencia;
        saldo = 0;
        numConta = String.valueOf(getRandomNumberInRange(1000, 9999));
    }

    private static int getRandomNumberInRange(int min, int max) {

        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();

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

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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

    public void transferencia(double valor,Conta contaOrigem, Conta contaDestino){
         double saldo;
         String origemAgenciaConta = contaOrigem.getNumAgencia() + contaOrigem.getNumConta();
         String destinoAgenciaConta = contaDestino.getNumAgencia() + contaDestino.getNumConta();
         if(contaDestino.getTipo() != TipoConta.SALARIO) {
             if (origemAgenciaConta != destinoAgenciaConta) {
                 if (contaOrigem.getSaldo() >= valor) {
                     saldo = contaOrigem.getSaldo() - valor;
                     contaOrigem.setSaldo(saldo);
                     contaDestino.setSaldo(contaDestino.getSaldo() + valor);
                 } else {
                     throw new RuntimeException("Valor do saldo insuficiente");
                 }
             }
         }
    }

    public TipoConta getTipo() {
        return tipoConta;
    }

    public void setTipo(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

}
