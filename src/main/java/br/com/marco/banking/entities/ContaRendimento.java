package br.com.marco.banking.entities;

import br.com.marco.banking.entities.base.*;
import br.com.marco.banking.exceptions.RentabilidadeInvalidaException;
import br.com.marco.banking.exceptions.SaqueInvalidoException;
import br.com.marco.banking.exceptions.TransferenciaInvalidaException;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class ContaRendimento extends ContaPrimitiva implements Rendavel, Sacavel, Transferivel, Recebivel {

    public ContaRendimento(String cpf, String numAgencia) {
        super(cpf, numAgencia);
        LocalDate dataCriacao = LocalDate.now();
        LocalDate dataAtualizacaoRendimento = LocalDate.now();
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

    @Override
    public void render(double rentabilidade){
        double saldo = getSaldo();
        LocalDate dataAtualizacaoRendimento = getDataAtualizacao();
        long tempoEntreDatas = ChronoUnit.MONTHS.between(
                YearMonth.from(dataAtualizacaoRendimento),
                YearMonth.from(LocalDate.parse("2023-06-07"))
                        //YearMonth.from(LocalDate.now()
        );
        if((tempoEntreDatas > 0)&&(rentabilidade > 0)){
            setDataAtualizacao(LocalDate.now());
            double renda = saldo * rentabilidade;
            setSaldo(saldo+renda);
        }
        else {
            throw new RentabilidadeInvalidaException();
        }
    }
}
