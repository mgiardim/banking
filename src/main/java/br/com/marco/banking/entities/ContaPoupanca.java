package br.com.marco.banking.entities;

import br.com.marco.banking.entities.base.ContaPrimitiva;
import br.com.marco.banking.entities.base.Depositavel;
import br.com.marco.banking.entities.base.Recebivel;
import br.com.marco.banking.entities.base.Sacavel;
import br.com.marco.banking.exceptions.SaqueInvalidoException;

public class ContaPoupanca extends ContaPrimitiva implements Sacavel, Recebivel, Depositavel {
    public ContaPoupanca(String cpf, String numAgencia) {
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
}