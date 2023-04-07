package br.com.marco.banking.entities.base;

public interface Depositavel extends Conta{
    void depositar(double valor);
}
