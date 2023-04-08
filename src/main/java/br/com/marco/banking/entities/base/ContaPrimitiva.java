package br.com.marco.banking.entities.base;

import br.com.marco.banking.exceptions.DepositoInvalidoException;

import java.time.LocalDate;
import java.util.Random;

public abstract class ContaPrimitiva implements Conta {
    private String cpf;
    private double saldo;
    private String numConta;
    private String numAgencia;
    private LocalDate dataCriacao;
    private LocalDate dataAtualizacao;

    public ContaPrimitiva(String cpf, String numAgencia) {
        this.cpf = cpf;
        this.numAgencia = numAgencia;
        saldo = 0;
        numConta = String.valueOf(getRandomNumberInRange(1000, 9999));
        dataCriacao = LocalDate.now();
        dataAtualizacao = LocalDate.now();
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

    public void depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
        } else {
            throw new DepositoInvalidoException();
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

    public double setSaldo(double valor) {
        this.saldo = valor;
        return saldo;
    }

    public LocalDate getDataCriacao(){return dataCriacao;}

    public LocalDate getDataAtualizacao(){return dataAtualizacao;}

    public LocalDate setDataAtualizacao(LocalDate dataAtualizada){
        this.dataAtualizacao = dataAtualizada;
        return dataAtualizacao;}
}
