package br.com.marco.banking.entities.base;

interface Conta {
    String getCpf();

    double getSaldo();

    String getNumConta();

    String getNumAgencia();

    void sacar(double valor);

    void depositar(double valor);

    boolean mesmaConta(Conta conta);

}
