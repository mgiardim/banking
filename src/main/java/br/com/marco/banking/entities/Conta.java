package br.com.marco.banking.entities;

import javax.swing.*;
import java.util.Random;
import java.util.stream.IntStream;

public class Conta {
    private String cpf;
    private double saldo;
    private String numConta;
    private String numAgencia;

    public Conta(String cpf, String numAgencia) {
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

}
