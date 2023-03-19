package br.com.marco.banking.entities;

import br.com.marco.banking.entities.base.Recebivel;
import br.com.marco.banking.entities.base.Transferivel;
import br.com.marco.banking.exceptions.TransferenciaInvalidaException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContaCorrenteTeste {

    @Test
    @DisplayName("""
            Dado que tenho uma conta origem com saldo 1500
            E uma conta destino com saldo 500
            Quando transferir 500 reais da conta origem
            Entao conta origem tera um saldo de 1000
            e a conta destino tera o saldo de 1000
            """)
    void testTransferenciaValida() {
        Transferivel contaOrigem = new ContaCorrente("111111111", "0001");
        Recebivel contaDestino = new ContaCorrente("222222222", "0002");
        contaOrigem.depositar(1500.0);
        contaDestino.depositar(500.0);
        contaOrigem.transferir(500.0, contaDestino);
        assertEquals(1000.0, contaOrigem.getSaldo());
        assertEquals(1000.0, contaDestino.getSaldo());
    }

    @Test
    @DisplayName("""
            Dado que a contaAbstract origem e a mesma contaAbstract do destino
            Entao deve exibir um erro de contas iguais
            """)
    void testTransferenciaInvalida() {
        ContaCorrente contaOrigem = new ContaCorrente("111111111", "0001");
        assertThrows(TransferenciaInvalidaException.class, () -> contaOrigem.transferir(500.0, contaOrigem));
    }
}
