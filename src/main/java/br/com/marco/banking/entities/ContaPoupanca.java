package br.com.marco.banking.entities;

public class ContaPoupanca {
    private Conta conta;
    public void setConta(String cpf, String numAgencia) {
        Conta conta = new Conta(cpf, numAgencia);
        this.conta = conta;
        conta.setTipo(TipoConta.POUPANCA);
    }

}
