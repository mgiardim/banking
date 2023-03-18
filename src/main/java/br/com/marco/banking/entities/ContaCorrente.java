package br.com.marco.banking.entities;

public class ContaCorrente {


    private Conta conta;

    public ContaCorrente(String cpf, String numAgencia){
        Conta conta = new Conta(cpf, numAgencia);
        this.conta = conta;
        conta.setTipo(TipoConta.CORRENTE);
    }


    public void setConta(String cpf, String numAgencia) {

    }
    public Conta getConta() {
        return conta;
    }
}
