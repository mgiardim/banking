package br.com.marco.banking.entities;

import br.com.marco.banking.entities.base.*;
import br.com.marco.banking.exceptions.TransferenciaInvalidaException;
import br.com.marco.banking.exceptions.SaqueInvalidoException;

public class ContaCorrente extends ContaPrimitiva implements Transferivel, Recebivel, Sacavel, Depositavel {

    public ContaCorrente(String cpf, String numAgencia) {
        super(cpf, numAgencia);
    }

    @Override
    public void sacar(double valor){
        double saldo = getSaldo();
        if (valor <= saldo) {
            saldo = saldo - valor;
            setSaldo(saldo);
        } else {
            throw new SaqueInvalidoException();
        }
    }
    @Override
    public void transferir(double valor, Recebivel contaDestino) {
        if(this.mesmaConta(contaDestino)){
            throw new TransferenciaInvalidaException();
        }
        sacar(valor);
        contaDestino.depositar(valor);
    }


}
