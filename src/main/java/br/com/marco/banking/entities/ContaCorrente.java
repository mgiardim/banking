package br.com.marco.banking.entities;

import br.com.marco.banking.entities.base.ContaPrimitiva;
import br.com.marco.banking.entities.base.Recebivel;
import br.com.marco.banking.entities.base.Transferivel;
import br.com.marco.banking.exceptions.TransferenciaInvalidaException;

public class ContaCorrente extends ContaPrimitiva implements Transferivel, Recebivel {

    public ContaCorrente(String cpf, String numAgencia) {
        super(cpf, numAgencia);
    }

    @Override
    public void transferir(double valor, Recebivel contaDestino) {
        if(this.mesmaConta(contaDestino)){
            throw new TransferenciaInvalidaException();
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
}
