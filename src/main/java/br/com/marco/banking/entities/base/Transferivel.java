package br.com.marco.banking.entities.base;

public interface Transferivel extends Conta {
    void transferir(double valor, Recebivel contaDestino);

}
